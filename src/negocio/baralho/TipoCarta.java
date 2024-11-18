package negocio.baralho;

public enum TipoCarta {
    NUMERO("Número"),
    REI("Rei"),
    RAINHA("Rainha"),
    VALETE("Valete");

    private final String tipoCarta;

    TipoCarta(String tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

    public String getTipoCarta() {
        return tipoCarta;
    }

}
