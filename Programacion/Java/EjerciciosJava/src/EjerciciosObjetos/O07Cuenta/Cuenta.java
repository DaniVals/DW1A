package EjerciciosObjetos.O07Cuenta;

public class Cuenta {
    
    private int id;
    private double cantidad;

    public Cuenta(int id, double cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;}
    public void setId(int id) {
        this.id = id;}
    public double getCantidad() {
        return cantidad;}

    @Override
    public String toString() {
        return "Cuenta [id=" + id + 
        ", cantidad=" + cantidad + "]";
    }

    
    public void ingresar(double cantidad) {
        if (cantidad<=0) {
            System.out.println("por favor, introduce un numero valido");}
        else{
            this.cantidad += cantidad;}
    }
    public void retirar(double cantidad) {
        if (cantidad<=0) {
            System.out.println("por favor, introduce un numero valido");}
        else{
            this.cantidad -= cantidad;}
    }
}
