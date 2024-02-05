package EjerciciosObjetos2.O06Abstraccion;

public class Mago extends Personaje{

    private String tipo;

    public Mago(int salud, int ataque, int defensa, String tipo) {
        super(salud, ataque, defensa);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Mago ["+super.toString()+" ,tipo:" + tipo + "]";
    }

    @Override
    public void atacar(Personaje p) {
        if (Math.random()<0.5) {
            p.dañar(p.getDefensa()-this.getAtaque()*3);
        }else{
            p.dañar(p.getDefensa()-this.getAtaque());
        }
    }

    @Override
    public void descansar() {
        if (tipo.compareTo("Wind")==0) {
            setSalud(getSalud()+10);
        }else{
            setSalud(getSalud()+5);
        }
    }
    
    @Override
    public void promocionar() {
        if (Math.random()<0.2) {
            setAtaque(getAtaque()+1);
        }
        if (Math.random()<0.3) {
            setDefensa(getDefensa()+1);
        }
    }
}
