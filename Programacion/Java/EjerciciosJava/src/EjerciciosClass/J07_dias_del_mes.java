package EjerciciosClass;

import java.util.Scanner;

//pedir mes y decir sus dias
public class J07_dias_del_mes {
	public static void main(String[] args) {
		//definir
			int mes;
		    String diasMes;
		    Scanner teclado=new Scanner(System.in);
	    //pedir
		    System.out.println("dime el numero de un mes y te dire sus dias");
		    mes = teclado.nextInt();
	    //procesar
		    switch (mes) {
	        case 1:  diasMes = "enero tiene 31 dias";
	                 break;
	        case 2:  diasMes = "febrero tiene 28 o 29 dias";
	                 break;
	        case 3:  diasMes = "marzo tiene 31 dias";
	                 break;
	        case 4:  diasMes = "abril tiene 30 dias";
	                 break;
	        case 5:  diasMes = "mayo tiene 31 dias";
	                 break;
	        case 6:  diasMes = "junio tiene 30 dias";
	                 break;
	        case 7:  diasMes = "julio tiene 31 dias";
	                 break;
	        case 8:  diasMes = "agosto tiene 31 dias";
	                 break;
	        case 9:  diasMes = "septiembre tiene 30 dias";
	                 break;
	        case 10: diasMes = "octubre tiene 31 dias";
	                 break;
	        case 11: diasMes = "noviembre tiene 30 dias";
	                 break;
	        case 12: diasMes = "diciembre tiene 31 dias";
	                 break;
	        default: diasMes = "Invalid month";
	                 break;
	    }
	    System.out.println(diasMes);
	    teclado.close();
	}
}
