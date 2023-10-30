package FuncionesCopias;

import java.util.Scanner;

public class MenuWhileSwitch {
    public static void main(String[] args){
        
        Scanner teclado=new Scanner(System.in);
        int opcion = 1;

        while (opcion!=0){
            System.out.println("Elije una opcion: \n 1. 2. 3.    0.salir");
            opcion= teclado.nextInt();
            switch (opcion){
                case 1://ingresar
                break;
                case 2://retirar
                break;
                case 3://mostrar datos
                break;
            }
        }
        System.out.println("Saliendo...");
        teclado.close();
    }
}
