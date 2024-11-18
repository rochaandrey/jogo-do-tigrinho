package dados;

import negocio.usuario.Usuario;

import java.math.BigDecimal;
import java.util.Scanner;

import static negocio.MetodosComuns.variasLinhas;

public interface Jogavel {
    void jogar();

    default double apostar(Usuario usuario){
        Scanner scanner = new Scanner(System.in);
        BigDecimal value = BigDecimal.ZERO;
        boolean valid;

        do{
            try {
                variasLinhas();
                System.out.println("Quanto deseja apostar?");
                System.out.println("saldo: "+usuario.getSaldo());

                value = BigDecimal.valueOf(scanner.nextDouble());
                scanner.nextLine();

                if (value.compareTo(BigDecimal.ZERO) > 0 && value.compareTo(usuario.getSaldo()) <= 0) {
                    valid = true;
                } else {
                    System.out.println("Valor inválido! Você não possui esse dinheiro, adicione antes de jogar");
                    scanner.nextLine();
                    value = BigDecimal.ZERO;
                    valid = true;
                }

            }catch(IllegalArgumentException e){
                scanner.nextLine();
                valid = false;
            }
        }while(!valid);

        return value.doubleValue();
    }
}
