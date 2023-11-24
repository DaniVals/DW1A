package Examen1;

public class Mago {
    private String nombre;
    private int poder;
    private boolean estado; //si esta en true NO puede lanzar hechizos y viceversa
    // constructor
    public Mago(String nombre, int poder, boolean estado) {
        //evitar valores null
        if (nombre==null) {
            this.nombre = "";
        }else{
            this.nombre = nombre;
        }
        //evitar valores negativos
        if (poder<0) {
            this.poder = 0;
        }else{
            this.poder = poder;
        }
        this.estado = estado;
    }
    // getters
    public String getNombre() {
        return nombre;
    }
    public int getPoder() {
        return poder;
    }
    public boolean isEstado() {
        return estado;
    }
    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPoder(int poder) {
        this.poder = poder;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    //metodos
    public String combateDragon(Dragon dragon){
        //ganar si el dragon es verde
        if (dragon.getColor()=="verde") {
            return "victoria";
        }
        //contar las vocales
        int numVocales=0;
        if (this.nombre.indexOf("a")>=0) {
            numVocales++;
        }
        if (this.nombre.indexOf("e")>=0) {
            numVocales++;
        }
        if (this.nombre.indexOf("i")>=0) {
            numVocales++;
        }
        if (this.nombre.indexOf("o")>=0) {
            numVocales++;
        }
        if (this.nombre.indexOf("u")>=0) {
            numVocales++;
        }
        //comprobar las vocales para devolver si gana
        if (3<=numVocales) {
            return "victoria";
        }
        return "derrota";
    }
    public void promocionar(){
        //contar las H y las J, ignorando las mayusculas
        int numHJ=0;
        for(int i=0;i<this.nombre.length();i++){
            if (this.nombre.toLowerCase().charAt(i)=='h') {
                numHJ++;
            }
            if (this.nombre.toLowerCase().charAt(i)=='j') {
                numHJ++;
            }
        }
        //si su poder es menor a 10, tiene mas H y J que poder Y esta activo, se duplica su poder
        if (this.poder<10&&this.poder<numHJ&&this.estado) {
            this.poder=this.poder*2;
        }
    }
}