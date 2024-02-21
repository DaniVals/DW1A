package EjerciciosObjetos2.O10MagoPaladinArqueroInterfaz;

public class Mago extends Personaje implements InterfazCurador{

    public Mago(int vida, int vidaMax, int ataque) {
        super(vida, vidaMax, ataque);
    }

    @Override
    public void curarAliado(InterfazTropa p) {
        System.out.println("mago cura a "+p);
    }

    @Override
    public void descansar() {
        System.out.println("mago descansa");
    }

    @Override
    public void atacar(InterfazTropa p) {
        System.out.println("mago ataca");
    }

    @Override
    public void promocionar() {
        System.out.println("mago promociona");
    }
    @Override
    public String toString() {
        return "Mago ["+super.toString()+"]";
    }
}
