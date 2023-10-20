package EjerciciosClass;

import java.util.Scanner;
/*Realizar un programa Java que permita calcular el precio de un billete de ida y vuelta en avión,
conociendo la distancia a recorrer, el número de días de estancia y sabiendo que si la distancia es superior
a 1000km y el número de días de estancia es superior a 7, la línea aérea le hace un descuento del 30%. El
precio por kilómetro recorrido es de 8.5 pts.*/
public class J03_calcular_precio_billete {
	public static void main(String[] args) {
		//definir
			int distancia, dias;
			float precio;
			Scanner teclado=new Scanner(System.in);
		//leer
			System.out.println("Distancia del vuelo(km):");
			distancia=teclado.nextInt();
			System.out.println("Duracion del viaje:");
			dias=teclado.nextInt();
		//calcular
			precio=distancia*8.5f;
			if (distancia>=1000 && dias>=7) {
				precio=precio*0.7f;
			}
			System.out.println("El precio del billete es: "+precio);
			teclado.close();
		
	}
}
