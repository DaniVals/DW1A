package EjerciciosObjetos2.O10MagoPaladinArqueroInterfaz;

public class Duende extends Monstruo{

    public Duende() {
        super(10, 10, 2);
    }

    @Override
    public void descansar() {
        this.cambiarVida(+2);
    }

    @Override
    public void atacar(InterfazTropa i) {
        if (i instanceof Personaje) {
            Personaje p = (Personaje) i;
            p.cambiarVida(this.getAtaque());
        }
    }
    
}
