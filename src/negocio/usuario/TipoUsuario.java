package negocio.usuario;

public enum TipoUsuario {
    NORMAL(0),
    GANHADOR(1);

    private final int value;

    TipoUsuario(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
