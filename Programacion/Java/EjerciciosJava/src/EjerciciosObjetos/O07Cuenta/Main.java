package EjerciciosObjetos.O07Cuenta;

import java.util.Scanner;

/* 
Crea una clase llamada Cuenta que tendrá los 
siguientes atributos: id (número entero) y
cantidad (puede tener decimales). 
Construye los siguientes métodos para la clase:
• Un constructor.
• Setter y getter de id y getter de cantidad.
• mostrar(): Muestra los datos de la cuenta.
• ingresar(cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es 
    negativa, no se hará nada.
• retirar(cantidad): se retira una cantidad a la cuenta. La cuenta puede estar en
    números rojos.

 Probar los métodos de la clase creando varios objetos y operando con ellos en un programa.
  */
public class Main {
    public static void main(String[] args){
        
        Cuenta c1;
        c1=new Cuenta(1, 300.5);
        Scanner teclado=new Scanner(System.in);
        int opcion = 1;
        double nTeclado=0.0;

        while (opcion!=0){
            System.out.println("Elije una opcion: \n 1.Ingresar 2.Retirar 3.Mostrar \n 0.salir");
            opcion= teclado.nextInt();
            switch (opcion){
                case 1://ingresar
                    System.out.println("Cantidad:");
                    nTeclado=teclado.nextDouble();
                    c1.ingresar(nTeclado);
                break;
                case 2://retirar
                    System.out.println("Cantidad:");
                    nTeclado=teclado.nextDouble();
                    c1.ingresar(nTeclado);
                break;
                case 3://mostrar datos
                    System.out.println(c1);
                break;
            }
        }
        System.out.println("Saliendo...");
        teclado.close();
    }
}
