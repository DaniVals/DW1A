package EjerciciosObjetos2.O06Abstraccion;

public class Paladin extends Personaje{
    
    private boolean bendecido;

    public Paladin(int salud, int ataque, int defensa, boolean bendecido) {
        super(salud, ataque, defensa);
        this.bendecido = bendecido;
    }

    public boolean isBendecido() {
        return bendecido;
    }

    public void setBendecido(boolean bendecido) {
        this.bendecido = bendecido;
    }

    @Override
    public String toString() {
        return "Paladin ["+super.toString()+", bendecido:" + bendecido + "]";
    }

    @Override
    public void atacar(Personaje p) {
        if (bendecido) {
            p.dañar(p.getDefensa()-this.getAtaque()*2);
        }else{
            p.dañar(p.getDefensa()-this.getAtaque()*1);
        }
    }

    @Override
    public void descansar() {
        if (bendecido) {
            setSalud(getSalud()+5);
        }else{
            setSalud(getSalud()+1);
        }
    }
    
    @Override
    public void promocionar() {
        if (bendecido) {
            setAtaque(getAtaque()+10);
            setDefensa(getDefensa()+10);
        }else{
            setAtaque(getAtaque()+2);
            setDefensa(getDefensa()+2);
        }
    }    
}
