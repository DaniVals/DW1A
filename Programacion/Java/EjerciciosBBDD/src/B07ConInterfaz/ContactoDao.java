package B07ConInterfaz;

import java.util.List;

public interface ContactoDao {
    // creamos una interfaz en la cual definimos los metodos que vamos a usar en nuestra base de datos

    List<Contacto> getContactos();
    Contacto getContactoPorNumero(int num);
    void agregarContacto(Contacto c);
    void borrarContacto(Contacto c);
}
