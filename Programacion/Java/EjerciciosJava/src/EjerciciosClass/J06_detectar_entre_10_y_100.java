package EjerciciosClass;

import java.util.Scanner;
/*Escribir un programa Java que lea un número por teclado y 
deduzca si está comprendido entre 10 y100*/
public class J06_detectar_entre_10_y_100 {
	public static void main(String[] args) {
		//definir
		int n1;
		Scanner teclado=new Scanner(System.in) ;
		//pedir
		System.out.println("Dame un numero y te dire si esta entre 10 y 100");
		n1 = teclado.nextInt();
		//procesar
		if (10<=n1 && n1<=100) {
			System.out.println("Esta entre 10 y 100");
		} else {
			System.out.println("No esta entre 10 y 100");
		}
		teclado.close();
	}
}
