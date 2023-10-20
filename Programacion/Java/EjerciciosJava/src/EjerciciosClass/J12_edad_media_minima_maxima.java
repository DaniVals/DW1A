package EjerciciosClass;

import java.util.Scanner;
/*43º.- Realizar un programa Java que permita introducir las edades de los 35 alumnos de una clase y
visualizar la edad del más joven y la edad media de la clase.*/
public class J12_edad_media_minima_maxima {
	public static void main(String[] args) {
		//definir
			int eIntroducida, eMax, eMin, cont;
			float eSuma;
			Scanner teclado=new Scanner(System.in);
		//primer bucle
			System.out.println("Dame 35 edades y te dire la mayor, la menor, y la media de estas");
			eIntroducida=teclado.nextInt();
			eMax=eIntroducida;
			eMin=eIntroducida;
			eSuma=eIntroducida;
			cont=1;
		//bucle principal
			while (cont < 35) {
				eIntroducida=teclado.nextInt();
				if (eMax<eIntroducida) {
					eMax=eIntroducida;
				}
				if (eMin>eIntroducida) {
					eMin=eIntroducida;
				}
				eSuma=eIntroducida+eSuma;
				cont++;
			}
		//procesar
			System.out.println("el alumno menor tiene "+eMin+" años");
			System.out.println("el alumno mayor tiene "+eMax+" años");
			System.out.println("la edad media es de "+eSuma/cont+" años");
			teclado.close();
	}
}
