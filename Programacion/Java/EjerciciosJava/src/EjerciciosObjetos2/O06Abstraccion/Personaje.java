package EjerciciosObjetos2.O06Abstraccion;

public abstract class Personaje {
    
    private int salud,ataque,defensa;

    public Personaje(int salud, int ataque, int defensa) {
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public String toString() {
        return "salud:" + salud + ", ataque:" + ataque + ", defensa:" + defensa;
    }

    public void dañar(int daño){
        if (0<daño) {
            salud-=daño;
        }
    }
    public abstract void atacar(Personaje p);
    public abstract void descansar();
    public abstract void promocionar();
    
}
