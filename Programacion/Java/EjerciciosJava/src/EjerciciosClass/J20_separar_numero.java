package EjerciciosClass;

import java.util.Scanner;
//dar un numero entero y separar las cifras
public class J20_separar_numero {
	public static void main(String[] args) {
		//definir
			int numTeclado, numI, numCifras=0, contCifras=1;
			Scanner teclado=new Scanner(System.in);
			System.out.println("dame un numero y lo separare");
		//pedir
			numTeclado = teclado.nextInt();
			if (numTeclado<0) {
				numTeclado=numTeclado*(-1);
			}
		//detectar numero cifras
			while (numCifras==0) {
				if ((numTeclado/Math.pow(10, contCifras))>=1) {
					contCifras++;
				} else {
					numCifras=contCifras;
				}
			}
		//separar numero
			for (int i=numCifras-1; i>=0; i--) {
				numI=(int) (numTeclado/Math.pow(10, i));
				numTeclado=numTeclado-(int)(numI*Math.pow(10, i));
				System.out.println(numI);
			}
		teclado.close();
	}
}
