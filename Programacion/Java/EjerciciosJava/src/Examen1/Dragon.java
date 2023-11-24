package Examen1;

public class Dragon {
    private String color;
    private String ciudad;
    private int fuerza;
    // constructor
    public Dragon(String color, String ciudad, int fuerza) {
        //comprobar si el valor es rojo o negro, ignorando las mayusculas
        //no hace falta comparar el verde ya qye es la opcion por defecto
        color=color.toLowerCase();
        if (color.compareTo("rojo")==0||
            color.compareTo("negro")==0) {
            this.color = color;
        }else{
            this.color = "verde";
        }
        //evitar valores null
        if (ciudad==null) {
            this.ciudad = "";
        }else{
            this.ciudad = ciudad;
        }
        //evitar valores negativos
        if (fuerza<0) {
            this.fuerza = 0;
        }else{
            this.fuerza = fuerza;
        }
    }
    // getters
    public String getColor() {
        return color;
    }
    public String getCiudad() {
        return ciudad;
    }
    public int getFuerza() {
        return fuerza;
    }
    // setters
    public void setColor(String color) {
        this.color = color;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    //metodos
    public void promocionar(){
        //pasar de rojo a negro y sumarle 5 de fuerza
        if (this.color.compareTo("rojo")==0) {
            this.color="negro";
            this.fuerza+=5;
        }
        //pasar de verde a rojo
        if (this.color.compareTo("verde")==0) {
            this.color="rojo";
        }
    }
}