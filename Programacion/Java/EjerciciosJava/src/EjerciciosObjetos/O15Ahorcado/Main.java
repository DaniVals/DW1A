package EjerciciosObjetos.O15Ahorcado;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        String palabra, palabraEncriptada="", palabraTemporal="", letra, letrasUsadas="";
        boolean juegoActivo=true, acierto=false;
        int golpes=0; //a los 6 mueres

        //elejir palabra o una aleatoria
        System.out.println("Aleatorio o personalizado?");
        palabra=teclado.nextLine();
        if (palabra.charAt(0)=='P'||palabra.charAt(0)=='p') {
            System.out.println("Introduce la palabra que quieres que adivinen tus victimas (sin mayusculas)");
            palabra=teclado.nextLine();
        }else{
            switch (Mates.randomInt(1, 10)) {
                default:
                    palabra="casita";
                break;
                case 2:
                    palabra="perro";
                break;
                case 3:
                    palabra="gato";
                break;
                case 4:
                    palabra="fernando";
                break;
                case 5:
                    palabra="armadillo";
                break;
                case 6:
                    palabra="murcielago";
                break;
                case 7:
                    palabra="ordenador";
                break;
                case 8:
                    palabra="peluche";
                break;
                case 9:
                    palabra="tejado";
                break;
                case 10:
                    palabra="marina";
                break;
            
            }
        }


        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

        for(int i=0;i<palabra.length();i++){
            palabraEncriptada+="_";
            palabraTemporal+="_";
        }
        //print inicial
        Imprimir.muerte(golpes);
        System.out.println(palabraEncriptada);

        //bucle de juego
        while (juegoActivo) {
            
            System.out.println("\n\nLetra:");
            letra=teclado.nextLine();

            //comprobar palabras
            palabraTemporal="";
            acierto=false;
            for(int i=0;i<palabra.length();i++){
                if (palabra.toLowerCase().charAt(i)==letra.toLowerCase().charAt(0)) {
                    palabraTemporal+=palabra.charAt(i);
                    acierto=true;
                }else{
                    palabraTemporal+=palabraEncriptada.charAt(i);
                }
            }
            palabraEncriptada=palabraTemporal;
            if (!acierto) {
                golpes++;
            }
            
            //print
            letrasUsadas+=letra.charAt(0);
            Imprimir.muerte(golpes);
            System.out.println("Letras usadas: "+letrasUsadas);
            
            if (palabra.compareTo(letra)==0||//introducir palabra exacta
            palabra.compareTo(palabraEncriptada)==0) {//palabra descubierta entera
                juegoActivo=false;
                System.out.println(palabra);
                System.out.println("HAS GANADO!!!");
            }else{
                System.out.println(palabraTemporal);
            }
            if (golpes==6) {//quedarte sin vidas
                juegoActivo=false;
                System.out.println("has perdido...");                
            }

        }
        teclado.close();
    }
}
