package EjerciciosObjetos2.O10MagoPaladinArqueroInterfaz;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Personaje> panda = new ArrayList<Personaje>();
        ArrayList<Monstruo> enemigos = new ArrayList<Monstruo>();
        panda.add(new Paladin());
        panda.add(new Mago(3, 5, 1));

        enemigos.add(new Duende());
        enemigos.add(new Duende());
        enemigos.add(new Duende());

        System.out.println(panda.get(0));
        panda.get(0).descansar();
        panda.get(1).descansar();
        panda.get(1).promocionar();


        if (panda.get(1) instanceof Mago) {
            Mago g1 = (Mago) panda.get(1);
            g1.curarAliado(panda.get(0));
        }
    }
    
}
