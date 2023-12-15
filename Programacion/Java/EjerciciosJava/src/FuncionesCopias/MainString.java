package FuncionesCopias;

import java.util.Arrays;
import java.util.Scanner;

public class MainString {
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);

        int[][] a={{4,7,2,9,10,6},{1,2,3,4},{8,8,8}};
        System.out.println("Array introducido \n"+ IntArray.string2D(a));
        System.out.println("Suma array\n"+ IntArray.string1D(IntArray.suma1DInt2D(a)));
        System.out.println("Suma total\n"+IntArray.suma0DInt1D(IntArray.suma1DInt2D(a)));

        teclado.close();
    }
}
