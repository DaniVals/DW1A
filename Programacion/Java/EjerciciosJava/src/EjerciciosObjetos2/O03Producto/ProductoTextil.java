package EjerciciosObjetos2.O03Producto;

public class ProductoTextil extends Producto
{
    private String material;

    public ProductoTextil(String nombre, int codigo, int precio, int existencias, String material) {
        super(nombre, codigo, precio, existencias);
        this.material = material;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    @Override
    public String toString() {
        return "Producto [nombre=" + getNombre() + ", codigo=" + getCodigo() + ", precio=" + getPrecio() + ", existencias="
                + getExistencias()  + ", material="+material;
    }
    

    public String alergia(){
        return "alergico a "+material;
    }
}
