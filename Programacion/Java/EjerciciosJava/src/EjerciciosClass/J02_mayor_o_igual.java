package EjerciciosClass;

import java.util.Scanner;
//pedir un numero y decir si es mayor de edad o no
public class J02_mayor_o_igual {
	public static void main(String[] args) {
		//definir
			int edad;
			Scanner teclado=new Scanner(System.in);
		//leer
			System.out.println("dame tu edad y te dire si eres mayor de edad");
			edad=teclado.nextInt();
		//procesar
			if (edad>=18) {
				System.out.println("eres mayor de edad");
			} else {
				System.out.println("eres menor de edad");
			}
			teclado.close();
	}
}
