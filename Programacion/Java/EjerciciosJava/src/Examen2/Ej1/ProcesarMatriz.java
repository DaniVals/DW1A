package Examen2.Ej1;

public class ProcesarMatriz {
    public static int[][] procesarMatriz(String[][] matriz){
        int[][] procesado = new int[2][matriz.length];
        for(int i=0;i<matriz.length;i++){
            procesado[0][i]= -1;
            procesado[1][i]= -1;
            for(int j=0;j<matriz[i].length;j++){
                int comparar=StringToInt.TextoNumero(matriz[i][j]);
                if (procesado[1][i]<comparar) {
                    procesado[1][i]=comparar;
                    procesado[0][i]= j;
                }
            }
        }
        return procesado;
    }
}
