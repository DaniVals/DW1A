package EjerciciosObjetos2.O02Cuentas;


/*
Desarrollar una clase llamada CuentaAhorro que:
• Es una especialización de CuentaCorriente.
• Tiene un atributo mas de tipo double (el interés).
• Tiene un constructor con parámetros de tipo Titular, String, double y double.
• Tiene un constructor con parámetros de tipo Titular, String, double. El saldo se 
inicializará a 15,3.
• Tiene un constructor con parámetros de tipo Titular, String. El saldo se 
inicializará a 15,3 y el interés a 2,5.
• Tenga un getter para cada uno de los atributos.
• Tiene un método calcularInteres que incremente el saldo según el interés. 
Desarrollar un programa que cree varias cuentas de distinto tipo y trabaje con ellas.
*/

public class CuentaAhorro extends Cuenta {
    
    private double interes;

    public CuentaAhorro(Titular titular, String numCuenta, double saldo, double interes) {
        super(titular, numCuenta, saldo);
        this.interes = interes;
    }

    public CuentaAhorro(Titular titular, String numCuenta, double interes) {
        super(titular, numCuenta);
        this.interes = interes;
    }
    public CuentaAhorro(Titular titular, String numCuenta) {
        super(titular, numCuenta);
        this.interes = 2.5;
    }

    public double getInteres() {
        return interes;
    }
    public double calcularInteres(){
        return interes*(1+this.getSaldo()/100);
    }
}
