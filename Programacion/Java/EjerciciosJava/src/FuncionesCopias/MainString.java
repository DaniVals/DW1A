package FuncionesCopias;

import java.util.Scanner;

public class MainString {
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);

        int[][] a={{4,7,2,9,10,6},{1,2,3,4},{8,8,8,8,8,8,8}};

        int[][] b={{4,7,2},{1,2,3},{8,8,8}};
        int[][] c={{1,1,1},{2,3,4},{8,8,8}};
        System.out.println("Array introducido \n"+ IntArray.string2D(a));
        System.out.println("Suma array\n"+ IntArray.string1D(IntArray.suma1DInt2D(a)));
        System.out.println("Suma total\n"+IntArray.suma0DInt1D(IntArray.suma1DInt2D(a)));

        System.out.println("Traspuesta\n"+IntArray.string2D(IntArray.traspuesta2D(a)));
        System.out.println("Buscar 4\n"+(IntArray.buscar2D(a, 4)));
        System.out.println("Array b \n"+ IntArray.string2D(b));
        System.out.println("Array c \n"+ IntArray.string2D(c));
        //System.out.println("producto\n"+IntArray.string2D(IntArray.producto2Dx1D(b,c)));

        System.out.println("Suma matriz\n"+IntArray.string2D(IntArray.sumaMatriz(c, b)));

        teclado.close();
    }
}
