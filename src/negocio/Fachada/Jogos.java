package negocio.Fachada;

public enum Jogos {
    VINTEUM("Vinte-um",1);

    private final String name;
    private final int value;

    Jogos(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
