package EjerciciosClass;

import java.util.Scanner;
/*Realizar un programa Java que calcule la cantidad total a pagar por una llamada telefónica de
acuerdo a las siguientes premisas:
a.- Toda llamada que dure menos de tres minutos tiene un coste de diez pesetas.
b.- Cada minuto adicional a partir de los tres primeros es un paso de contador y cuesta 5 pesetas*/
public class J04_calcular_precio_llamada {
	public static void main(String[] args) {
		//definir
			int precio, duracion;
			Scanner teclado=new Scanner(System.in) ;
		//pedir
			System.out.println("Duracion llamada:");
			duracion = teclado.nextInt();
		//calcular
			if (duracion<=3) {
				precio = 10;
			} else {
				precio = 10+(5*(duracion-3));
			}
			System.out.println("El precio de la llamada es "+precio+" pesetas");
			teclado.close();
	}
}
