package EjerciciosObjetos.O04Baloncesto;

public class Jugador {
    
    private double altura;
    private double porcentajeDoble;
    private double porcentajeTriple;

    //constructores
    public Jugador() {
        this.altura = 1.85;
        this.porcentajeDoble = 0.4;
        this.porcentajeTriple = 0.25;
    }
    public Jugador(double altura, double porcentajeDoble, double porcentajeTriple) {
        this.altura = altura;
        this.porcentajeDoble = porcentajeDoble;
        this.porcentajeTriple = porcentajeTriple;
    }
    
    //setters
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public void setPorcentajeDoble(double porcentajeDoble) {
        this.porcentajeDoble = porcentajeDoble;
    }
    public void setPorcentajeTriple(double porcentajeTriple) {
        this.porcentajeTriple = porcentajeTriple;
    }
    //getters
    public double getAltura() {
        return altura;
    }
    public double getPorcentajeDoble() {
        return porcentajeDoble;
    }
    public double getPorcentajeTriple() {
        return porcentajeTriple;
    }

    public void entrenarDobles() {
        if(Math.random()<0.5){
            this.porcentajeDoble += 0.05;
        }
        if(this.porcentajeDoble>1){
            this.porcentajeDoble = 1;
        }
    }
    public void entrenarTriples() {
        if(Math.random()<0.5){
            this.porcentajeTriple += 0.05;
        }
        if(this.porcentajeTriple>1){
            this.porcentajeTriple = 1;            
        }
    }

    public void entrenarDiasDobles(int dias) {
        for(int i=0; i<dias; i++){
            this.entrenarDobles();
        }
    }
    public void entrenarDiasTriples(int dias) {
        for(int i=0; i<dias; i++){
            this.entrenarTriples();
        }
    }

    public int lanzarDobles() {
        int canasta;
        if(Math.random()<this.porcentajeDoble){//ver si falla
            canasta=0;
        }else{
            canasta=1;
        }
        return canasta;
    }
    public int lanzarTriples() {
        int canasta;
        if(Math.random()<this.porcentajeTriple){//ver si falla
            canasta=0;
        }else{
            canasta=1;
        }
        return canasta;
    }

    @Override
    public String toString() {
        return "Jugador [altura=" + altura + ", porcentajeDoble=" + porcentajeDoble + ", porcentajeTriple="
                + porcentajeTriple + "]";
    }
    

    
}
