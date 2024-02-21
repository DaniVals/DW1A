package EjerciciosObjetos2.O10MagoPaladinArqueroInterfaz;

public abstract class Personaje implements InterfazTropa {

    private int vida,vidaMax,ataque;
    
    public Personaje(int vida, int vidaMax, int ataque) {
        this.vida = vida;
        this.vidaMax = vidaMax;
        this.ataque = ataque;
    }

    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getVidaMax() {
        return vidaMax;
    }
    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }    

    public void cambiarVida(int vida){
        this.vida += vida;
        if (vidaMax<vida) {
            vida=vidaMax;
        }
        if (vida<0) {
            vida=0;
        }
    }

    public boolean estaMuerto(){
        if (vida<=0) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "HP:" + vida + "/" + vidaMax + ",  ATK:" + ataque;
    }


    @Override
    public abstract void descansar();
    @Override
    public abstract void atacar(InterfazTropa i);
    
    public abstract void promocionar();
}
