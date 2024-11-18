package negocio.usuario;

import UI.SaldoInvalidoException;
import dados.listas.ListUsers;
import negocio.Fachada.JogosFachada;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import static dados.listas.ListUsers.userByINDEX;
import static dados.listas.ListUsers.usuarioExist;
import static negocio.MetodosComuns.variasLinhas;

public class UsersActions {
    static Scanner scanner = new Scanner(System.in);

    public static String pedirCPF(){
        String cpf = "";
        variasLinhas();
        do{
            System.out.println("___________________________________");
            System.out.println("Digite seu cpf: ");

            try {
                cpf = scanner.nextLine().replaceAll("[^0-9]","");
            } catch (InputMismatchException e) {
                variasLinhas();
                System.out.println("CPF INVÁLIDO! USE APENAS NÚMEROS ");
            }

            if(cpf.length()!=11){
                variasLinhas();
                System.out.println("CPF INVÁLIDO! DIGITE OS 11 NÚMEROS CORRETAMENTE ");
            }
        }while(cpf.length()!=11);
        return cpf;
    }

    public static String pedirNome(){
        String nome;
        variasLinhas();
        do {
            System.out.println("___________________________________");
            System.out.println("Digite seu nome COMPLETO: ");
            nome = scanner.nextLine();

            if (isValidName(nome)) {
                variasLinhas();
                System.out.println("Escreva seu nome completo");
            }
        } while (isValidName(nome));
        return nome;
    }

    public static boolean isValidName(String nome){
        String[] parts = nome.trim().split("\\s+");
        return parts.length < 3;
    }

    public static void cadastro(){
        String nome;
        String cpf;

        nome = pedirNome();
        cpf = pedirCPF();

        int verificador = usuarioExist(new Usuario(cpf));

        if(verificador != -1){
            System.out.println("Esse usuario ja existe");
        }else{
            Usuario usuario= new Usuario(nome,cpf);
            ListUsers.addList(usuario);
            System.out.println("Usuário criado!");
        }

        scanner.nextLine();
        variasLinhas();

    }

    public static void login(){
        String cpf;

        variasLinhas();
        cpf = pedirCPF();

        int verificador = usuarioExist(new Usuario(cpf));

        if(verificador != -1){
            JogosFachada fachada = new JogosFachada(userByINDEX(verificador)); // está no plural pq caso queira adicionar mais jogos, a lógica funciona
            fachada.executarAcao();
        }else{
            variasLinhas();
            System.out.println("o usuário NÃO EXISTE na base de dados");
            scanner.nextLine();
        }
    }

    public static void atualizarDados(Usuario usuario){
        usuario.setNome(pedirNome());

        System.out.println("Nome atualizado com sucesso!");
        scanner.nextLine();
        variasLinhas();
    }

    public static void adicionarSaldo(Usuario usuario, double valor){
        usuario.setSaldo(usuario.getSaldo().add(BigDecimal.valueOf(valor)));
    }
    public static void retirarSaldo(Usuario usuario, double valor){
        usuario.setSaldo(usuario.getSaldo().subtract(BigDecimal.valueOf(valor)));
    }

    public static void selecionarSaldoADD(Usuario usuario){
        double saldoAdd;

        while (true) {
            variasLinhas();
            try {
                System.out.println("Digite o valor a ser adicionado ao saldo: ");
                System.out.println("saldo atual: "+usuario.getSaldo());
                saldoAdd = scanner.nextDouble();
                scanner.nextLine();

                if (saldoAdd >= 0) {
                    System.out.println("Saldo adicionado: " + saldoAdd);
                    adicionarSaldo(usuario,saldoAdd);
                    scanner.nextLine();
                    break;
                } else {
                    throw new SaldoInvalidoException("O valor deve ser maior que zero.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Valor inválido! Por favor, insira um número.");
                scanner.nextLine();
            } catch (SaldoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        }
    }


