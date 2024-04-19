package FuncionesCopias.SimulacroExamen01;

public class Platano extends Fruta {
    private String origen;

    

    public Platano(double peso, int cantidad, String origen) {
        super(peso, cantidad);
        this.origen = origen;
    }



    @Override
    public double getPrecio() {
        return 1.5;
    }



    public String getOrigen() {
        return origen;
    }



    public void setOrigen(String origen) {
        this.origen = origen;
    }


}
