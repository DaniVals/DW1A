package EjerciciosObjetos.O06AlumnoProfeAsignatura;

public class Main {
    public static void main(String[] args) {

        Asignatura asig1, asig2, asig3;
        Alumno alum1;

        asig1=new Asignatura(0);
        asig2=new Asignatura(4);
        asig3=new Asignatura(11);

        alum1=new Alumno(asig1, asig2, asig3);

        Profesor.ponerNota(alum1);
        System.out.println(alum1);
        Profesor.hacerMedia(alum1);
        
        Profesor.ponerNota2(alum1);
        System.out.println(alum1);
        Profesor.hacerMedia(alum1);
            
    }
}
