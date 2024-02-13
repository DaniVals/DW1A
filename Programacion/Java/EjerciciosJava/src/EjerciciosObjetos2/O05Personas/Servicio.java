package EjerciciosObjetos2.O05Personas;

public class Servicio extends Empleado{
    private String seccion;

    public Servicio(String nombre, String apellidos, String dni, String estadoCivil, String fecha, int nDespacho, int id,
            String seccion) {
        super(nombre, apellidos, dni, estadoCivil, fecha, nDespacho,id);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    
    @Override
    public String toString() {
        return "Empleado [nombre=" + this.getNombre() + ", apellidos=" + this.getApellidos() + 
                ", dni=" + this.getDni() + ", estadoCivil="+ this.getEstadoCivil() + 
            ", fecha=" + this.getFecha() + ", nDespacho=" + this.getnDespacho() + 
        ", seccion="+seccion+"]";
    }
}
