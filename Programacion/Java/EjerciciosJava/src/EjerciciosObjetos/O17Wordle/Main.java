package EjerciciosObjetos.O17Wordle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        String palabra, palabraEncriptada="", letra, historial="";
        boolean juegoActivo=true;
        int intentos=0; //5 intentos de palabra

        //elejir palabra o una aleatoria
        System.out.println("Aleatorio o personalizado?");
        palabra=teclado.nextLine();
        if (palabra.charAt(0)=='P'||palabra.charAt(0)=='p') {
            System.out.println("Introduce la palabra que quieres que adivinen tus victimas (sin mayusculas)");
            palabra=teclado.nextLine().toLowerCase();
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
        System.out.println("Mayuscula: Verde\nMinuscula: Amarillo");

        for(int i=0;i<palabra.length();i++){
            palabraEncriptada+="_";
        }
        //print inicial
        for(int i=intentos;i<6;i++){
            for(int j=0;j<palabra.length();j++){
                System.out.print("_");
            }
            System.out.println("");
        }

        //bucle de juego
        while (juegoActivo) {
            
            letra=teclado.nextLine();

            //comprobar palabras
            palabraEncriptada="";
            while (palabra.length()>letra.length()) {
                letra+=' ';
            }
            for(int i=0;i<palabra.length();i++){
                if (palabra.charAt(i)==letra.charAt(i)) {
                    palabraEncriptada+=letra.toUpperCase().charAt(i);
                }else if (palabra.indexOf(letra.charAt(i))>=0) {
                    palabraEncriptada+=letra.toLowerCase().charAt(i);
                }else{
                    palabraEncriptada+='-';
                }
            }
            intentos++;
            
            //print
            historial=historial+"\n"+palabraEncriptada;
            System.out.println(historial);
            for(int i=intentos;i<6;i++){
                for(int j=0;j<palabra.length();j++){
                    System.out.print("_");
                }
                System.out.println("");
            }
            
            
            if (palabra.compareTo(letra)==0) {
                juegoActivo=false;
                System.out.println("\nHAS GANADO!!!");
            }
            if (intentos==6) {//quedarte sin vidas
                juegoActivo=false;
                System.out.println("\nhas perdido...");                
            }
            /* 
            
            */
        }
        teclado.close();
    }
}
