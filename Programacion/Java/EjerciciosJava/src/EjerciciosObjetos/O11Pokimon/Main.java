package EjerciciosObjetos.O11Pokimon;

import java.util.Scanner;

import EjerciciosObjetos.O04Baloncesto.Jugador;

public class Main {
    public static void main(String[] args){
        //establecer
        Scanner teclado=new Scanner(System.in);
        int valorTeclado1=0, valorTeclado2=0, opcion = 1;
        Entrenador entrenador1;
        boolean juegoActivo=true, combateActivo=false;

        //intro
        System.out.println("Hola jugador, de que tamaño quieres el mapa?");
        while (valorTeclado1<=0) {
            System.out.println("x:");
            valorTeclado1= teclado.nextInt();
        }
        while (valorTeclado2<=0) {
            System.out.println("y:");
            valorTeclado2= teclado.nextInt();
        }
        
        entrenador1=new Entrenador(valorTeclado1, valorTeclado2);
        //empezar partida
        entrenador1.moverse(0);
        while (juegoActivo) {
            //menu
            if (combateActivo) {
                System.out.println(" PARTIDA");
                        combateActivo=false;
            }else{
                System.out.println("Donde quieres ir: \n 1.ARRIBA 2.DERECHA 3.ABAJO 4.IZQUIERDA 0.ACABAR PARTIDA");
                opcion=teclado.nextInt();
                if (opcion==0) {
                    juegoActivo=false;
                }else{
                    entrenador1.moverse(opcion);
                    if (Math.random()<0.15) {
                        combateActivo=true;
                    }
                }
            }
        }
        System.out.println(entrenador1);



        teclado.close();
    }

    //mapa de cuadriculas con tamaño seleccionable
    //un entrenador pokimos (se mueve de UDLR), se choca con el borde del mapa
    //pokimochila con capacidad para tres pokimon
    //todas las casillas son hierba alta
    //se captura como quieras
    //se elije entre luchas o capturar o huir
    //si gana consigue dinero y si pierde pierde dinero
    //cuando acabe mostrar casillas recorridas, numero victorias y derrotas, dinero final
}
