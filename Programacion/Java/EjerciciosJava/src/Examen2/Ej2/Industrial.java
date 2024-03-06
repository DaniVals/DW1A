package Examen2.Ej2;

public class Industrial extends Robot{
    private String fabricante;

    public Industrial(String id, String modelo, int nPiezas,String fabricante) {
        super(id, modelo, nPiezas);
        this.fabricante = fabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Industrial ["+super.toString()+", fabricante:" + fabricante + "]";
    }

    
}
