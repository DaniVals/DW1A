package EjerciciosObjetos.O23HundirFlota;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Menu.teclado = new Scanner(System.in);

        Menu.empezarPartida();

        Menu.teclado.close();
    }
}
