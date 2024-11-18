package dados.vinteum;

import dados.Jogavel;
import negocio.Fachada.JogosFachada;
import negocio.baralho.Baralho;
import negocio.baralho.Cartas;
import negocio.usuario.Usuario;

import java.util.Scanner;

import static UI.RulesGamesBaseTexts.vinteUmRegras;
import static dados.vinteum.jogarVinteUm.comparar;
import static dados.vinteum.jogarVinteUm.jogarRound;
import static negocio.MetodosComuns.variasLinhas;

public class VinteUm implements Jogavel {
    Baralho baralho;
    Usuario usuario;

    public VinteUm(Usuario usuario){
        baralho = new Baralho();
        this.usuario = usuario;
    }

    @Override
    public void jogar(){
        Scanner scanner = new Scanner(System.in);
        Cartas randomCard;
        final String PC = "MESTRE";
        int userPoints = 0;
        int pcPoints = 0;
        boolean parar;
        double aposta;

        aposta  = apostar(usuario);

        if(aposta == 0){
            new JogosFachada(usuario).executarAcao();
            return;
        }

        vinteUmRegras();
        scanner.nextLine();

        do{
            variasLinhas();

            System.out.println(PC+" | PONTOS = ???");
            System.out.println("SEUS PONTOS = "+ userPoints);
            System.out.println("-----------------------------------------------------");
            System.out.println("Deseja jogar? ");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            switch (scanner.nextLine()){
                case "1":
                    randomCard = jogarRound(baralho);
                    pcPoints += randomCard.getValor();

                    randomCard = jogarRound(baralho);
                    userPoints += randomCard.getValor();
                    System.out.println(randomCard);
                    scanner.nextLine();
                    parar = false;
                    break;
                case "2":
                    variasLinhas();
                    comparar(userPoints, pcPoints, usuario, aposta);
                    parar = true;
                    break;
                default:
                    parar = false;
            }
        }while(!parar);

        scanner.nextLine();
    }
}
