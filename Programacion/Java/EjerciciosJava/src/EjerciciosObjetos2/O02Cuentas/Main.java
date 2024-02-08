package EjerciciosObjetos2.O02Cuentas;

//Desarrollar un programa que cree varias cuentas de distinto tipo y trabaje con ellas.

public class Main {
    public static void main(String[] args){
        Titular 
        t1=new Titular("1", "a", 10),
        t2=new Titular("2", "b", 20),
        t3=new Titular("3", "c", 30),
        t4=new Titular("4", "d", 40),
        t5=new Titular("5", "e", 50);
        Cuenta c1;
        //CuentaAhorro ca1;

        c1 = new Cuenta(t1, "cv€n1@");
        
        System.out.println(c1);
        System.out.println(""+t2+t3+t4+t5);

    }
}
