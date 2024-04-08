package src.F17DaoContactos;

public class Contacto {
    private int telefono;
    private String direccion;
    private String correo;
    private String nombre;


    public Contacto(int telefono, String direccion, String correo, String nombre) {
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Contacto [telefono=" + telefono + ", direccion=" + direccion + ", correo=" + correo + ", nombre="
                + nombre + "]";
    }

    public int getTelefono() 		{return telefono;}
    public String getDireccion() 	{return direccion;}
    public String getCorreo() 		{return correo;}
    public String getNombre() 		{return nombre;}

    public void setTelefono	(int telefono) 		{this.telefono = telefono;}
    public void setDireccion(String direccion) 	{this.direccion = direccion;}
    public void setCorreo	(String correo) 	{this.correo = correo;}
    public void setNombre	(String nombre) 	{this.nombre = nombre;}



    
    
}
