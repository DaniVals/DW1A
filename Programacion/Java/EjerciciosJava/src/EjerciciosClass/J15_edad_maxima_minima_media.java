package EjerciciosClass;

import java.util.Scanner;
/*43º.- Realizar un programa Java que permita introducir las edades de los 35 alumnos de una clase y
visualizar la edad del más joven y la edad media de la clase.*/
public class J15_edad_maxima_minima_media {

	public static void main(String[] args) {
		//definir
			int eIntroducida, eMax, eMin;
			float eSuma;
			Scanner teclado=new Scanner(System.in);
		//primer bucle
			System.out.println("Dame 35 edades y te dire la mayor, la menor, y la media de estas");
			eIntroducida=teclado.nextInt();
			eMax=eIntroducida;
			eMin=eIntroducida;
			eSuma=eIntroducida;
		//bucle principal
			for (int i=2; i<=5; i++) {
				eIntroducida=teclado.nextInt();
				if (eMax<eIntroducida) {
					eMax=eIntroducida;
				}
				if (eMin>eIntroducida) {
					eMin=eIntroducida;
				}
				eSuma+=eIntroducida;
			}
		//procesar
			System.out.println("el alumno menor tiene "+eMin+" años");
			System.out.println("el alumno mayor tiene "+eMax+" años");
			System.out.println("la edad media es de "+eSuma+" años");
			teclado.close();
	}
}
