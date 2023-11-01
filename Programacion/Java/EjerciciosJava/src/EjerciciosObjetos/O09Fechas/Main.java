package EjerciciosObjetos.O09Fechas;

public class Main {
    public static void main(String[] args){

        Fecha f1, f2;
        f1=new Fecha(18, 10, 2003);
        f2=new Fecha(8, 10, 2004);
        
        System.out.println(f1.calcularDias(f2));
        
    }
}
