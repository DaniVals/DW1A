package Examen2.Ej2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lista l = new Lista(new ArrayList<Robot>());
        Scanner teclado = new Scanner(System.in);

        l.add(new Industrial("5", "Carbon v1", 3, "Logitech"));
        l.add(new Industrial("6", "Carbon v2", 3, "Logitech"));
        l.add(new Industrial("50", "Carbon v3", 5, "Logitech"));
        l.add(new Industrial("25", "Hierro v2.1", 4, "Logitech"));
        l.add(new Industrial("885", "Diamante v0", 44, "Logitech"));
        l.add(new Investigacion("1", "Mili v1", 3, 69));
        l.add(new Investigacion("2", "Mili v1", 4, 765));
        l.add(new Investigacion("3", "Micro", 5, 22));
        l.add(new Investigacion("11", "Mili v2", 2, 3));
        l.add(new Investigacion("108", "Nano", 1, 99999));

        System.out.println(l);

        // apartado A
        System.out.println("Id del robot?");
        System.out.println(l.pedirID(teclado.nextLine()));
        // apartado B
        l.ordenar();
        System.out.println(l);
        teclado.close();
    }
}
