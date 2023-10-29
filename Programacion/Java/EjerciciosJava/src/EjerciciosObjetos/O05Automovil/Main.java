package EjerciciosObjetos.O05Automovil;

public class Main {
    public static void main(String[] args) {

        Automovil coche;
        coche=new Automovil('B', 'A', '7', 'D', 'R', 5, 4, 150, 100);

        coche.duracionViaje(1000);
        coche.acelerar(20);
        coche.duracionViaje(1000);
        coche.desacelerar(50);
        coche.duracionViaje(1000);
        coche.frenar();
    }
}
