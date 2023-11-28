package EjerciciosObjetos.O19Recursividad;

    //recursividad
    //llamar un metodo dentro de si mismo

public class Recursividad {
    public static void main(String[] args){

        Recursividad.imprime(5);

    }
    public static void imprime(int num){
        System.out.println(num);
        Recursividad.imprime(num);
    }
}
