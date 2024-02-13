package EjerciciosObjetos2.O05Personas;
 
public class Empleado extends Persona{
    private String fecha;
    private int nDespacho,id;

    public Empleado(String nombre, String apellidos, String dni, String estadoCivil, String fecha, int nDespacho, int id) {
        super(nombre, apellidos, dni, estadoCivil);
        this.fecha = fecha;
        this.nDespacho = nDespacho;
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getnDespacho() {
        return nDespacho;
    }

    public void setnDespacho(int nDespacho) {
        this.nDespacho = nDespacho;
    }

    @Override
    public String toString() {
        return "Empleado [nombre=" + this.getNombre() + ", apellidos=" + this.getApellidos() + 
                ", dni=" + this.getDni() + ", estadoCivil="+ this.getEstadoCivil() + 
                ", fecha:" + fecha + ", nDespacho:" + nDespacho + ", id:" + id + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
