package EjerciciosObjetos.O25ListaContactos;

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

}
