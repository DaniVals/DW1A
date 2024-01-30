package EjerciciosObjetos2.O00Herencia;

public class Main {
    public static void main(String[] args){
        Bicycle b1,b2;
        MountainBike m1, m2;

        b1=new Bicycle(0, 0, 0);
        m1=new MountainBike(1, 1, 1, "1");
        b2=new MountainBike(2, 2, 2,"2"); //al rever no deja y ademas es absurdo

        //si no se declara como bicicleta de montaña no se puede hacer un cast
        if (b2 instanceof MountainBike) {
            m2=(MountainBike)b2; 
            System.out.println(m2);
        }else{
            System.out.println("no m2");
        }
        if (m1 instanceof MountainBike) {
            b1=(MountainBike)m1; 
            System.out.println(b1);
        }else{
            System.out.println("no m1");
        }

    }
}
