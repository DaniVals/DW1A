package FuncionesCopias.SimulacroExamen01;

public class Manzana extends Fruta {
    public enum COLOR{
        ROJO,
        AMARILLO,
        VERDE
    }
    private COLOR color;

    

    public Manzana(double peso, int cantidad, COLOR color) {
        super(peso, cantidad);
        this.color = color;
    }



    @Override
    public double getPrecio() {
        return 2.5;
    }



    public COLOR getColor() {
        return color;
    }



    public void setColor(COLOR color) {
        this.color = color;
    }
}
