package EjerciciosObjetos.O09Fechas;

public class Main {
    public static void main(String[] args){

        Fecha f1, f2;
        f1=new Fecha(22, 3, 2001);
        f2=new Fecha(28, 4, 2001);
        
        System.out.println(f1.calcularDias(f2) +1); //oncluye el dia de entrada pero no de salida (+1)
        //System.out.println(f1.calcularDias(f2) -3 -12 -5);
        
    }
}
