package EjerciciosObjetos.O03PuntosYTriangulos;

public class Punto {
    
    private int x=0;
    private int y=0;
    
    //constructor
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public void setX(int newX) {
        this.x = newX;
    }

    public int getY() {
        return y;
    }
    public void setY(int newY) {
        this.y = newY;
    }

    public String getPunto(){
        return ("("+this.x+";"+this.y+")");
    }
}
