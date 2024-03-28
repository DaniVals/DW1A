package src.F14Impresoras;

import java.io.Serializable;

public class Impresora implements Serializable {
    
    private int numSerie;
    private String modelo, marca;
    private Tipo tipo;

    public enum Tipo
    {
        TINTA,
        LASER
    }

    public Impresora(int numSerie, String modelo, String marca, Tipo tipo) {
        this.numSerie = numSerie;
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Impresora [numSerie=" + numSerie + ", modelo=" + modelo + ", marca=" + marca + ", tipo=" + tipo + "]";
    }

    
}
