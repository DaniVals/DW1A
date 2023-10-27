package EjerciciosObjetos.O05Automovil;

/*
Un método para calcular el tiempo estimado de llegada, utilizando
como parámetro la distancia a recorrer en kilómetros. El tiempo
estimado se calcula como el cociente entre la distancia a recorrer y
la velocidad actual.
*/
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
