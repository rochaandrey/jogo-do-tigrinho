package UI;

public class RulesGamesBaseTexts {

    public static void vinteUmRegras(){
        System.out.println("_____________________________________________________________");
        System.out.println("REGRAS: ");
        System.out.println("Você está jogando contra o mestre da sala! ");
        System.out.println("cada carta possui um valor!" +
                "\nAquele que ultrapassar de 21 perde!");
        System.out.println("Caso ambos passem de 21, aquele que tiver menor número ganha!");
        System.out.println("_____________________________________________________________");
    }

    public static void acoesDisponiveis(){
        System.out.println("1 - Adicionar saldo");
        System.out.println("2 - Jogar");
        System.out.println("3 - Atualizar dados");
        System.out.println("4 - Sair");
    }
}
