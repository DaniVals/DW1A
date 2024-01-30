package EjerciciosObjetos2.O03Producto;

public class ProductoElectronico extends Producto
{
    private double gastoWH;

    public ProductoElectronico(String nombre, int codigo, int precio, int existencias, double gastoWH) {
        super(nombre, codigo, precio, existencias);
        this.gastoWH = gastoWH;
    }
    public double getGastoWH() {
        return gastoWH;
    }
    public void setGastoWH(double gastoWH) {
        this.gastoWH = gastoWH;
    }
    @Override
    public String toString() {
        return "Producto [nombre=" + getNombre() + ", codigo=" + getCodigo() + ", precio=" + getPrecio() + ", existencias="
                + getExistencias()  + ", gasto W/H="+gastoWH;
    }
    public double calcularGasto(int segundos){
        return gastoWH*segundos*3600;
    }
}
