package EjerciciosObjetos2.O06Abstraccion;

public class Arquero extends Personaje{
    private int nFlechas;

    public Arquero(int salud, int ataque, int defensa, int nFlechas) {
        super(salud, ataque, defensa);
        this.nFlechas = nFlechas;
    }

    public int getnFlechas() {
        return nFlechas;
    }

    public void setnFlechas(int nFlechas) {
        this.nFlechas = nFlechas;
    }

    @Override
    public String toString() {
        return "Arquero ["+super.toString()+" ,nFlechas:" + nFlechas + "]";
    }

    @Override
    public void atacar(Personaje p) {
        p.dañar(p.getDefensa()-(this.getAtaque()+nFlechas));
    }

    @Override
    public void descansar() {
        if (Math.random()<0.8) {
            setSalud(getSalud()+5);
        }
    }
    
    @Override
    public void promocionar() {
        setAtaque(getAtaque()+2);
        setDefensa(getDefensa()+1);
        nFlechas+=3;
    }
}
