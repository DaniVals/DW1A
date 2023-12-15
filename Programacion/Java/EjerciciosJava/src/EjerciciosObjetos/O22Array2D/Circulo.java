package EjerciciosObjetos.O22Array2D;

import java.util.Scanner;

public class Circulo {
    public static void main(String[] args){

        Scanner teclado=new Scanner(System.in);

        int radio;
        System.out.println("radio del circulo");
        radio=teclado.nextInt();

        char[][] dibujar;
        dibujar=new char[radio*2+1][radio*2+1];

        for(int i=0;i<dibujar.length;i++){
             for(int j=0;j<dibujar[i].length;j++){
                 dibujar[i][j]=' ';
                    if(Math.sqrt(Math.pow(i-radio, 2)+Math.pow(j-radio, 2))<radio){
                    dibujar[i][j]='o';
                    }
                    if(Math.sqrt(Math.pow(i-radio, 2)+Math.pow(j-radio, 2))<radio-1){
                    dibujar[i][j]='x';
                    }
                }
            }
        dibujar[radio][radio]='o';
        for(int i=0;i<dibujar.length;i++){
            System.out.print("| ");
            for(int j=0;j<dibujar[i].length;j++){
                System.out.print(dibujar[i][j]+ " ");
            }
            System.out.println("|");
        }
        teclado.close();
    }
}
