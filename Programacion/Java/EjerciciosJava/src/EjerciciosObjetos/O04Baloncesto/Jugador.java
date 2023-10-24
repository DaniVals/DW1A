package EjerciciosObjetos.O04Baloncesto;

public class Jugador {
    
    private double altura;
    private double porcentajeDoble;
    private double porcentajeTriple;

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

    public double getPorcentajeDoble() {
        return porcentajeDoble;
    }
    public double getPorcentajeTriple() {
        return porcentajeTriple;
    }

    public void entrenarDobles() {
        this.porcentajeDoble += 0.05;
        if(this.porcentajeDoble>1){
            this.porcentajeDoble = 1;
        }
    }
    public void entrenarTriples() {
        this.porcentajeTriple += 0.05;
        if(this.porcentajeTriple>1){
            this.porcentajeTriple = 1;            
        }
    }

    public void entrenarDiasDobles(int dias) {
        this.porcentajeDoble += 0.05*dias;
        if(this.porcentajeDoble>1){
            this.porcentajeDoble = 1;            
        }
    }
    public void entrenarDiasTriples(int dias) {
        this.porcentajeTriple += 0.05*dias;
        if(this.porcentajeTriple>1){
            this.porcentajeTriple = 1;
        }
    }

    public int lanzarDobles() {
        int canasta;
        this.porcentajeDoble += 0.005;
        return canasta;
    }
    public int lanzarTriples() {
        int canasta;
        this.porcentajeTriple += 0.005;
        return canasta;
    }

    @Override
    public String toString() {
        return "Jugador [altura=" + altura + ", porcentajeDoble=" + porcentajeDoble + ", porcentajeTriple="
                + porcentajeTriple + "]";
    }
    

    
}
