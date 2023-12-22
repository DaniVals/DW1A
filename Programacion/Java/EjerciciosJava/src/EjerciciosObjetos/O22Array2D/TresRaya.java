package EjerciciosObjetos.O22Array2D;

import java.util.Scanner;

public class TresRaya {

    public static void print(int[][] tablero){
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){
                if (tablero[i][j]==0) {
                    System.out.print(". ");
                }else if (tablero[i][j]==1) {
                    System.out.print("x ");
                }else{
                    System.out.print("o ");
                }
            }
            System.out.print("\n");
        }
    }
    public static void cambiar(int[][] tablero, int pos, int jug){
        if (pos==1||pos==2||pos==3) {
            tablero[0][(pos+2)%3]=jug;
            return ;
        }
        if (pos==4||pos==5||pos==6) {
            tablero[1][(pos+2)%3]=jug;
            return ;
        }
        if (pos==7||pos==8||pos==9) {
            tablero[2][(pos+2)%3]=jug;
            return ;
        }
    }
    public static boolean sePuede(int[][] tablero, int pos){
        int i=0;
        if (pos==4||pos==5||pos==6) {
            i=1;
        }
        if (pos==7||pos==8||pos==9) {
            i=2;
        }
        if (tablero[i][(pos+2)%3]==0) {
            return true;
        }
        return false;
    }
    public static int ganador(int[][] tablero, int jug){
        for(int i=0;i<tablero.length;i++){
            //filas
            if (tablero[i][0]==jug&&tablero[i][1]==jug&&tablero[i][2]==jug) {
                return jug;
            }
            //columnas
            if (tablero[0][i]==jug&&tablero[1][i]==jug&&tablero[2][i]==jug) {
                return jug;
            }
        }
        //diagonales
        if (tablero[0][0]==jug&&tablero[1][1]==jug&&tablero[2][2]==jug) {
            return jug;
        }
        if (tablero[2][0]==jug&&tablero[1][1]==jug&&tablero[0][2]==jug) {
            return jug;
        }
        return 0;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        int rival=0;
        int ganador=0;
        boolean turno=true;
        int[][] tablero = new int[3][3];
        int mov=0;

        System.out.println("elije el nivel de dificultad (los no validos se pondra como otro jugador)");
        System.out.println("1-Facil (empiezas tu)");
        System.out.println("2-Normal (aleatorio)");
        System.out.println("3-Dificil (empieza la maquina)");
        rival = teclado.nextInt();
        switch (rival) {
            case 2:
                if (Math.random()<0.5) {
                    turno=true;
                }else{
                    turno=false;
                }
            break;
            case 3:
                turno=false;
            break;
            //facil o PvP
            default:
                turno=true;
            break;
        }
        System.out.println("1 2 3\n4 5 6\n7 8 9");
        while (ganador==0) {
            if (turno) {
                //pedir jugador 1
                System.out.println("donde quiere poner J1?");
                mov=teclado.nextInt();
                while (mov<1||9<mov) {
                    System.out.println("numero no valido");
                    mov=teclado.nextInt();
                }
                if (TresRaya.sePuede(tablero, mov)) {
                    TresRaya.cambiar(tablero, mov, 1);
                    turno=false;
                }else{
                    System.out.println("casilla ocupada");
                }
                ganador=TresRaya.ganador(tablero, 1);
            }else{
                if (0<rival&&rival<4) {
                    do {
                        mov=(int) (Math.random()*9+1);
                    } while (!TresRaya.sePuede(tablero, mov));
                    System.out.println("movimiento maquina");
                    TresRaya.cambiar(tablero, mov, 2);
                    turno=true;
                }else{
                    System.out.println("donde quiere poner J2?");
                    mov=teclado.nextInt();
                    while (mov<1||9<mov) {
                        System.out.println("numero no valido");
                        mov=teclado.nextInt();
                    }
                    if (TresRaya.sePuede(tablero, mov)) {
                        TresRaya.cambiar(tablero, mov, 2);
                        turno=true;
                    }else{
                        System.out.println("casilla ocupada");
                    }
                }
                ganador=TresRaya.ganador(tablero, 2);
            }
            TresRaya.print(tablero);
        }
        System.out.println("ha ganado el jugador J"+ganador);

        teclado.close();
    }
    
}
