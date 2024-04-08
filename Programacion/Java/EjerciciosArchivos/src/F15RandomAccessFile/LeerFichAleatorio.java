package src.F15RandomAccessFile;

import java.io.*;

public class LeerFichAleatorio {

	public static void main(String[] args) throws IOException {

		File fichero = new File("AleatorioEmple.dat");
		// declara el fichero de acceso aleatorio
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		//

		int id, dep, posicion;
		Double salario;
		// char apellido[] = new char[10], aux;
		String apellido;
		posicion = 0; // para situarnos al principio



		while (file.getFilePointer() != file.length()) { // recorro el fichero
			file.seek(posicion); // nos posicionamos en posicion
			System.out.println("Pos: " + file.getFilePointer());
			id = file.readInt(); // obtengo id de empleado

			/*
			 * for (int i = 0; i < apellido.length; i++) {
			 * aux = file.readChar();//recorro uno a uno los caracteres del apellido
			 * apellido[i] = aux; //los voy guardando en el array
			 * }
			 * String apellidoS= new String(apellido);//convierto a String el array
			 */

			apellido = file.readUTF();
			dep = file.readInt();// obtengo dep
			salario = file.readDouble(); // obtengo salario
			System.out.println("ID: " + id + ", Apellido: " + apellido +
					", Departamento: " + dep + ", Salario: " + salario);
			posicion = posicion + 16 + (2 + apellido.length()); // me posiciono para el sig empleado
			// Cada empleado ocupa 36 bytes (4+(2+longitud_String)+4+8)
		} // fin bucle for


		file.close(); // cerrar fichero
	}
}
