package EjerciciosObjetos2.O05Personas;

public class Profesor extends Empleado{
    private String departamento;

    public Profesor(String nombre, String apellidos, String dni, String estadoCivil, String fecha, int nDespacho, int id,
            String departamento) {
                super(nombre, apellidos, dni, estadoCivil, fecha, nDespacho,id);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado [nombre=" + this.getNombre() + ", apellidos=" + this.getApellidos() + 
                ", dni=" + this.getDni() + ", estadoCivil="+ this.getEstadoCivil() + 
            ", fecha=" + this.getFecha() + ", nDespacho=" + this.getnDespacho() + 
        ", departamento="+departamento+"]";
    }
}
