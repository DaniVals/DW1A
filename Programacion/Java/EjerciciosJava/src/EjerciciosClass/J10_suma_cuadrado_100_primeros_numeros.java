package EjerciciosClass;

/*Realizar un programa Java que calcule la suma de los cuadrados de los 100 primeros números naturales.*/
public class J10_suma_cuadrado_100_primeros_numeros {
	public static void main(String[] args) {
		//definir
			int cont=1, suma=0;
		//procesar
			while(cont<=100) {
				suma=suma+(cont^2);
				cont++;
				System.out.println("la suma es "+suma);
			}
	}
}
