package src.F17DaoContactos.ConInterfazes;

import java.io.IOException;
import java.util.Scanner;

import src.F17DaoContactos.Contacto;

public class Main2 {
	static boolean activo = true;
	static int menuPos = 0;
	static AgendaSaveLoad agenda;
	static Scanner teclado;

	public static void main(String[] args) throws IOException {

		activo = true;
		menuPos = 0;
		agenda = new AgendaSaveLoad("Programacion/Java/EjerciciosArchivos/src/F17DaoContactos/ConInterfazes/agenda.savedata", 20, '#');
		teclado = new Scanner(System.in);

		// agenda.agregarContacto(new Contacto(666, "dir", "email", "el diavlo"));

		try {
			agenda.CargarArchivo();
		} catch (IOException e) {
			System.out.println("no se encontro un archivo de guardado, se creara uno nuevo");
		}

		while (activo) {
			System.out.println(addSelectChar(0, menuPos, '*') + "Añadir");
			System.out.println(addSelectChar(1, menuPos, '*') + "Borrar");
			System.out.println(addSelectChar(2, menuPos, '*') + "Mostrar todos");
			System.out.println(addSelectChar(3, menuPos, '*') + "Guardar y salir");
			detectarInput();
		}

		teclado.close();
	}

	private static void detectarInput() throws IOException {
		String input = teclado.nextLine();

		if (input.charAt(0) == 's') {
			change(true);
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
		if (input.charAt(0) == 'w') {
			change(false);
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
		if (input.charAt(0) == 'd') {
			switch (menuPos) {
				case 0:
					agenda.agregarContacto(new Contacto(
						PedirValorNumeroPositivo("Numero telefonico"), 
						PedirValorTexto("direccion", 20), 
						PedirValorTexto("correo", 20), 
						PedirValorTexto("nombre", 20)
					));
					System.out.println("\n");
				break;
				case 1:
					agenda.borrarContacto(new Contacto(
						PedirValorNumeroPositivo("Numero telefonico"), 
						PedirValorTexto("direccion", 20), 
						PedirValorTexto("correo", 20), 
						PedirValorTexto("nombre", 20)
					));
					System.out.println("\n");
				break;
				case 2:
					System.out.println("\n");
					for (Contacto c : agenda.getContactos()) {
						System.out.println(c);
					}
				break;
				case 3:
					agenda.GuardarArchivo();
					activo = false;
				break;
			}
		}
	}
	private static String PedirValorTexto(String datoPedido,int maxText){
		System.out.println("Introduzca el "+datoPedido);
		String devuelto;
		do {
			devuelto = teclado.nextLine();
		} while (!(devuelto.length() <= maxText));
		return devuelto;
	}
	private static int PedirValorNumeroPositivo(String datoPedido){
		System.out.println("Introduzca el "+datoPedido);
		int devuelto=0;
		boolean valido = false;
		do {
			try {
				devuelto =Integer.parseInt(teclado.nextLine());
				valido = true;
			} catch (NumberFormatException e) {}
		} while (!(valido && 0<devuelto));
		return devuelto;
	}

	private static String addSelectChar(int num, int compared, char car) {
		if (num == compared) {
			return " " + car + " ";
		} else {
			return "   ";
		}
	}

	private static void change(boolean sumar) {
		if (sumar) {
			menuPos++;
			if (3 < menuPos) {
				menuPos = 0;
			}
		} else {
			menuPos--;
			if (menuPos < 0) {
				menuPos = 3;
			}
		}
	}
}
