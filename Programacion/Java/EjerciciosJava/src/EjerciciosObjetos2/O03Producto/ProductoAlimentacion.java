package EjerciciosObjetos2.O03Producto;

public class ProductoAlimentacion extends Producto
{
    private int valorNutricional;

    public ProductoAlimentacion(String nombre, int codigo, int precio, int existencias, int valorNutricional) {
        super(nombre, codigo, precio, existencias);
        this.valorNutricional = valorNutricional;
    }
    public int getValorNutricional() {
        return valorNutricional;
    }
    public void setValorNutricional(int valorNutricional) {
        this.valorNutricional = valorNutricional;
    }
    @Override
    public String toString() {
        return "Producto [nombre=" + getNombre() + ", codigo=" + getCodigo() + ", precio=" + getPrecio() + ", existencias="
                + getExistencias() + ", valor nutricional="+valorNutricional;
    }
    public String categoria(){
        if (90<valorNutricional) {
            return "A";
        }
        if (80<valorNutricional) {
            return "B";
        }
        if (70<valorNutricional) {
            return "C";
        }
        if (60<valorNutricional) {
            return "D";
        }
        if (50<valorNutricional) {
            return "E";
        }
        return "F";
    }
}
