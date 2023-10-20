package EjerciciosClass;

import java.util.Scanner;
//calcular raiz cuadrada
public class C01_RaizCuadrada {
	public static void main(String[] args) {
		//definir
			float numeroIntroducido;
			double raiz;
			Scanner teclado=new Scanner(System.in);
		//leer
			System.out.println("Dame un numero y calculare su raiz");
			numeroIntroducido=teclado.nextFloat();
		//calcular
			raiz=Math.sqrt(numeroIntroducido);
		//conclusion
			System.out.println("La raiz de "+numeroIntroducido+" es "+raiz);
			teclado.close();
	}
}
