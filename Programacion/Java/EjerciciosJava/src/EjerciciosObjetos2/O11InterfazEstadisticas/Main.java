package EjerciciosObjetos2.O11InterfazEstadisticas;

public class Main {
    public static void main(String[] args) {
        ListaNumeros l = new ListaNumeros();
        
        l.meter(2);
        l.meter(102);
        l.meter(-20);
        l.meter(88);
        l.meter(4);
        
        System.out.println(l.max());
        System.out.println(l.min());
        System.out.println(l.media());
        System.out.println(l.toString());
        System.out.println(l.toArray()+" -> "+l.toArray()[0]);
        
        ArrayNumeros a = new ArrayNumeros();
        
        a.meter(2);
        a.meter(102);
        a.meter(-20);
        a.meter(88);
        a.meter(4);

        System.out.println(a.max());
        System.out.println(a.min());
        System.out.println(a.media());
        System.out.println(a.toString());
        System.out.println(a.toArray()+" -> "+a.toArray()[0]);
    }
}
