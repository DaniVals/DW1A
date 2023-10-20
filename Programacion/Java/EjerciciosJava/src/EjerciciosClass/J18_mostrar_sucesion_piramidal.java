package EjerciciosClass;

import java.util.Scanner;

public class J18_mostrar_sucesion_piramidal {
	public static void main(String[] args) {
		//definir
			int numTeclado, opcion;
			Scanner teclado=new Scanner(System.in);
		//pedir
			System.out.println("¿que forma quieres? 1: rampa 2:escalera 3:piramide 4:rombo");
			opcion=teclado.nextInt();
			
			System.out.println("¿que tamaño quieres? (entre 1 y 9)");
			numTeclado=teclado.nextInt();
			while (numTeclado<1 || 9<numTeclado) {
				System.out.println("por favor, introduzca un valor valido");
				numTeclado=teclado.nextInt();
			}
			
		//switch
			switch (opcion) {
			case 1:  //rampa
				for (int suma=0, i=1; i<=numTeclado; i++) {
					System.out.println(i+suma);
					suma=(suma+i)*10;
				}
			break;
			case 2:  //escalera
				for (int suma=0, i=1; i<=numTeclado; i++) {
					for (int j=numTeclado-i; j>=1; j--) {
						System.out.print(" ");
					}
					System.out.println(i+suma);
					suma=(suma+i)*10;
				}
			break;
			case 3:  //piramide
				for (int suma=0, i=1; i<=numTeclado; i++) {
					for (int j=numTeclado-i; j>=1; j--) {
						System.out.print(" ");
					}
					System.out.print(i+suma);
					for(int j=i-1; j>=1; j--) {
						System.out.print(j);
					}
					suma=(suma+i)*10;
					System.out.println("");
				}
			break;
			case 4:  //rombo
				for (int suma=0, i=1; i<=numTeclado; i++) {
					for (int j=numTeclado-i; j>=1; j--) {
						System.out.print(" ");
					}
					System.out.print(i+suma);
					for(int j=i-1; j>=1; j--) {
						System.out.print(j);
					}
					suma=(suma+i)*10;
					System.out.println("");
				}
				
				for (int i=numTeclado-1; i>=1; i--) { //cubo
					for (int j=numTeclado-i; j>=1; j--) { //espacios
						System.out.print(" ");
					}
					for(int j=1; j<=i; j++) { //primera mitad
						System.out.print(j);
					}
					for (int j=i-1; j>=1; j--) {
						System.out.print(j); //segunda mitad
					}
					System.out.println("");
				}
			break;
			}
		teclado.close();
	}

}
