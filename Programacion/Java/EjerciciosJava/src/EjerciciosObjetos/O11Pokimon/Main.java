package EjerciciosObjetos.O11Pokimon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //establecer
        Scanner teclado=new Scanner(System.in);
        int valorTeclado1=0, valorTeclado2=0, opcion = 1;
        boolean juegoActivo=true, combateActivo=false, opcionValida=false;

        Mates m;
        m=new Mates();

        Entrenador entrenador1;
        Pokimon pokimon1, pokimon2, pokimon3, pokimon4, pokimon5, pokimon6;

        pokimon1=new Pokimon(20, 50, 15, 1); //starter equilibrado
        pokimon2=new Pokimon(m.rngInt(10,20), m.rngInt(70,80), m.rngInt(10,20), 2); //tanque
        pokimon3=new Pokimon(m.rngInt(15,20), m.rngInt(20,30), m.rngInt(55,60), 3); //asesino
        pokimon4=new Pokimon(m.rngInt(30,40), m.rngInt(70,80), m.rngInt(5,10), 4); //lento
        pokimon5=new Pokimon(m.rngInt(50,60), m.rngInt(10,15), m.rngInt(55,60), 5); //instakill
        pokimon6=new Pokimon(m.rngInt(55,60), m.rngInt(70,80), m.rngInt(55,60), 6); //chetado

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
                System.out.println("Te has encontrado con un pokemon salvaje!!! \n 1.PELEAR 2.CAPTURAR 3.HUIR");
                opcion= teclado.nextInt();
                switch (opcion){
                    case 1://pelear
                        opcionValida=false;
                        while (opcionValida==false) {
                            System.out.println("Que pokemon quieres usar?");
                            opcion= teclado.nextInt();                            
                            switch (opcion){
                                case 1://pokemon 1
                                break;
                                case 2://pokemon 2
                                break;
                                case 3://pokemon 3
                                break;
                            }
                        }
                    break;
                    case 2://capturar
                        opcionValida=false;
                        while (opcionValida==false) {
                            System.out.println("Donde lo quieres guardar?");
                            opcion= teclado.nextInt();                            
                            switch (opcion){
                                case 1://pokemon 1
                                break;
                                case 2://pokemon 2
                                break;
                                case 3://pokemon 3
                                break;
                            }
                        }
                    break;
                    default://huir
                        System.out.println("Huyes exitosamente");
                        combateActivo=false;
                    break;
                }
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
