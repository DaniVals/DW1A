package EjerciciosObjetos2.O09Comparadores;

import java.util.ArrayList;
import java.util.Scanner;

/*

Realizar una agenda para gestionar contactos. Los contactos pueden ser de dos tipos: personas y
empresas. De los contactos nos interesa almacenar: id (clave principal), teléfono y dirección de
correo electrónico. Si es una persona nos interesa además almacenar nombre y apellidos. Para las
empresas su dirección postal y el sector al que pertenece. Se pide mediante poder realizar las
siguientes operaciones mediante un menú:

Alta de contacto
Baja de contacto (por id)
Modificar teléfono de un contacto (por id)
Listar todos los datos de los contactos
Mostrar cuántas empresas hay de cada sector
Mostrar los datos ordenados por orden alfabético de email
Salir


Venir con el Sort hecho
Venir con 'ideas'


*/
public class Main {
    public static void main(String[] args){

        int opcion = 1;
        Scanner teclado=new Scanner(System.in);
        Lista lista1 = new Lista(new ArrayList<Contacto>(),teclado);

        lista1.debugAddCP("Persona 1", 66778899, "nombrado", "apellidado");
        lista1.debugAddCP("Persona 2", 66778899, "nombrado", "apellidado");
        lista1.debugAddCP("Persona 3", 66778899, "nombrado", "apellidado");
        lista1.debugAddCP("Persona 4", 66778899, "nombrado", "apellidado");
        lista1.debugAddCE("Empresa 1", 12345, "pasta", 19019);
        lista1.debugAddCE("Empresa 2", 111333, "pasta", 19019);
        lista1.debugAddCE("Empresa 3", 99, "pasta", 19019);
        lista1.debugAddCE("Empresa 4", 1234567890, "pasta", 19019);
        
        while (opcion!=0){
            System.out.println("Elije una opcion: "+
            "\n  1.Listado"+
            "\n  2.Ordenar por correo"+
            "\n  3.Ordenar por teléfono"+
            "\n  4.Ordenar por apellidos y nombre"+
            "\n  5.Ordenar por sector"+
            "\n  6.Ordenar por codigo postal"+
            "\n  0.salir");
            opcion= teclado.nextLine().charAt(0)-48;
            switch (opcion){
                case 1:
                    lista1.imprimir();
                break;
                case 2:
                break;
                case 3:
                    lista1.ordenarTel();
                break;
                case 4:
                    lista1.ordenarAlfa();
                break;
                case 5:
                break;
                case 6:
                break;
            }
        }
        System.out.println("Saliendo...");
        teclado.close();
    }
}
