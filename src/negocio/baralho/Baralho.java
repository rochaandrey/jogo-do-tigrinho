package negocio.baralho;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {
    public static final List<Cartas> baralhoList = new ArrayList<>();

    public Baralho(){
        for(Naipes naipe: Naipes.values()){
            for(int i=1;i<=13;i++){
                Cartas cartaV = new Cartas(CorCarta.VERMELHA,naipe,TipoCarta.NUMERO,i);
                Cartas cartaA = new Cartas(CorCarta.AZUL,naipe,TipoCarta.NUMERO,i);

                 if (i == 11) {
                    cartaV.setTipoCarta(TipoCarta.VALETE);
                    cartaA.setTipoCarta(TipoCarta.VALETE);
                    cartaV.setValor(11);
                    cartaA.setValor(11);
                 } else if (i == 12) {
                     cartaV.setTipoCarta(TipoCarta.RAINHA);
                     cartaA.setTipoCarta(TipoCarta.RAINHA);
                     cartaV.setValor(12);
                     cartaA.setValor(12);
                } else if (i == 13) {
                     cartaV.setTipoCarta(TipoCarta.REI);
                     cartaA.setTipoCarta(TipoCarta.REI);
                     cartaV.setValor(13);
                     cartaA.setValor(13);
                }

                baralhoList.add(cartaV);
                baralhoList.add(cartaA);
            }
        }
    }

    public Cartas sortearCarta(){
        Random random = new Random();
        return baralhoList.get(random.nextInt(0,baralhoList.size()));
    }


}
