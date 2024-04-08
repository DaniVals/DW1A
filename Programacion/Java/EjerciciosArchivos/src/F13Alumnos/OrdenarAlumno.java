package src.F13Alumnos;

import java.util.Comparator;

import src.F16AlumnosRAF.Alumno;

public class OrdenarAlumno implements Comparator<Alumno> {
    
    @Override
    public int compare(Alumno a1, Alumno a2) {
        return a1.getNumExpediente() - a2.getNumExpediente();
    }
}
