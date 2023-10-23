package EjerciciosObjetos.O00Bicicleta;

import java.util.Scanner;

public class PruebaObjeto {

    public static void main(String[] args) {
        
            //declarar una referencia (direccion de memoria del objeto)
            Bicycle bici1=null, bici2=null;
            //int velocidad;
            Scanner teclado=new Scanner(System.in);
            
            //crear objetos usando el constructor
            bici1=new Bicycle(1,0,3);
            bici2=new Bicycle(4,0,6);


            /*
            System.out.println(bici1.speed);
            bici1.speed=7; //aqui se puede acceder si la variable es PUBLIC
            System.out.println(bici1.speed);
            bici1.applyBrake(3); //aqui da igual la variable
            System.out.println(bici1.speed);
            */
            
            //cambiar por teclado
            System.out.println("dame las velocidades de dos bicis");
            bici1.speedUp(teclado.nextInt());
            bici2.speedUp(teclado.nextInt());
            
            //procesar los datos
            if(bici1.showSpeed()>bici2.showSpeed()){
                System.out.println("gana la bici 1");
            }else{
                if(bici1.showSpeed()<bici2.showSpeed()){
                    System.out.println("gana la bici 2");
                }else{
                    System.out.println("empatan");
                }
            }

        teclado.close();
    }
}