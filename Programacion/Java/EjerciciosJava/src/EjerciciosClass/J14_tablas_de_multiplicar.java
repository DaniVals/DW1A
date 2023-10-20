package EjerciciosClass;

import java.util.Scanner;
//calcular x tablas de multiplicar
public class J14_tablas_de_multiplicar {
		public static void main(String[] args) {
			//definir
				int numeroTablas;
				Scanner teclado=new Scanner(System.in);
			//leer
				System.out.println("cuantas tablas de multiplicar quieres?");
				numeroTablas=teclado.nextInt();

				while (numeroTablas<1) {
					System.out.println("por favor, introduzca un numero valido");
					numeroTablas=teclado.nextInt();
				}
			//procesar
				for (int i=1;i<=numeroTablas;i++) {
					for (int j=1;j<=10;j++) {
						System.out.println(i+"x"+j+"="+i*j);
					}
				}
				teclado.close();
	}
}
