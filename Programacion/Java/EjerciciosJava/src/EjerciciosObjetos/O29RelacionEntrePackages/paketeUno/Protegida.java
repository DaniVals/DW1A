package EjerciciosObjetos.O29RelacionEntrePackages.paketeUno;

public class Protegida extends Publica{
    private int callaCagada;
    
    public Protegida(boolean publico, int callaCagada) {
        super(publico);
        this.callaCagada = callaCagada;
    }

    public void metodo(){
        Publica p=new Publica(true);
        p.publico=false;
        p.protegido=false;
        p.vacio=false;
    }

    public int getCallaCagada() {
        return callaCagada;
    }

    public void setCallaCagada(int callaCagada) {
        this.callaCagada = callaCagada;
    }
}
