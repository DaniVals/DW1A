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
    public static boolean cambiar(int[][] tablero, int pos, int jug){
        if (pos==1||pos==2||pos==3) {
            tablero[0][(pos+2)%3]=jug;
            return true;
        }
        if (pos==4||pos==5||pos==6) {
            tablero[1][(pos+2)%3]=jug;
            return true;
        }
        if (pos==7||pos==8||pos==9) {
            tablero[2][(pos+2)%3]=jug;
            return true;
        }
        return false;
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
            case 1:
                if (Math.random()<0.5) {
                    turno=true;
                }else{
                    turno=false;
                }
            break;
            case 2:
                turno=false;
            break;
            //facil o PvP
            default:
                turno=true;
            break;
        }
        System.out.println("1 2 3\n4 5 6\n7 8 9");
        while (ganador==0) {
            System.out.println("donde quiere poner?");
            mov=teclado.nextInt();
            while (mov<1||9<mov) {
                System.out.println("numero no valido");
                mov=teclado.nextInt();
            }
            if (TresRaya.cambiar(tablero, mov, 1)) {
                
            }

            if (turno) {
            }
            TresRaya.print(tablero);
        }


        teclado.close();
    }
    
}
