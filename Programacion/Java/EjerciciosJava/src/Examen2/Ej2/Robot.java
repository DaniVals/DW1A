package Examen2.Ej2;

public abstract class Robot {
    private String id,modelo;
    private int nPiezas;

    public Robot(String id, String modelo, int nPiezas) {
        this.id = id;
        this.modelo = modelo;
        this.nPiezas = nPiezas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getnPiezas() {
        return nPiezas;
    }

    public void setnPiezas(int nPiezas) {
        this.nPiezas = nPiezas;
    }

    @Override
    public String toString() {
        return "Robot [id:" + id + ", modelo:" + modelo + ", nPiezas:" + nPiezas + "]";
    }
    
}
