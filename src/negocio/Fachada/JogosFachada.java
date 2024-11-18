package negocio.Fachada;

import dados.vinteum.VinteUm;
import negocio.usuario.UsersActions;
import negocio.usuario.Usuario;

import java.util.Scanner;

import static UI.Main.firstPage;
import static UI.RulesGamesBaseTexts.acoesDisponiveis;
import static negocio.MetodosComuns.variasLinhas;

public class JogosFachada {
    static Scanner scanner = new Scanner(System.in);
    Usuario usuario;

    public JogosFachada(Usuario usuario) {
        this.usuario = usuario;
    }

    public void escolherJogo(){
        int i;
        do {
            i = 0;
            variasLinhas();
            System.out.println("0 - Sair");

            for (Jogos value : Jogos.values()) {
                System.out.println(value.getValue() + " - " + value.getName());
            }

            System.out.println();
            System.out.println("Qual jogo deseja jogar? ");

            try {
                i = scanner.nextInt();
                scanner.nextLine();
            }catch (IllegalArgumentException e){
                scanner.nextLine();
            }

            if(i == 1 ){
                new VinteUm(usuario).jogar();
            }
        }while(i!=0);
        executarAcao();
    }

    public void executarAcao() {
        while (true) {
            variasLinhas();
            try {
                acoesDisponiveis();

                switch (scanner.nextInt()) {
                    case 1:
                        scanner.nextLine();
                        UsersActions.selecionarSaldoADD(usuario);
                        break;
                    case 2:
                        scanner.nextLine();
                        escolherJogo();
                        break;
                    case 3:
                        scanner.nextLine();
                        UsersActions.atualizarDados(usuario);
                        break;
                    case 4:
                        scanner.nextLine();
                        firstPage();
                        return;
                    default:
                        scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                scanner.nextLine();
            }
        }
    }


}
