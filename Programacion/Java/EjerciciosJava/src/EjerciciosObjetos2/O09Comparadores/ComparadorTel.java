package EjerciciosObjetos2.O09Comparadores;

import java.util.Comparator;

public class ComparadorTel implements Comparator<Contacto> {

    @Override
    public int compare(Contacto o1, Contacto o2) {
        //devuelve +1 si esta por encima, -1 si esta por debajo y 0 si son iguales
        if (o1.getTelefono()<o2.getTelefono()) {
            return -1;
        }
        if (o1.getTelefono()>o2.getTelefono()) {
            return +1;
        }
        return 0;

        // metodo rapido 
        //return o1.getTelefono() - o2.getTelefono();
    }
    
}
