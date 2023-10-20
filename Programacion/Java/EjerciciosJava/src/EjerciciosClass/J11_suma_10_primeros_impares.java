package EjerciciosClass;

/*Realizar un programa Java que calcule la suma de los 10 primeros números impares*/
public class J11_suma_10_primeros_impares {
	public static void main(String[] args) {
		//definir
			int cont=1, suma=0;
		//procesar
			while(cont<=1000) {
				if (cont%2==1) {
					suma=suma+cont;
					System.out.println("la suma es "+suma);
				}
				cont++;
			}
	}
}
