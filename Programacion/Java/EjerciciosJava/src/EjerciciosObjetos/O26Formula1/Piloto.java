package EjerciciosObjetos.O26Formula1;

import java.util.ArrayList;

public class Piloto {
    
    private int licencia;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private ArrayList<Integer> puntos;
    
    public Piloto(int licencia, String nombre, String apellido, String nacionalidad, ArrayList<Integer> puntos) {
        this.licencia = licencia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.puntos = puntos;
    }

    public int getLicencia() {
        return licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public ArrayList<Integer> getPuntos() {
        return puntos;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setPuntos(ArrayList<Integer> puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return  "Piloto " + licencia + 
                "\n  nombre:" + nombre + " " + apellido + 
                "\n  nacionalidad:" + nacionalidad + 
                "\n  media:" + mediaPuntos();
    }
    public double mediaPuntos(){
        double media=0;
        for(int p: puntos){
            media+=p;
        }
        if (puntos.size()!=0) {
            return media/puntos.size();
        }
        return 0;
    }
    
}
