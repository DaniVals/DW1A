package EjerciciosObjetos.O14FrabicanteProducto;

public class Main {
    public static void main(String[] args){

        Fabricante f1=new Fabricante("Fernando", "654987123", "lelo@gmail.com");
        System.out.println(f1);
        Producto p1=new Producto("B009a", "nu@--_ll,8.;8", "ve<<<ge€t@a-.´ç`ñç´777", 0.1, f1);
        System.out.println(p1);

    }
}
