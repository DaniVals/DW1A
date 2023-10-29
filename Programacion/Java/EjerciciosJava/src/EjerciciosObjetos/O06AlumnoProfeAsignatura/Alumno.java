package EjerciciosObjetos.O06AlumnoProfeAsignatura;

public class Alumno {
    
    private Asignatura asig1;
    private Asignatura asig2;
    private Asignatura asig3;
    
    public Alumno(Asignatura asig1, Asignatura asig2, Asignatura asig3) {
        this.asig1 = asig1;
        this.asig2 = asig2;
        this.asig3 = asig3;
    }

    public Alumno(int idAsig1, int idAsig2, int idAsig3) {
        this.asig1 = new Asignatura(idAsig1);
        this.asig2 = new Asignatura(idAsig2);
        this.asig3 = new Asignatura(idAsig3);
    }

    public Asignatura getAsig1() {
        return asig1;
    }
    public Asignatura getAsig2() {
        return asig2;
    }
    public Asignatura getAsig3() {
        return asig3;
    }

    @Override
    public String toString() {
        return "Alumno [asig1=" + asig1 + ", asig2=" + asig2 + ", asig3=" + asig3 + "]";
    }

    public void evaluarAsignaturas(double notaAsig1, double notaAsig2, double notaAsig3){
        this.asig1.ponerNota(notaAsig1);
        this.asig2.ponerNota(notaAsig2);
        this.asig3.ponerNota(notaAsig3);
    }
    
}
