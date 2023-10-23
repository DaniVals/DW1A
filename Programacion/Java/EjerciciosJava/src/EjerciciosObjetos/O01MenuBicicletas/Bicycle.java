package EjerciciosObjetos.O01MenuBicicletas;

public class Bicycle {

	//variables que usa el objeto, llamadas de forma individual atributos
    //public se puede editar desde cualquier clase a traves de [nombreObjeto].variable
    //private SOLO se puede cambiar usando metodos
    public int cadence;
    public int gear;
    public int speed;
        
    //constructor: establece el objeto
    //lo de dentro del parentesis se llama atributo
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }
        
    // Metodos: sirve para cambiar un objeto aunque este privado
    //lo de dentro del parentesis se llama argumento
    public void setCadence(int newValue) {
        cadence = newValue;
    }
        
    public void setGear(int newValue) {
        gear = newValue;
    }
        
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
        
    public void speedUp(int increment) {
        speed += increment;
    }

    //Procedimientos: Metodos que devuelven algo (realmente todos devuelven VOID)
    public int showSpeed(){
        return speed;
    }
    public int showGear(){
        return gear;
    }
    public int showCadence(){
        return cadence;
    }
    //Tecnicamente los metodos son procedimientos y los procedimientos son funciones, pero java es asi
}