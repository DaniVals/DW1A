package FuncionesCopias;

import java.util.Scanner;

public class PedirValidado {
    public static int NumeroTelefonico(Scanner teclado){
        System.out.println("Introduzca un numero telefonico (9 digitos)");
        boolean valido=false;
        int pedido = 0;
        while (!valido) {
            try {
                pedido = Integer.parseInt(teclado.nextLine());
                valido = true;

                // Restricciones
                if (pedido<100000000) {
                    valido = false;
                    System.out.println("Introduzca un numero mayor de 100000000");
                }else if (999999999<pedido) {
                    valido = false;
                    System.out.println("Introduzca un numero menor de 999999999");
                }
            } catch (NumberFormatException e) {
                System.out.println("Introduzca un numero");
            }
        }
        return pedido;
    }
}
