package Examen1;

public class Prueba {
    public static void main(String[] args){
        
        Mago mago1=new Mago("hhhhe", 3, true);
        Dragon dragon1=new Dragon("rojo", "España", 3);
        
        System.out.println(mago1.combateDragon(dragon1));

        System.out.println(mago1.getPoder());
        mago1.promocionar();
        System.out.println(mago1.getPoder());

        System.out.println(dragon1.getColor());
        System.out.println(dragon1.getFuerza());
        dragon1.promocionar();
        System.out.println(dragon1.getColor());
        System.out.println(dragon1.getFuerza());

    }
}