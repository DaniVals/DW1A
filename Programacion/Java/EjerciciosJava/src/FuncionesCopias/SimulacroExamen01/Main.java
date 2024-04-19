package FuncionesCopias.SimulacroExamen01;

import FuncionesCopias.SimulacroExamen01.Manzana.COLOR;

public class Main {
    public static void main(String[] args) {

        Fruta manzana = new Manzana(1.2,5,COLOR.ROJO);
        Fruta platano = new Platano(1.5, 2, "null");


        System.out.println(manzana.getPrecio());
        System.out.println(platano.getPrecio());
    }
}
