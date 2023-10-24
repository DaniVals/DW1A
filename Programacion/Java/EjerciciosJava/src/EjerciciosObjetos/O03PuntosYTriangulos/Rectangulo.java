package EjerciciosObjetos.O03PuntosYTriangulos;

public class Rectangulo {
    
    private int anchura;
    private int altura;
    private Punto origen;

    //constructor en blanco
    public Rectangulo() {
        this.anchura = 0;
        this.altura = 0;
    }
    //puedes pedir un punto
    public void setOrigen(Punto p){
        this.origen = p;
    }
    //o crearlo nuevo
    public void setOrigen2(int newX, int newY){
        this.origen = new Punto(newX, newY);
    }
    public String getOrigen(){
        return("("+this.origen.getX()+","+
        this.origen.getY()+")");
    }

    //mover, NO desplazar
    public void mover(int newX, int newY){
        this.origen.setX(newX);
        this.origen.setY(newY);
    }

    public int calcularArea(){
        return (this.anchura*this.altura);
    }

    @Override
    public String toString() {
        return "Rectangulo [anchura=" + anchura + ", altura=" + altura + ", origen=" + this.getOrigen() + "]";
    }
    
}
