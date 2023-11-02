package FuncionesCopias;

import java.util.Scanner;

public class MenuWhileSwitch {
    public static void main(String[] args){
        
        Mates mates;
        mates=new Mates();

        System.out.println(mates.factorial(5));
        
        



        Scanner teclado=new Scanner(System.in);
        int opcion = 1;
        while (opcion!=0){
            System.out.println("Elije una opcion: \n 1. 2. 3.    0.salir");
            opcion= teclado.nextInt();
            switch (opcion){
                case 1:
                break;
                case 2:
                break;
                case 3:
                break;
            }
        }
        System.out.println("Saliendo...");
        teclado.close();
    }
}