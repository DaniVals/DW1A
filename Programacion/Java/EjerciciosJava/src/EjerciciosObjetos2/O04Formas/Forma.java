package EjerciciosObjetos2.O04Formas;

public class Forma {
    private String colorHex;
    private Punto centro;
    
    public Forma(String colorHex, Punto centro) {
        this.colorHex = colorHex;
        this.centro = centro;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    @Override
    public String toString() {
        String returned="Forma [colorHex:" + colorHex + ", centro: [" + centro.getX()+","+centro.getY()+"]";
        if (this instanceof Rectangulo) {
            Rectangulo r = (Rectangulo)this;
            returned+=", lMayor:" + r.getlMayor() + ", lMenor:" + r.getlMenor();
        }
        return returned+"]";
    }
    

}
