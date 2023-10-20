package EjerciciosClass;

import java.util.Scanner;
/*54º.- Realizar un programa Java que permita introducir 10 parejas de números naturales A,B y para cada
una de ellas, visualizar su producto por el método de las sumas sucesivas*/
public class J16_multiplicacion_manual {
	public static void main(String[] args) {
		//definir
			int num1, num2;
			Scanner teclado=new Scanner(System.in);
		//bucle principal
			for (int j=0; j<10; j++) {
			//pedir
				System.out.println("Dame 2 numeros y los multiplicare");
				//numero 1
				System.out.println("numero 1");
				num1=teclado.nextInt();
				while (num1<1) {
					System.out.println("por favor, introduzca un numero valido");
					num1=teclado.nextInt();
				}
				//numero 2
				System.out.println("numero 2");
				num2=teclado.nextInt();
				while (num2<1) {
					System.out.println("por favor, introduzca un numero valido");
					num2=teclado.nextInt();
				}
			//procesar
				System.out.print(num1+"*"+num2+" = "+num2);
				for (int i=2; i<=num1; i++) {
					System.out.print("+"+num2);
				}
				System.out.println("");//pasar de linea
			}
			teclado.close();
	}
}
