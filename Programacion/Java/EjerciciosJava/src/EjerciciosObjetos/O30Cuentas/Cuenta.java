package EjerciciosObjetos.O30Cuentas;

/*
Desarrollar una clase llamada CuentaCorriente que:
• Tenga tres atributos private de tipo Titular (Nombre – String, Apellidos – String 
y Edad - int), de tipo String (el número de cuenta) y de tipo double (el saldo).

• Tenga un constructor con parámetros de tipo Titular, String y double.
• Tenga un constructor con parámetros de tipo Titular y String. El saldo se 
inicializará a 15,3. 
• Tenga un getter para cada uno de los atributos.
• Tenga un setter solo para el saldo.
• Tenga un método ingresar que incremente el saldo en una cantidad.
• Tenga un método reintegro que decremente el saldo en una cantidad.
• Tenga un método para que al imprimir la cuenta salga por pantalla el número de 
cuenta y su saldo.
• Tenga un método para comparar cuentas, sabiendo que dos cuentas serán iguales 
si sus números de cuenta son iguales.
• Nota 1: Al imprimir por pantalla un Titular saldrá su nombre, apellidos y edad.
• Nota 2: Para comparar dos String utilizar su método compareTo(String) que 
devuelve 0 si son iguales.  
 */

public class Cuenta {

    private Titular titular;
    private String numCuenta;
    private double saldo;
    
    public Cuenta(Titular titular, String numCuenta, double saldo) {
        this.titular = titular;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }
    public Cuenta(Titular titular, String numCuenta) {
        this.titular = titular;
        this.numCuenta = numCuenta;
        this.saldo = 15.3;
    }
    public Titular getTitular() {
        return titular;
    }
    public String getNumCuenta() {
        return numCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public boolean compararCuenta(Cuenta c2){
        if (this.numCuenta.compareTo(c2.getNumCuenta())==0) {
            return true;
        }
        return false;
    }
    public void ingresar(double saldo) {
        if (0<saldo) {
            this.saldo += saldo;
        }
    }
    public void retirar(double saldo) {
        if (0<saldo||this.saldo<saldo) {
            this.saldo -= saldo;
        }
    }
    public void imprimir(){
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Cuenta\n  titular:" + titular + "\n  numCuenta:" + numCuenta + "\n  saldo:" + saldo;
    }
    
}
