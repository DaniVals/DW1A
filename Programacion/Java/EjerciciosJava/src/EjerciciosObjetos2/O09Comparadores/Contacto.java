package EjerciciosObjetos2.O09Comparadores;

public class Contacto {
    
    private String correo;
    private int telefono;
    
    public Contacto(String correo, int telefono) {
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        if (this instanceof Contacto) {
            return "Contacto \n\tcorreo:" + correo + "\n\ttelefono:" + telefono;
        }
        return "\n\tcorreo:" + correo + "\n\ttelefono:" + telefono;
    }    
    
}
