package Examen2.Ej2;

public class Investigacion extends Robot{
    private int horas;

    public Investigacion(String id, String modelo, int nPiezas,int horas) {
        super(id, modelo, nPiezas);
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Investigacion ["+super.toString()+", horas:" + horas + "]";
    }

    
}
