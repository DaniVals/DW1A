package EjerciciosObjetos.O21ProfeAlumno;

import java.util.Arrays;

public class Grupo {
    private Profesor profe;
    private Alumno[] arrayAlumnos=new Alumno[29];
    private int length;

    public Grupo(Profesor profe, Alumno[] arrayAlumnos) {
        this.profe = profe;
        for(int i=0; i<arrayAlumnos.length;i++){
            this.arrayAlumnos[i]=arrayAlumnos[i];
        }
        //se que se quedan valores en null, pero nunca accede a ellos al guardar la longitud como una variable aparte
        //y porque se salta los casos en los que la id de alumno es 0 (los placeholders)
        this.length=arrayAlumnos.length;
    }
    public Grupo(Profesor profe) {
        this.profe = profe;
        this.length=arrayAlumnos.length;
    }
    public Alumno getAlumno(int index){
        return arrayAlumnos[index];
    }
    public void setAlumno(int index,Alumno alum){
        arrayAlumnos[index]=alum;
    }
    public void addAlumno(Alumno alum){
        arrayAlumnos[length]=alum;
        length++;
    }
    public void delAlumno(){
        arrayAlumnos[length]=new Alumno();
        length--;
    }

    public Alumno[] getArrayAlumnos() {
        return arrayAlumnos;
    }
    public int getLength() {
        return length;
    }
    public Profesor getProfe() {
        return profe;
    }

    public void calificarGrupo(){
        for(int i=0; i<this.length;i++){
            if (this.arrayAlumnos[i].getId()==0) {
                this.profe.ponerNota(this.arrayAlumnos[i]);
            }
        }
    }
    public float calcularMedia(){
        float media=0;
        int numMedia=0;
        for(int i=0; i<this.length;i++){
            if (this.arrayAlumnos[i].getId()==0) {
                numMedia++;
                media+=this.profe.hacerMedia(this.arrayAlumnos[i]);
            }
        }
        media=media/numMedia;
        return media;
    }
    public Alumno calcularMediaAlta(){
        Alumno alumMasAlto=this.arrayAlumnos[0];
        for(int i=0; i<this.length;i++){
            if (this.arrayAlumnos[i].getId()==0) {
                if (this.profe.hacerMedia(arrayAlumnos[i])>this.profe.hacerMedia(alumMasAlto)) {
                    alumMasAlto=arrayAlumnos[i];
                }
            }
        }
        return alumMasAlto;
    }
    public double getAlumnoConNotaMasAlta(){
        Alumno alumMasAlto=this.arrayAlumnos[0];
        for(int i=0; i<this.length;i++){
            if (this.arrayAlumnos[i].getId()==0) {
                if (arrayAlumnos[i].getAsigMasAlta().getNota()>alumMasAlto.getAsigMasAlta().getNota()) {
                    alumMasAlto=arrayAlumnos[i];
                }
            }
        }
        return alumMasAlto.getAsigMasAlta().getNota();
    }

    @Override
    public String toString() {
        return "Grupo [arrayAlumnos=" + Arrays.toString(arrayAlumnos) + "]";
    }

    
}
