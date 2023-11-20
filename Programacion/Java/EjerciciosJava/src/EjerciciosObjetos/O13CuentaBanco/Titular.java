package EjerciciosObjetos.O13CuentaBanco;

public class Titular {
    
    private String nif;
    private String nombre;
    private String apellidos;
    private Fecha nacimiento;
    
    public Titular(String nif, String nombre, String apellidos, Fecha nacimiento) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
    }
    public String getNif() {
        return nif;}
    public String getNombre() {
        return nombre;}
    public String getApellidos() {
        return apellidos;}
    public Fecha getNacimiento() {
        return nacimiento;}

    public void setNif(String nif) {
        this.nif = nif;}
    public void setNombre(String nombre) {
        this.nombre = nombre;}
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;}
    public void setNacimiento(Fecha nacimiento) {
        this.nacimiento = nacimiento;}
    @Override
    public String toString() {
        return "Titular\n      nif=" + nif + "\n      nombre=" + nombre + 
        "\n      apellidos=" + apellidos + "\n      nacimiento=" + nacimiento;
    }
    public boolean compararTitular(Titular titularComparar){
        if (this.nif==titularComparar.nif&&
            this.nombre==titularComparar.nombre&&
            this.apellidos==titularComparar.apellidos&&
            this.nacimiento.calcularDias(titularComparar.nacimiento)==0) 
        {
            return true;
        }
        return false;
    }

    public boolean titularSimilar(Titular titularComparar){
        if (this.nifSimilar(titularComparar)&&
            this.nombreSimilar(titularComparar)&&
            this.apellidoSimilar(titularComparar)&&
            this.nacimiento.calcularDias(titularComparar.nacimiento)<=5) 
        {
            return true;
        }
        return false;
    }
    private boolean nifSimilar(Titular titularComparar){ //suponiendo que TODOS los nifs son igual de largos
        int discrepancias=0;
        for(int i=0;i<this.nif.length();i++){
            if (this.nif.charAt(i)!=titularComparar.nif.charAt(i)) {
                discrepancias++;
            }
        }
        if (discrepancias<=1) {
            return true;
        }
        return false;
    }
    private boolean nombreSimilar(Titular titularComparar){ 
        int discrepancias=0;
        if (this.nombre.length()==titularComparar.nombre.length()) {
            for(int i=0;i<this.nombre.length();i++){
                if (this.nombre.charAt(i)!=titularComparar.nombre.charAt(i)) {
                    discrepancias++;
                }
            }
            if (discrepancias<=1) {
                return true;
            }
        }
        return false;
    }
    private boolean apellidoSimilar(Titular titularComparar){ 
        int discrepancias=0;
        if (this.apellidos.length()==titularComparar.apellidos.length()) {
            for(int i=0;i<this.apellidos.length();i++){
                if (this.apellidos.charAt(i)!=titularComparar.apellidos.charAt(i)) {
                    discrepancias++;
                }
            }
            if (discrepancias<=1) {
                return true;
            }
        }
        return false;
    }
}
