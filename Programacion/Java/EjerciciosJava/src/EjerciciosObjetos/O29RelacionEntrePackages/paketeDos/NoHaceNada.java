package EjerciciosObjetos.O29RelacionEntrePackages.paketeDos;

import EjerciciosObjetos.O29RelacionEntrePackages.paketeUno.Publica;

public class NoHaceNada extends Publica {
    private int callaCagada;
    
    public NoHaceNada(boolean publico, int callaCagada) {
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
