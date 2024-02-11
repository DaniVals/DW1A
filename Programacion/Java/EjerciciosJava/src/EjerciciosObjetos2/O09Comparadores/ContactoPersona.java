package EjerciciosObjetos2.O09Comparadores;

public class ContactoPersona extends Contacto {
    
    String nombre, apellido;
    
    public ContactoPersona(String correo, int telefono, String nombre, String apellido) {
        super(correo, telefono);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "ContactoPersona \n\tnombre:" + nombre + "\n\tapellido:" + apellido + super.toString();
    }

}
