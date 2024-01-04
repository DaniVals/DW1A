package EjerciciosObjetos.O23HundirFlota;

public class Barco {
    
    private int posX, posY, size, golpes;
    private boolean horizontal, oculto;

    
    public Barco(int size) {
        this.posX = 0;
        this.posY = 0;
        this.size = size;
        this.golpes = 0;
        this.horizontal=true;
        this.oculto=false;
    }
    
    public void ponerBarco(int x, int y){
        setPosX(x);
        setPosY(y);
    }

    public void reiniciar(){
        this.size=0;
        this.golpes=0;
    }
    public boolean golpeado(){
        if(0<this.golpes){
            return true;
        }
        return false;
    }
    public boolean derrumbado(){
        if(this.size<=this.golpes){
            return true;
        }
        return false;
    }
    public boolean estaEntre(int y, int x){
        if (horizontal) {
            if (this.posX<=x&&x<this.posX+this.size
                &&this.posY==y) {
                return true;
            }
        }else{
            if (this.posY<=y&&y<this.posY+this.size
                &&this.posX==x) {
                return true;
            }
        }
        return false;
    }
    
    public void setPosX(int posX) {
        this.posX = posX;}
    public void setSize(int size) {
        this.size = size;}
    public void setPosY(int posY) {
        this.posY = posY;}
    public void setGolpes(int golpes) {
        this.golpes = golpes;}
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;}
    public void setOculto(boolean oculto) {
        this.oculto = oculto;}

    public int getPosX() {
        return posX;}
    public int getPosY() {
        return posY;}
    public int getGolpes() {
        return golpes;}
    public int getSize() {
        return size;}
    public boolean isHorizontal() {
        return horizontal;}
    public boolean isOculto() {
        return oculto;}



    
}
