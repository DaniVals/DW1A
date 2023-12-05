package EjerciciosObjetos.O21ProfeAlumno;

public class Profesor {
    
    private String nombre;
    public Profesor(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void ponerNota(Alumno evaluado){
        double nota1, nota2, nota3;
        nota1 = Math.random()*10;
        nota2 = Math.random()*10;
        nota3 = Math.random()*10;
        evaluado.evaluarAsignaturas(Mates.truncarDecimales(nota1, 2),
                                    Mates.truncarDecimales(nota2, 2),
                                    Mates.truncarDecimales(nota3, 2));
    }
    public void ponerNota2(Alumno evaluado){
        double nota1, nota2, nota3;
        nota1 = Math.random()*10;
        nota2 = Math.random()*10;
        nota3 = Math.random()*10;
        evaluado.getAsig1().ponerNota(nota1);
        evaluado.getAsig2().ponerNota(nota2);
        evaluado.getAsig3().ponerNota(nota3);
    }
    public double hacerMedia(Alumno evaluado){
        double asig1, asig2, asig3;
        asig1=evaluado.getAsig1().getNota();
        asig2=evaluado.getAsig2().getNota();
        asig3=evaluado.getAsig3().getNota();
        return ((asig1+asig2+asig3)/3);
    }
}
