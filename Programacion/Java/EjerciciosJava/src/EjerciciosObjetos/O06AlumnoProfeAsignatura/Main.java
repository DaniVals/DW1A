package EjerciciosObjetos.O06AlumnoProfeAsignatura;

public class Main {
    public static void main(String[] args) {

        Asignatura asig1, asig2, asig3;
        Alumno alum1;
        Profesor profe1;

        asig1=new Asignatura(0);
        asig2=new Asignatura(4);
        asig3=new Asignatura(11);

        alum1=new Alumno(asig1, asig2, asig3);

        profe1=new Profesor();

        profe1.ponerNota(alum1);
        System.out.println(alum1);
        profe1.hacerMedia(alum1);
        
        profe1.ponerNota2(alum1);
        System.out.println(alum1);
        profe1.hacerMedia(alum1);
            
    }
}
