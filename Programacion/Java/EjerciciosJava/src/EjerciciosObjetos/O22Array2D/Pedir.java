package EjerciciosObjetos.O22Array2D;

import java.util.Scanner;

public class Pedir {
    public static void main(String[] args){

        Scanner teclado=new Scanner(System.in);

        int[][] numeros;
        //={{1,2,3,4},{1,2,3,4},{1,2,3,4}}
        numeros=new int[3][4];

        for(int i=0;i<numeros.length;i++){
            for(int j=0;j<numeros[i].length;j++){
                System.out.println("numero en posicion (" +i+","+j+ ")");
                numeros[i][j]=teclado.nextInt();
            }
        }
        for(int i=0;i<numeros.length;i++){
            System.out.print("| ");
            for(int j=0;j<numeros[i].length;j++){
                System.out.print(numeros[i][j]+ " ");
            }
            System.out.println("|");
        }
        teclado.close();
    }
    
}
