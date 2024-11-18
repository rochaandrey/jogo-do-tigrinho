package negocio.baralho;

public enum Naipes {
    PAUS("Paus"),
    ESPADAS("Espadas"),
    OUROS("Ouros"),
    COPAS("Copas");

    private final String naipe;

    Naipes(String naipe) {
        this.naipe = naipe;
    }
}
