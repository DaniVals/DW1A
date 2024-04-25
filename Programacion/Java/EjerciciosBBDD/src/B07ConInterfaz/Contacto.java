package B07ConInterfaz;

public class Contacto {
    private int id;
    private int telefono;
    private String correo;
    private String nombre;
    private String apellido;


    public Contacto(int id, int telefono, String apellido, String correo, String nombre) {
        this.id = id;
        this.telefono = telefono;
        this.apellido = apellido;
        this.correo = correo;
        this.nombre = nombre;
    }

    public int getId() 		{return id;}
    public int getTelefono() 		{return telefono;}
    public String getCorreo() 		{return correo;}
    public String getNombre() 		{return nombre;}
    public String getApellido() 	{return apellido;}

    public void setId   	(int id) 		    {this.id = id;}
    public void setTelefono	(int telefono) 		{this.telefono = telefono;}
    public void setCorreo	(String correo) 	{this.correo = correo;}
    public void setNombre	(String nombre) 	{this.nombre = nombre;}
    public void setApellido(String apellido) 	{this.apellido = apellido;}
}
