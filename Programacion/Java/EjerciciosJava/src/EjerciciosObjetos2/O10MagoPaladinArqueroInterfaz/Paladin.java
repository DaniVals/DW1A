package EjerciciosObjetos2.O10MagoPaladinArqueroInterfaz;

public class Paladin extends Personaje{

    private boolean bendecido;

    public Paladin() { //estadisticas iniciales fijas
        super(20, 20, 4);
        this.bendecido=false;
    }

    public boolean isBendecido() {
        return bendecido;
    }

    public void setBendecido(boolean bendecido) {
        this.bendecido = bendecido;
    }
    @Override
    public String toString() {
        return "Paladin ["+super.toString()+",  SCRD:"+bendecido+"]";
    }

    public void bendecido(){
        this.bendecido=true;
        System.out.println("Paladin bendecido");
    }

    @Override
    public void descansar() {
        System.out.println("caballero descansa");
    }

    @Override
    public void atacar(InterfazTropa i) {
        System.out.println("caballero ataca");
    }

    @Override
    public void promocionar() {
        System.out.println("caballero promociona");
    } 

}
