package Examen2.Ej1;

public class Ej1 {
    public static void main(String[] args) {
        String[][] matriz = {{"123","213","321","132"},{"5564","9","76","777"},{"43243d242","holaaa","f43442321","4355443d"}};
        int[][] resultado = ProcesarMatriz.procesarMatriz(matriz);
        System.out.println(ToString.string2D(resultado));
    }
}