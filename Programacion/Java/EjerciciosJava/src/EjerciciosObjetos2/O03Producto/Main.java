package EjerciciosObjetos2.O03Producto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        ProductoAlimentacion judias = new ProductoAlimentacion("judias", 1, 1, 8888, 95);
        ProductoElectronico lavadora= new ProductoElectronico("lavadora", 230, 900, 99, 1501);
        ProductoTextil        jersey= new ProductoTextil("jersey", 88, 20, 550, "pitufos");

        Scanner teclado=new Scanner(System.in);

        System.out.println("Cual es el valor nutricional de "+judias.getNombre());
        judias.setValorNutricional(teclado.nextInt());
        System.out.println(judias.getNombre()+"tienen un valor nutricional de "+judias.categoria());

        System.out.println("Cuanto tiempo (s) quiere usar su "+lavadora.getNombre()+" de "+lavadora.getPrecio()+" euros");
        System.out.println("su "+lavadora.getNombre()+" gastara un total de "+lavadora.calcularGasto(teclado.nextInt()));

        System.out.println("Cual es el material de "+jersey.getNombre());
        jersey.setMaterial(teclado.nextLine());
        System.out.println(jersey);

        teclado.close();


    }
}
