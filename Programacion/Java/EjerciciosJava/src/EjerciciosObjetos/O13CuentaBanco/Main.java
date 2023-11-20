package EjerciciosObjetos.O13CuentaBanco;

public class Main {
    public static void main(String[] args){

        Titular titular1, titular2;
        Cuenta cuenta1, cuenta2;

        titular1=new Titular("000112233J", "Juan Alberto", "Fernandez", new Fecha(15,10,2001));
        titular2=new Titular("000112233J", "Juan Alberto", "Fernandez", new Fecha(15,10,2001));
        //titular2=new Titular("000112233F", "Pepe", "San Pascual", new Fecha(9,1,1983));
        
        cuenta1=new Cuenta(1, 500, titular1);
        cuenta2=new Cuenta(2, 750, titular2);

        System.out.println(cuenta1);
        System.out.println(cuenta2);
        cuenta1.retirar(0);
        cuenta1.retirar(1000);
        cuenta2.retirar(240.57);

        System.out.println(cuenta1.compararID(cuenta2));
        System.out.println(cuenta1.compararTitular(cuenta2));
        System.out.println(cuenta1.titularSimilar(cuenta2));


    }
}
