package EjerciciosObjetos.O04Baloncesto;

public class Main {
    public static void main(String[] args) {

        Jugador j1, j2;

        j1=new Jugador();
        j2=new Jugador(1.75, 0.9, 0.35);

        System.out.println(j1);
        System.out.println(j2);

        j1.entrenarDiasTriples(6);
        j2.entrenarDiasDobles(6);
        
        System.out.println(j1);
        System.out.println(j2);

    }
}
