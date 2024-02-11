package EjerciciosObjetos2.O08Interfaces;

public class Main {
    public static void main(String[] args) {
        Cola c1=new Cola();
        System.out.println(c1);
        c1.meter(2);
        c1.meter(21);
        c1.meter(23);
        System.out.println(c1);
        System.out.println(c1.sacar());
        System.out.println(c1);

        Fila f1=new Fila();
        System.out.println(f1);
        f1.meter(41);
        f1.meter(3);
        f1.meter(13);
        System.out.println(f1);
        System.out.println(f1.sacar());
        System.out.println(f1);
        
    }
}
