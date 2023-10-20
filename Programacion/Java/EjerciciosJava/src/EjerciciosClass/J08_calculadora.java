package EjerciciosClass;

import java.util.Scanner;
//calculadora 1.suma 2.resta 3.multiplicar 4.dividir
public class J08_calculadora {
	public static void main(String[] args) {
		//definir
		    Scanner teclado=new Scanner(System.in);
		    int opcion;
		    float num1, num2;
	    //pedir
		    System.out.println("1.suma 2.resta 3.multiplicar 4.dividir");
		    opcion = teclado.nextInt();
		    System.out.println("dame los dos numeros");
		    num1 = teclado.nextFloat();
		    num2 = teclado.nextFloat();
	    //calcular
		    switch (opcion) {
		    case 1:
		    	System.out.println(num1+" + "+num2+" = "+(num1+num2));
		    	break;
		    case 2:
		    	System.out.println(num1+" - "+num2+" = "+(num1-num2));
		    	break;
		   	case 3:
		   		System.out.println(num1+" * "+num2+" = "+(num1*num2));
		    	break;
		   	case 4:
			   	System.out.println(num1+" / "+num2+" = "+(num1/num2));
		   		break;
		   	default:
		   		System.out.println("cerrando");
		   		break;
		    }
		    teclado.close();
	}
}
