package EjerciciosObjetos.O21ProfeAlumno;
//modificar el grupo para que haga un maximo de 30, constructor grupo sin alumnos, metodo añadir alumno y borrar
//clase escuela, almacena max 30 grupos, calificacion global, media global, obtener nota mas alta global y mas baja
//clase provincia ==
public class Main {
    public static void main(String[] args) {

        Profesor profe1=new Profesor("jose");

        Alumno alum1=new Alumno(1, 2, 3);
        Alumno alum2=new Alumno(3, 2, 1);
        Alumno alum3=new Alumno(1, 2, 4);
        Alumno alum4=new Alumno(1, 2, 4);
        Alumno alum5=new Alumno(1, 2, 4);
        Alumno[] array={alum1,alum2,alum3};

        Grupo grupo1=new Grupo(profe1, array);

        grupo1.addAlumno(alum4);
        grupo1.delAlumno();
        grupo1.delAlumno();
        grupo1.addAlumno(alum5);
        
        grupo1.calificarGrupo();

        System.out.println(grupo1);
        System.out.println(
            "CP1 \n"+
            grupo1.calcularMedia()+"\n"+
            grupo1.calcularMediaAlta()+"\n"+
            grupo1.getAlumnoConNotaMasAlta()
        );

    }
    
}
