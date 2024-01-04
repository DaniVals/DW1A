package EjerciciosObjetos.O23HundirFlota;

import java.util.Scanner;

public class Menu {
    public static Scanner teclado;

    public static void empezarPartida(){
        
        Tablero tablero1=new Tablero();
        int opcion=1;

        while (opcion!=0){
        System.out.println("------------------------------");
        System.out.println("       HUNDIR LA FLOTA        ");
        System.out.println("------------------------------");
        System.out.println("1. guia\n2. descubrir\n\n0. salir");
            try {
                opcion= Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
            }
            switch (opcion){
                case 1:
                    System.out.println(" -------GUIA-------");
                    System.out.println("  ? -> sin explorar");
                    System.out.println("  . -> fallo");
                    System.out.println("  x -> acierto");
                    System.out.println("  para introducir una casilla tiene que escribir\n  el numero Y la letra juntos");
                    System.out.println("");
                    System.out.println(" -------DESCUBRIR-------");
                    System.out.println("  En descubrir se te expondra a un tablero con los barcos colocados");
                    System.out.println("  por la maquina, tendra un numero limitado de movimientos");
                    System.out.println("  para derrumbar todos los barcos o perdera, este sera proporcional al");
                    System.out.println("  tamaño que decida para los barcos");
                    System.out.println("     ----------    ");
                break;

                //modo descubrir
                case 2:

                    //pedir los barcos
                    System.out.println("Introduzca el tamaño de los 5 barcos");
                    System.out.println(" - validos entre 1 y 4");
                    System.out.println(" - si quiere que sea aleatorio, ponga una 'a'");
                    System.out.println(" - si quiere ocultar su valor, añada una 'o' al final");
                    System.out.println(" - si no quiere mas ponga 0");
                    tablero1.reiniciar();
                    
                    int movimientosMaximos=pedirBarcos(tablero1); 

                    //impresion inicial
                    tablero1.imprimirTablero(false);
                    
                    boolean partidaActiva=true;
                    int contMovimientos=0;

                    //bucle principal
                    while (partidaActiva) {
                        //pedir la casilla nueva
                        pedirCasilla(tablero1);
                        //mirar si se rindio
                        if (tablero1.isRendido()) {
                            partidaActiva=false;
                            System.out.println("tablero completo");
                            tablero1.imprimirTablero(true);
                        }else if (tablero1.acabado()) {
                            //mirar si ha acabado
                            partidaActiva=false;
                            System.out.println("tablero final");
                            tablero1.imprimirTablero(false);
                        }else{
                            contMovimientos++;
                        }
                        System.out.println("movimientos: "+contMovimientos+"/"+movimientosMaximos);
                    }
                    
                break;
            }
        }
    }
    public static int pedirBarcos(Tablero tablero){
        double movimientosMaximos=10;
        boolean numValido=false;
        String valor;
        int tamaño=0;

        for(int i=0;i<tablero.getBarcos().length;i++){
            do {
                numValido=false;
                System.out.println("Barco "+i);
                valor=teclado.next();
                try {
                    tamaño=Integer.parseInt(valor.charAt(0)+"");
                    if (0<=tamaño&&tamaño<=4) {
                        numValido=true;
                    }
                } catch (NumberFormatException e) {
                    if (valor.charAt(0)=='a') {
                        tamaño=(int)(Math.random()*4+1);
                        numValido=true;
                    }
                }
            } while (!numValido);
            
            //acabar el bucle si pone 0
            if (tamaño==0) {
                System.out.println("total barcos "+i);
                break;
            }else{
                System.out.println("Añadiendo barco...");
                movimientosMaximos+=20/tamaño;
                tablero.crearBarco(i,tamaño);
            }
            //poner barcos ocultos
            if (1<valor.length()) {
                if (valor.charAt(1)=='o') {
                    tablero.getBarcos()[i].setOculto(true);
                    movimientosMaximos+=1.5*tamaño;
                }
            }
        }
        return (int)movimientosMaximos;
    }
    public static void pedirCasilla(Tablero tablero){

        String casillaDescubierta="";

        //pedir la proxima casilla
        System.out.println("Donde quiere descubrir?");
        casillaDescubierta=teclado.nextLine().toLowerCase();
        while (!verificarCasilla(casillaDescubierta)) {
            System.out.println("Casilla no valida\nrecuerde primero el numero(0-9) y luego la letra(a-j)");
            casillaDescubierta=teclado.nextLine().toLowerCase();   
        }

        if (casillaDescubierta.compareTo("rendicion")==0) {
            //si se rinde 
            tablero.setRendido(true);
        }else{
            //actualizar tablero
            System.out.println("\n");
            tablero.descubrirCasilla((int)(casillaDescubierta.charAt(0)), (int)(casillaDescubierta.charAt(1)));
            tablero.imprimirTablero(false);
        }

    }
    public static boolean verificarCasilla(String casillaDescubierta){
        
        //si se rinde
        if (casillaDescubierta.compareTo("rendicion")==0) {
            return true;
        }
        //si la longitud es menor
        if (casillaDescubierta.length()>=2) {
            //la primera es un numero y la segunda una letra
            if ('0'<=casillaDescubierta.charAt(0)&&casillaDescubierta.charAt(0)<='9') {
                if ('a'<=casillaDescubierta.charAt(1)&&casillaDescubierta.charAt(1)<='j') {
                    return true;
                }
            }
        }
        //si no es ningun caso valido
        return false;
    }
}
