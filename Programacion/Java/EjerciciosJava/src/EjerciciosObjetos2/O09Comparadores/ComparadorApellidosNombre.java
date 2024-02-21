package EjerciciosObjetos2.O09Comparadores;

import java.util.Comparator;

public class ComparadorApellidosNombre implements Comparator<ContactoPersona>{

    @Override
    public int compare(ContactoPersona o1, ContactoPersona o2) {
        if (o1.getApellido().compareToIgnoreCase(o2.getApellido())==0) {
            return o1.getNombre().compareToIgnoreCase(o2.getNombre());
        }
        return o1.getApellido().compareToIgnoreCase(o2.getApellido());
    }
    
}
