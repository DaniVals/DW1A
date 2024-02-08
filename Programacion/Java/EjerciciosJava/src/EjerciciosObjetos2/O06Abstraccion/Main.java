package EjerciciosObjetos2.O06Abstraccion;

public class Main {
    public static void main(String[] args){
        
        Personaje p = new Paladin(0, 0, 0, false);
        p.descansar();
        p = new Mago(0, 0, 0, null);
        p.descansar();
        System.out.println(p.toString());
    }
}
