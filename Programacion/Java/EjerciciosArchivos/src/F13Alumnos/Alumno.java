package src.F13Alumnos;

import java.io.Serializable;

public class Alumno implements Serializable {
    private String nombre, apellido;
    private int numExpediente;
    
    public Alumno(int numExpediente, String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numExpediente = numExpediente;
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
    public int getNumExpediente() {
        return numExpediente;
    }
    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }

    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", numExpediente=" + numExpediente + "]";
    }

    
}
