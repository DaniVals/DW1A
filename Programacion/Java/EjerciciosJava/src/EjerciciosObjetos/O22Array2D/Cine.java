package EjerciciosObjetos.O22Array2D;

import java.util.Scanner;

public class Cine {
    public static void main(String[] args){
        //Realizar un programa que gestione la venta de entradas en un cine. Como máximo se 
        //pueden comprar 5 entradas en una misma transacción. Al comprar las entradas se
        //podrán elegir butacas. La sala tiene 14 filas con 20 asientos cada una. Se mostrarán al
        //usuario las butacas del cine (libres y ocupadas) para que pueda elegir donde sentarse. 

        Scanner teclado = new Scanner(System.in);

        int entradas=0;
        boolean[][] asientos = new boolean[14][20];
        do {
            System.out.println("cuantas entradas quieres? (1-5)");
            entradas=Integer.parseInt( teclado.nextLine());
        } while (entradas<1||5<entradas);



        while (0<entradas) {
            System.out.print(" 1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20\n");
            for(int i=0;i<asientos.length;i++){
                for(int j=0;j<asientos[i].length;j++){
                    if (asientos[i][j]) {
                        System.out.print(" x ");
                    }else{
                        System.out.print(" o ");
                    }
                }
                System.out.print((1+i)+"\n");
            }
            System.out.println("El x representa ocupado y el o libre");
            int x;
            int y;
            do {
                System.out.println("Introduzca la posicion de su asiento");
                x=Integer.parseInt( teclado.next());
                y=Integer.parseInt( teclado.next());
            } while (x<1||14<x||y<1||20<y);
            
            if (asientos[x-1][y-1]) {
                System.out.println("-----------------------\nasiento ya ocupado");
            }else{
                asientos[x-1][y-1]=true;
                System.out.println("asiento "+x+" "+y+" comprado");
                entradas--;
            }
        }

        teclado.close();
    }
    
}
