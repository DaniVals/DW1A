package EjerciciosObjetos2.O01RelacionEntrePackages.paketeDos;

import EjerciciosObjetos2.O01RelacionEntrePackages.paketeUno.Publica;

public class Privado extends Publica {
    private int callaCagada;
    
    public Privado(boolean publico, int callaCagada) {
        super(publico);
        this.callaCagada = callaCagada;
    }

    public int getCallaCagada() {
        return callaCagada;
    }

    public void setCallaCagada(int callaCagada) {
        this.callaCagada = callaCagada;
    }

    public void metodo(){
        Publica p=new Publica(true);
        p.publico=false;
    }
}
