package dados.vinteum;

import negocio.baralho.Baralho;
import negocio.baralho.Cartas;
import negocio.usuario.Usuario;

import java.util.Random;

import static negocio.usuario.UsersActions.adicionarSaldo;
import static negocio.usuario.UsersActions.retirarSaldo;

public class jogarVinteUm {
    public static Cartas jogarRound(Baralho baralho){
        return baralho.sortearCarta();
    }

    public static void comparar(int userPoints, int pcPoints, Usuario usuario, double aposta){
        Random random = new Random();

        if(usuario.getTipoUsuario().getValue()==0) {

            int azar = random.nextInt(0, 7);

            if (azar != 0) {
                if (userPoints != 21) {
                    System.out.println("MESTRE | PONTOS = 21");
                    System.out.println("SEUS PONTOS = " + userPoints);

                    System.out.println("você perdeu! ");
                    retirarSaldo(usuario, aposta);
                    System.out.println(usuario.getNome() + " saldo : " + usuario.getSaldo());
                } else {
                    System.out.println("MESTRE | PONTOS = 21");
                    System.out.println("SEUS PONTOS = " + userPoints);

                    System.out.println("empate!");
                    System.out.println(usuario.getNome() + " saldo : " + usuario.getSaldo());
                }
            }

            if (azar == 0) {
                if (userPoints == pcPoints) {
                    System.out.println("MESTRE | PONTOS = " + pcPoints);
                    System.out.println("SEUS PONTOS = " + userPoints);

                    System.out.println("empate!");
                    System.out.println(usuario.getNome() + " saldo : " + usuario.getSaldo());
                } else if (userPoints < pcPoints && userPoints >= 21) {
                    System.out.println("MESTRE | PONTOS = " + pcPoints);
                    System.out.println("SEUS PONTOS = " + userPoints);

                    System.out.println("você ganhou");
                    adicionarSaldo(usuario, aposta);
                    System.out.println(usuario.getNome() + " saldo : " + usuario.getSaldo());
                } else if (userPoints > pcPoints && userPoints <= 21) {
                    System.out.println("MESTRE | PONTOS = " + pcPoints);
                    System.out.println("SEUS PONTOS = " + userPoints);

                    System.out.println("você ganhou");
                    adicionarSaldo(usuario, aposta);
                    System.out.println(usuario.getNome() + " saldo : " + usuario.getSaldo());
                } else {
                    System.out.println("MESTRE | PONTOS = " + pcPoints);
                    System.out.println("SEUS PONTOS = " + userPoints);

                    System.out.println("você perdeu! ");
                    retirarSaldo(usuario, aposta);
                    System.out.println(usuario.getNome() + " saldo : " + usuario.getSaldo());
                }
            }

        }else{
            if (userPoints == pcPoints) {
                System.out.println("MESTRE | PONTOS = " + pcPoints);
                System.out.println("SEUS PONTOS = " + userPoints);

                System.out.println("empate!");
                System.out.println(usuario.getNome() + " saldo : " + usuario.getSaldo());
            } else if (userPoints < pcPoints && userPoints >= 21) {
                System.out.println("MESTRE | PONTOS = " + pcPoints);
                System.out.println("SEUS PONTOS = " + userPoints);

                System.out.println("você ganhou");
                adicionarSaldo(usuario, aposta);
                System.out.println(usuario.getNome() + " saldo : " + usuario.getSaldo());
            } else if (userPoints > pcPoints && userPoints <= 21) {
                System.out.println("MESTRE | PONTOS = " + pcPoints);
                System.out.println("SEUS PONTOS = " + userPoints);

                System.out.println("você ganhou");
                adicionarSaldo(usuario, aposta);
                System.out.println(usuario.getNome() + " saldo : " + usuario.getSaldo());
            } else {
                System.out.println("MESTRE | PONTOS = " + pcPoints);
                System.out.println("SEUS PONTOS = " + userPoints);

                System.out.println("você perdeu! ");
                retirarSaldo(usuario, aposta);
                System.out.println(usuario.getNome() + " saldo : " + usuario.getSaldo());
            }
        }
    }
}
