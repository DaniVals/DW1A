package EjerciciosObjetos.O30Cuentas;

public class Titular {
    
    private String nombre;
    private String apellido;
    private int edad;
    
    public Titular(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "nombre:" + nombre + " " + apellido + ", edad:" + edad;
    }



}
