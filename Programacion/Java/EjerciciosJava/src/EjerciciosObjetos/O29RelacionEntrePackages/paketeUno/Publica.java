package EjerciciosObjetos.O29RelacionEntrePackages.paketeUno;

public class Publica {
    public boolean publico;
    protected boolean protegido;
    boolean vacio;
    private boolean privado;

    
    public Publica(boolean publico) {
        this.publico = publico;
        this.protegido = publico;
        this.vacio = publico;
        this.privado = publico;
    }


    public boolean metodo2(){
        Publica p=new Publica(true);
        p.publico=false;
        p.protegido=false;
        p.vacio=false;
        p.privado=false;
        return privado;
    }
}
