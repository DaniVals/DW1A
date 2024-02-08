package EjerciciosObjetos2.O04Formas;

public class Rectangulo extends Forma {
    private int lMayor,lMenor;

    public Rectangulo(String colorHex, Punto centro, int lMayor, int lMenor) {
        super(colorHex, centro);
        this.lMayor = lMayor;
        this.lMenor = lMenor;
    }

    public int getlMayor() {
        return lMayor;
    }

    public void setlMayor(int lMayor) {
        this.lMayor = lMayor;
    }

    public int getlMenor() {
        return lMenor;
    }

    public void setlMenor(int lMenor) {
        this.lMenor = lMenor;
    }
    public int calcArea(){
        return lMayor*lMenor;
    }
    public int calcPerimetro(){
        return 2 * lMayor + 2 * lMenor;
    }
    public void cambiarTamaño(double escala){
        lMayor=(int)(lMayor*escala);
        lMenor=(int)(lMenor*escala);
    }

    
}