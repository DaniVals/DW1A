package EjerciciosObjetos.O11Pokimon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //establecer
        Scanner teclado=new Scanner(System.in);
        int valorTeclado1=0, valorTeclado2=0, opcion = 1;
        boolean juegoActivo=true, combateActivo=false, opcionValida=false;

        Entrenador entrenador1;
        PokiMochila mochila1;
        Pokimon pokimon1, pokimon2, pokimon3, pokimon4, pokimon5, pokimon6, pokemonPelear;

        //intro
        pokimon1=new Pokimon(20, 50, 15, 1); //starter equilibrado
        pokimon2=new Pokimon(Mates.randomInt(10,20), Mates.randomInt(70,80), Mates.randomInt(10,20), 2); //tanque
        pokimon3=new Pokimon(Mates.randomInt(15,20), Mates.randomInt(20,30), Mates.randomInt(55,60), 3); //asesino
        pokimon4=new Pokimon(Mates.randomInt(30,40), Mates.randomInt(70,80), Mates.randomInt(5,10), 4); //lento
        pokimon5=new Pokimon(Mates.randomInt(50,60), Mates.randomInt(10,15), Mates.randomInt(55,60), 5); //instakill
        pokimon6=new Pokimon(Mates.randomInt(55,60), Mates.randomInt(70,80), Mates.randomInt(55,60), 6); //chetado
        pokemonPelear=new Pokimon();//placeholder

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
        mochila1=new PokiMochila(pokimon1);
        mochila1.pok1.setCapturado(true);

        //empezar partida
        entrenador1.moverse(0);
        while (juegoActivo) {
            //menu
            if (combateActivo) {
                //pokemon a combatir
                opcionValida=false;
                while (!opcionValida) {
                    switch (Mates.randomInt(1, 6)) {
                        case 1:
                            if (!pokimon1.isCapturado()) {
                                pokemonPelear=pokimon1;
                                opcionValida=true;
                            }
                        break;
                        case 2:
                            if (!pokimon2.isCapturado()) {
                                pokemonPelear=pokimon2;
                                opcionValida=true;
                            }
                        break;
                        case 3:
                            if (!pokimon3.isCapturado()) {
                                pokemonPelear=pokimon3;
                                opcionValida=true;
                            }
                        break;
                        case 4:
                            if (!pokimon4.isCapturado()) {
                                pokemonPelear=pokimon4;
                                opcionValida=true;
                            }
                        break;
                        case 5:
                            if (!pokimon5.isCapturado()) {
                                pokemonPelear=pokimon5;
                                opcionValida=true;
                            }
                        break;
                        default:
                            if (!pokimon6.isCapturado()) {
                                pokemonPelear=pokimon6;
                                opcionValida=true;
                            }
                        break;
                    }
                }
                pokemonPelear.curar();

                //menu combate
                System.out.println("\nTe has encontrado con un pokemon salvaje!!!");
                System.out.println("Rival: "+pokemonPelear);
                System.out.println("1.PELEAR 2.CAPTURAR 3.HUIR");
                opcion= teclado.nextInt();
                switch (opcion){

                    case 1://pelear
                        opcionValida=false;
                        while (!opcionValida) {
                            System.out.println("Que pokemon quieres usar?");
                            opcion= teclado.nextInt();                            
                            switch (opcion){
                                case 1://pokemon 1
                                    if (mochila1.pok1.isCapturado()) {
                                        if (mochila1.pok1.lucha(pokemonPelear)==1) {
                                            System.out.println ("Tu pokemon ha ganado");
                                            entrenador1.sumarVictorias();
                                            entrenador1.cambiarDinero(5);
                                        }else{
                                            System.out.println ("Tu pokemon ha perdido");
                                            entrenador1.sumarDerrotas();
                                            entrenador1.cambiarDinero(-3);
                                        }
                                        opcionValida=true;
                                        combateActivo=false;
                                    }else{
                                        System.out.println("No tienes ningun pokemon en ese espacio");
                                    }
                                break;
                                case 2://pokemon 2
                                    if (mochila1.pok2.isCapturado()) {
                                        if (mochila1.pok2.lucha(pokemonPelear)==1) {
                                            System.out.println ("Tu pokemon ha ganado");
                                            entrenador1.sumarVictorias();
                                            entrenador1.cambiarDinero(5);
                                        }else{
                                            System.out.println ("Tu pokemon ha perdido");
                                            entrenador1.sumarDerrotas();
                                            entrenador1.cambiarDinero(-3);
                                        }
                                        opcionValida=true;
                                        combateActivo=false;
                                    }else{
                                        System.out.println("No tienes ningun pokemon en ese espacio");
                                    }
                                break;
                                case 3://pokemon 3
                                    if (mochila1.pok3.isCapturado()) {
                                        if (mochila1.pok3.lucha(pokemonPelear)==1) {
                                            System.out.println ("Tu pokemon ha ganado");
                                            entrenador1.sumarVictorias();
                                            entrenador1.cambiarDinero(5);
                                        }else{
                                            System.out.println ("Tu pokemon ha perdido");
                                            entrenador1.sumarDerrotas();
                                            entrenador1.cambiarDinero(-3);
                                        }
                                        opcionValida=true;
                                        combateActivo=false;
                                    }else{
                                        System.out.println("No tienes ningun pokemon en ese espacio");
                                    }
                                break;
                            }
                        }
                    break;

                    case 2://capturar
                            mochila1.capturar(pokemonPelear);
                            opcionValida=true;
                            combateActivo=false;
                    break;

                    default://huir
                        System.out.println("Huyes exitosamente");
                        combateActivo=false;
                    break;
                }
            }else{
                System.out.println("\nDonde quieres ir: \n 1.ARRIBA 2.DERECHA 3.ABAJO 4.IZQUIERDA \n 5.VER POKIMON 6.LIBERAR 0.ACABAR PARTIDA");
                opcion=teclado.nextInt();
                switch (opcion) {
                    case 0:
                        juegoActivo=false;
                    break;
                    case 5:
                        if (mochila1.getPok1().isCapturado()) {
                            System.out.println("Pokimon 1:");
                            System.out.println(mochila1.getPok1());
                        }
                        if (mochila1.getPok2().isCapturado()) {
                            System.out.println("Pokimon 2:");
                            System.out.println(mochila1.getPok2());
                        }
                        if (mochila1.getPok3().isCapturado()) {
                            System.out.println("Pokimon 3:");
                            System.out.println(mochila1.getPok3());
                        }
                    break;
                    case 6://liberar
                        opcion= teclado.nextInt();
                        System.out.println("Que espacio quieres liberar?");
                        mochila1.liberarPokimon(opcion);
                    break;
                    default:
                        entrenador1.moverse(opcion);
                        if (Math.random()<0.15) {
                            combateActivo=true;
                        }
                    break;
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
