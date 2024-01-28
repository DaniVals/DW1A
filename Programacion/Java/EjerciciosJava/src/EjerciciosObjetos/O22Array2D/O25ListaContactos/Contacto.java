package EjerciciosObjetos.O22Array2D.O25ListaContactos;

public class Contacto {
    private String telefono;
    private String direccion;
    private String correo;

    private boolean persona;

    private String nombre;
    private String apellidos;

    private String postal;
    private String sector;

    public Contacto(String telefono, String direccion, String correo, boolean persona, String nombre,
            String apellidos, String postal, String sector) {
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.persona = persona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.postal = postal;
        this.sector = sector;
    }

    @Override
    public String toString() {
        if (this.persona) {
            return "Nombre: " + nombre + " " + apellidos +
            "\n    nº tel: " + telefono +
            "\n    dirrec: " + direccion +
            "\n    correo: " + correo;
        }
        return "Empresa: " + sector +
        "\n    nº tel: " + telefono +
        "\n    dirrec: " + direccion +
        "\n    correo: " + correo +
        "\n    cd pos: " + postal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isPersona() {
        return persona;
    }

    public void setPersona(boolean persona) {
        this.persona = persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

}
