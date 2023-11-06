package EjerciciosObjetos.O11Pokimon;

public class Pokimon {

    private int ataque,velocidad,vida,vidaMax, id;
	private boolean capturado;
	
	//-----Constructores-----
	public Pokimon () {
		this.capturado = false;
	}
	public Pokimon (int ataque, int vidaMax , int velocidad, int id) {
		
		this.ataque = ataque;
		this.velocidad = velocidad;
		this.vidaMax = vidaMax;
		this.vida = vidaMax;
		this.id = id;
		this.capturado = false;
	}
	//-----Getters y setters-----
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque (int ataque) {
		this.ataque = ataque;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad (int velocidad) {
		this.velocidad = velocidad;
	}
	public int getVida() {
		return vida;
	}
	public void setVida (int vida) {
		this.vida = vida;
	}
	public int getVidaMax() {
		return vidaMax;
	}
	public void setVidaMax(int vidaMax) {
		this.vidaMax = vidaMax;
	}
	public int getId() {
		return id;
	}
	public void setId (int id) {
		this.id = id;
	}
	public boolean isCapturado() {
		return capturado;
	}
	public void setCapturado (boolean capturado) {
		this.capturado = capturado;
	}
	//-----ToString-----
	@Override
	public String toString() {
		
		return "atk= " + ataque + "\nvel= " + velocidad + "\nPV= " + vida+" / "+vidaMax + "\nid= " + id;
	}

	//-----Metodos-----
	public int lucha (Pokimon pokemonCombatir) {
        //this es el pokemon que empieza el combate y pokemonCombatir el recibe el primer golpe
        //ganador elije quien ha ganado la batalla
        //turno decide a que pokemon le toca atacar
        
		int ganador=0, turno=0, dañoTotal=0;
        
        if (this.velocidad>=pokemonCombatir.velocidad) {
            turno=1;
        }
        else{
            turno=2;
        }
        while (this.vida>0&&pokemonCombatir.vida>0) {//rompe el bucle cuando uno llega a 0 de vida
        	if (turno==1) {
                dañoTotal=this.ataque;
                pokemonCombatir.vida -= dañoTotal;
                
                System.out.println ("Tu pokemon ha hecho " + dañoTotal + " de daño, dejandolo a " + pokemonCombatir.vida + " PVs");
                turno=2;
            }
        	else {
                dañoTotal=pokemonCombatir.ataque;
                this.vida -= dañoTotal;
                
                System.out.println ("Tu pokemon ha sufrido " + dañoTotal + " de daño, quedandose a " + this.vida + " PVs");
                turno=1;
            }
        }
        //elige quien gana a traves de si el primero es el que ha llegado a 0 de vida
        if (this.vida>0) {
            ganador=1;
        }
        else {
            ganador=2;
        }
        return ganador; //devuelve el valor "ganador"
    }
	public void curar(){
		this.vida=this.vidaMax;
	}
}
