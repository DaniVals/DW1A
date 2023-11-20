package EjerciciosObjetos.O13CuentaBanco;

public class Cuenta {
    
    private int id;
    private double saldo;
    private Titular titular;

    public Cuenta(int id, double saldo, Titular titular) {
        this.id = id;
        this.saldo = saldo;
        this.titular = titular;
    }
    public int getId() {
        return id;}
    public double getSaldo() {
        return saldo;}
    public Titular getTitular() {
        return titular;}

    public void setId(int id) {
        this.id = id;}
    public void setSaldo(double saldo) {
        this.saldo = saldo;}
    public void setTitular(Titular titular) {
        this.titular = titular;}
    @Override
    public String toString() {
        return "Cuenta " + id + 
        "\n   saldo=" + saldo + "\n   titular=" + titular;
    }
    
    public void mostrar(){
        System.out.println(this.toString());
    }

    public void retirar(double cantidad){
        if (cantidad<=0) {
            System.out.println("Numero no valido");
        }else{
            if (saldo<cantidad) {
                System.out.println("No dispone de dicho dinero");
            }else{
                this.saldo-=cantidad;
                System.out.println("Dinero restante:"+this.saldo);
            }
        }
    }
    public void ingresar(double cantidad){
        if (cantidad<=0) {
            System.out.println("Numero no valido");
        }else{
            this.saldo-=cantidad;
            System.out.println("Dinero restante:"+this.saldo);
        }
    }
    public boolean compararID(Cuenta cuentaComparar){
        if (this.id==cuentaComparar.id) {
            return true;
        }
        return false;
    }
    public boolean compararTitular(Cuenta cuentaComparar){
        if (this.titular.compararTitular(cuentaComparar.titular)) {
            return true;
        }
        return false;
    }
    public boolean titularSimilar(Cuenta cuentaComparar){
        if (this.titular.titularSimilar(cuentaComparar.titular)) {
            return true;
        }
        return false;
    }
}
