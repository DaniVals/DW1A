package FuncionesCopias.SimulacroExamen01;

public abstract class Fruta {
    private double peso;
    private int cantidad;
    public abstract double getPrecio();
    
    public Fruta(double peso, int cantidad) {
        this.peso = peso;
        this.cantidad = cantidad;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
