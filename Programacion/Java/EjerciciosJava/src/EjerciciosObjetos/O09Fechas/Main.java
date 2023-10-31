package EjerciciosObjetos.O09Fechas;

public class Main {
    public static void main(String[] args){

        Fecha f1;
        f1=new Fecha(28, 11, 2399);
        for (int i=0; i<500;i++){
            f1.siguiente();
            System.out.println(f1);
        }
        System.out.println("cambio");
        for (int i=0; i<500;i++){
            f1.anterior();
            System.out.println(f1);
        }
    }
}
