package EjerciciosObjetos.O25ListaContactos;

import java.util.ArrayList;
import java.util.Scanner;

/*
1. Realizar una agenda para gestionar contactos. Los contactos pueden ser de dos tipos: personas y
empresas. De los contactos nos interesa almacenar: id (clave principal), teléfono y dirección de
correo electrónico. Si es una persona nos interesa además almacenar nombre y apellidos. Para las
empresas su dirección postal y el sector al que pertenece. Se pide mediante poder realizar las
siguientes operaciones mediante un menú:

1. Alta de contacto
2. Baja de contacto (por id)
3. Modificar teléfono de un contacto (por id)
4. Listar todos los datos de los contactos
5. Mostrar cuántas empresas hay de cada sector
6. Mostrar los datos ordenados por orden alfabético de email
7. Salir
 */
public class Main {
    public static void main(String[] args){

        Scanner teclado=new Scanner(System.in);
        int opcion = 1;
        ArrayList<Contacto> contactos=new ArrayList<Contacto>();
        while (opcion!=0){
            System.out.println("Elije una opcion: "+
            "\n  1.Añadir"+
            "\n  2.Borrar "+
            "\n  3.Cambiar telefono"+
            "\n  4.Listado contactos"+
            "\n  5.Numero empresas en sector"+
            "\n  6.Emails ordenados alfabeticamente"+
            "\n  0.salir");
            opcion= teclado.next().charAt(0)-48;
            switch (opcion){
                //añadir un contacto
                case 1:
                    System.out.println("persona o empresa?");
                    String tel, dirr, correo, nombre, apellidos, postal, sector;
                    if (teclado.next().charAt(0)=='p'||teclado.next().charAt(0)=='P') {
                        //persona
                        System.out.println("Nombre: ");     nombre=teclado.nextLine();
                        System.out.println("Apellidos: ");  apellidos=teclado.nextLine();
                        System.out.println("Telefono: ");   tel=teclado.nextLine();
                        System.out.println("Dirreccion: "); dirr=teclado.nextLine();
                        System.out.println("Correo: ");     correo=teclado.nextLine();
                        
                        contactos.add(new Contacto(tel, dirr, correo, true, nombre, apellidos,
                         "NA", "NA"));
                    }else{
                        //empresa
                        System.out.println("Sector: ");     sector=teclado.nextLine();
                        System.out.println("Postal: ");     postal=teclado.nextLine();
                        System.out.println("Telefono: ");   tel=teclado.nextLine();
                        System.out.println("Dirreccion: "); dirr=teclado.nextLine();
                        System.out.println("Correo: ");     correo=teclado.nextLine();
                        
                        contactos.add(new Contacto(tel, dirr, correo, false,"NA", "NA",
                        sector, postal));
                    }
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                    for(Contacto c : contactos){
                        System.out.println(c);
                    }
                break;
            }
        }
        System.out.println("Saliendo...");
        teclado.close();
    }
}
