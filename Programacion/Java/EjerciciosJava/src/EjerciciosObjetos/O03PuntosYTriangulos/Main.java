package EjerciciosObjetos.O03PuntosYTriangulos;

public class Main {
    public static void main(String[] args) {

        Punto p1;
        Rectangulo r1, r2;

        p1 = new Punto(3, 6);
        r1 = new Rectangulo();
        r2 = new Rectangulo();

        r1.setOrigen(p1);
        r2.setOrigen2(5, 8);

        System.out.println(p1.getPunto());
        System.out.println(r1);
        System.out.println(r2);

        


    }
}
