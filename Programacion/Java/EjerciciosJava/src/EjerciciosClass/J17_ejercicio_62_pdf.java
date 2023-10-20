package EjerciciosClass;

import java.util.Scanner;

/*En un curso de informática se han realizado dos exámenes diferentes, A y B, entre sus 50
alumnos(alumnos impares, examen A, alumnos pares, examen B). Se desea saber la nota media de cada
examen.*/
public class J17_ejercicio_62_pdf {
	public static void main(String[] args) {
		//definir
			int nota;
			float mediaA=0, mediaB=0;
			Scanner teclado=new Scanner(System.in);
			System.out.println("Dame las notas de los 50 alumnos");
		//bucle principal
			for (int i=1; i<=50; i++) {
			//pedir
				System.out.println("nota alumno numero "+i);
				nota=teclado.nextInt();
				while (10<nota||nota<0) {
					System.out.println("por favor, introduzca un numero valido");
					nota=teclado.nextInt();
				}
			//procesar
				if (i%2==1) {
					mediaA+=nota;
				}
				if (i%2==0) {
					mediaB+=nota;
				}
			}
		//conclusion
			System.out.println("la media del examen A es "+ mediaA/25);
			System.out.println("la media del examen B es "+ mediaB/25);
			teclado.close();
	}
}
