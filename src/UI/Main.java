package UI;

import java.util.Scanner;

import static negocio.MetodosComuns.variasLinhas;
import static negocio.usuario.UsersActions.cadastro;
import static negocio.usuario.UsersActions.login;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        firstPage();
    }

    public static void firstPage() {
        while (true) {
            variasLinhas();
            System.out.println("___________________________________");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Login");
            System.out.println("3 - Sair");

            try {
                switch (scanner.nextInt()) {
                    case 1:
                        scanner.nextLine();
                        cadastro();
                        break;
                    case 2:
                        scanner.nextLine();
                        login();
                        break;
                    case 3:
                        variasLinhas();
                        System.out.println("Obrigado!");
                        System.exit(0);
                    default:
                        scanner.nextLine();
                        variasLinhas();
                        System.out.println("Digite um número válido!");
                        break;
                }
            } catch (Exception e) {
                scanner.nextLine();
                variasLinhas();
                System.out.println("Digite um número válido!");
            }
        }
    }

}
