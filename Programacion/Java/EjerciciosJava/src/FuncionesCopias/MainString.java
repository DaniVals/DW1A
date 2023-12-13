package FuncionesCopias;

import java.util.Scanner;

public class MainString {
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);

        int[] a={4,4,7,4,2,2,7,8,9,11};
        int[] b;
        b=Arrays.ordenarArrayInt(a);

        System.out.println("sin ordenar");
        Arrays.printInt(a);
        System.out.println("ordenado");
        Arrays.printInt(b);

        teclado.close();
    }
}
