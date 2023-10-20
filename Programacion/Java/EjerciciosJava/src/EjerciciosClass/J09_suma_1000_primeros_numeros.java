package EjerciciosClass;

/*Realizar un programa Java que calcule la suma de los números 1 a 1000.*/
public class J09_suma_1000_primeros_numeros {
	public static void main(String[] args) {
		//definir
			int cont=1, suma=0;
		//procesar
			while(cont<=1000) {
				suma=suma+cont;
				cont++;
				System.out.println("la suma es "+suma);
			}
	}
}
