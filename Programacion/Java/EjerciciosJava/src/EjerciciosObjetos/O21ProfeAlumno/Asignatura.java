package EjerciciosObjetos.O21ProfeAlumno;

public class Asignatura {
    
    private int identificador;
    private double nota;

    public Asignatura(int identificador) {
        this.identificador = identificador;
        this.nota = 0;
    }

    public int getIdentificador() {
        return identificador;
    }
    public double getNota() {
        return nota;
    }

    public void ponerNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "[" + nota + "]";
    }
    
}
