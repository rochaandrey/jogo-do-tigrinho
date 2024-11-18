package negocio.baralho;

public class Cartas {
    private final CorCarta corCarta;
    private final Naipes naipes;
    private TipoCarta tipoCarta;
    private int valor;

    public Cartas(CorCarta corCarta, Naipes naipes, TipoCarta tipoCarta,int valor) {
        this.corCarta = corCarta;
        this.naipes = naipes;
        this.tipoCarta = tipoCarta;
        this.valor = valor;
    }

    public CorCarta getCorCarta() {
        return corCarta;
    }

    public Naipes getNaipes() {
        return naipes;
    }

    public TipoCarta getTipoCarta() {
        return tipoCarta;
    }

    public int getValor() {
        return valor;
    }

    public void setTipoCarta(TipoCarta tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        if(tipoCarta == TipoCarta.NUMERO) {
            if(valor==1){
                return "Ás de "+naipes;
            }else{
                return valor + " de " + naipes;
            }
        }
        return tipoCarta + " de " + naipes + " = " + valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartas cartas = (Cartas) o;
        return naipes == cartas.naipes && tipoCarta == cartas.tipoCarta;
    }

}
