package EjerciciosObjetos.O02pokemonLand;

public class Pokemon{

    private char tipo;
    private int ataque;
    private int defensa;
    private int vida;
    private int velocidad;

    //constructor
    public Pokemon(char tipo, int ataque, int defensa, int vida, int velocidad) {
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
        this.velocidad = velocidad;
    }

    //getters
    public char getTipo() {
        return tipo;
    }
    public int getAtaque() {
        return ataque;
    }
    public int getDefensa() {
        return defensa;
    }
    public int getVida() {
        return vida;
    }
    public int getVelocidad() {
        return velocidad;
    }

    //esto hay que llamarlo
    public void mostrarStats(){
        System.out.println("Tip: "+tipo);
        System.out.println("Atk: "+ataque);
        System.out.println("Def: "+defensa);
        System.out.println("PVs: "+vida);
        System.out.println("vel: "+velocidad);
    }
    //esto se puede llamar normal, pero se llama solo al hacer print
    @Override
    public String toString() {
        return "Pokemon [tipo=" + tipo + ", ataque=" + ataque + ", defensa=" + defensa + ", vida=" + vida + ", velocidad=" + velocidad + "]";
    }
    

    public void comerBaya(){
        this.vida += 5;
        System.out.println("tu pokemon se ha comido una baya, ahora tiene "+vida+" puntos de vida");
    }

    public void dormir(){
        this.defensa += 5;
        System.out.println("tu pokemon se ha hechado una siesta, ahora tiene "+defensa+" puntos de defensa");
    }

    //al poner [NombreClase] seria como un nuevo tipo de variable ademas de int/string/bool...
    public int lucha(Pokemon pokemonCombatir){
        //this es el pokemon que empieza el combate y pokemonCombatir el recibe el primer golpe
        //ganador elije quien ha ganado la batalla
        //turno decide a que pokemon le toca atacar
        int ganador=0, turno=0, dañoTotal=0;
        if(this.velocidad>=pokemonCombatir.velocidad){
            turno=1;
        }else{
            turno=2;
        }
        while(this.vida>0&&pokemonCombatir.vida>0){//rompe el bucle cuando uno llega a 0 de vida
            if (turno==1){
                dañoTotal=(this.ataque-pokemonCombatir.defensa);
                pokemonCombatir.vida-=dañoTotal;
                System.out.println("Tu pokemon ha hecho "+dañoTotal+" de daño, dejandolo a "+pokemonCombatir.vida+" PVs");
                turno=2;
            }else{
                dañoTotal=(pokemonCombatir.ataque-this.defensa);
                this.vida-=dañoTotal;
                System.out.println("Tu pokemon ha sufrido "+dañoTotal+" de daño, quedandose a "+this.vida+" PVs");
                turno=1;
            }
        }
        //elige quien gana a traves de si el primero es el que ha llegado a 0 de vida
        if (this.vida>0){
            ganador=1;
        }else{
            ganador=2;
        }
        return ganador; //devuelve el valor "ganador"
    }
}