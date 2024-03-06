package Examen2.Ej1;

public class ToString {
    public static String string2D(int[][] imprimir){
        String devolver="";
        for(int i=0;i<imprimir.length-1;i++){
            devolver+=string1D(imprimir[i]);
            devolver+="\n";
        }
        devolver+=string1D(imprimir[imprimir.length-1]);
        return devolver;
    }
    public static String string1D(int[] imprimir){
        String devolver="";
        for(int i=0;i<imprimir.length-1;i++){
            devolver+=imprimir[i]+" ";
        }
        devolver+=imprimir[imprimir.length-1]+"";
        return devolver;
    }
}
