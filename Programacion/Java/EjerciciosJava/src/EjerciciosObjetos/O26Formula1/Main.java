package EjerciciosObjetos.O26Formula1;

import java.util.ArrayList;
import java.util.Scanner;

/*
2. Realizar una aplicación para gestionar la información relativa a pilotos de fórmula uno en activo.
Nos interesa conocer el número de licencia del piloto (clave principal), su nombre y apellidos, su
nacionalidad y los puntos obtenidos en cada una de las carreras en las que haya participado dicho
piloto. Es suficiente con saber el orden de las carreras y los puntos obtenidos. Ejemplo: en la carrera
número 5 de su vida como piloto ha obtenido 7 puntos.
Se pide mediante poder realizar las siguientes operaciones mediante un menú:
1. Alta de piloto (sin datos de los puntos en las carreras)
2. Poner los puntos de un piloto en todas sus carreras (buscar por id)
3. Añadir puntos de la última carrera hasta la fecha para un piloto (buscar por id)
4. Listar todos los datos de los pilotos que tienen como puntuación más baja un 5 en una carrera.
5. Mostrar número de licencia del piloto con la puntuación total más alta (en caso de empate basta
mostrar un valor)
6. Mostrar los datos ordenados por orden alfabético de apellidos y nombre
7. Salir

*/
public class Main {
    public static void main(String[] args){

        int opcion = 1;
        Scanner teclado=new Scanner(System.in);
        Lista lista1 = new Lista(new ArrayList<Piloto>(),teclado);
        lista1.debugAddPiloto(999, "Franchesco", "Virgolini", "Italiano");
        lista1.debugAddCarrera(0, 4);
        lista1.debugAddPiloto(313, "Raul", "Seleccion", "ESPAÑA");
        
        while (opcion!=0){
            System.out.println("Elije una opcion: "+
            "\n  1.Añadir piloto"+
            "\n  2.Añadir puntos "+
            "\n  3.Añadir ultima puntuacion"+
            "\n  4.Listado pilotos con puntuacion menor que 5"+
            "\n  5.Numero de licencia de piloto con mas puntuacion"+
            "\n  6.Nombre y apellidos ordenados alfabeticamente"+
            "\n  0.salir");
            opcion= teclado.nextLine().charAt(0)-48;
            switch (opcion){
                //añadir un piloto
                case 1:
                    lista1.pedirPiloto();
                break;
                //añadir carreras
                case 2:
                    lista1.addHistorial();
                break;
                //añadir ultima carrera
                case 3:
                    lista1.addCarrera();
                break;
                //listado 
                case 4:
                    lista1.imprimir(0);
                break;
                //mayor media 
                case 5:
                    lista1.buscarMayor();
                break;
            }
            //sustituir por una pausa
            if (opcion!=0) {   
                System.out.println();
                System.out.println("pulse para continuar");
                teclado.nextLine();
            }
        }
        System.out.println("Saliendo...");
        teclado.close();
    }
}
