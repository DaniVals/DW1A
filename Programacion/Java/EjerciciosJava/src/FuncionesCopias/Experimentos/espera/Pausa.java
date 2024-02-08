package FuncionesCopias.Experimentos.espera;

public class Pausa {
    public static void mili(int ms){
        long tiempoActual=System.currentTimeMillis();
        while (System.currentTimeMillis()<tiempoActual+ms-8) {
        }
    }
}
