package EjerciciosObjetos2.O04Formas;

public class Main {
    public static void main(String[] args){

        Rectangulo r1 = new Rectangulo("000000", new Punto(0, 0), 1, 2);

        System.out.println(r1);
        System.out.println(r1.calcArea());
        System.out.println(r1.calcPerimetro());
        r1.cambiarTamaño(2);
        System.out.println(r1);
        System.out.println(r1.calcArea());
        System.out.println(r1.calcPerimetro());
        
    }
}
