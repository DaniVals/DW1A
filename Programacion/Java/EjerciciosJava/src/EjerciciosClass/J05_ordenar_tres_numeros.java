package EjerciciosClass;

import java.util.Scanner;

/*- Realizar un programa Java en el que se introducen tres números por teclado y se deduce si se han
introducido en orden creciente*/
public class J05_ordenar_tres_numeros {
	public static void main(String[] args) {
		//definir
			int n1, n2, n3;
			Scanner teclado=new Scanner(System.in) ;
		//pedir
			System.out.println("Dame tres numeros para que los ordene");
			n1 = teclado.nextInt();
			n2 = teclado.nextInt();
			n3 = teclado.nextInt();
		//procesar
			System.out.print("el mas pequeño es ");
			//el 1
			if (n1<=n2 && n1<=n3) {
				System.out.print(n1+", luego ");
				if(n2<=n3) {
					System.out.print(n2+" y luego "+n3);
				} else {
					System.out.print(n3+" y luego "+n2);
				}
			}
			//el 2
			if (n2<=n1 && n2<=n3) {
				System.out.print(n1+", luego ");
				if(n1<=n3) {
					System.out.print(n1+" y luego "+n3);
				} else {
					System.out.print(n3+" y luego "+n1);
				}
			}
			//el 3
			if (n3<=n2 && n3<=n1) {
				System.out.print(n3+", luego ");
				if(n2<=n1) {
					System.out.print(n2+" y luego "+n1);
				} else {
					System.out.print(n1+" y luego "+n2);
				}
			}
			teclado.close();
	}
}
