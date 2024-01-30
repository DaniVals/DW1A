package EjerciciosObjetos2.O03Producto;
/*os atributos serán: nombre, código, precio, existencias. Los métodos de la clase serán: 
 
 a. Constructor (inicializará las variables de la clase) 
 b. modificarPrecio (se le pasará como argumento el nuevo precio) 
 c. modificarExistencias   (se   le   pasará   como   argumento   las   nuevas  
 existencias) 
 d. mostrarDatos (mostrará todos los datos del producto) 
  */
public class Producto {
    
    private String nombre;
    private int codigo, precio, existencias;
    public Producto(String nombre, int codigo, int precio, int existencias) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.existencias = existencias;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCodigo() {
        return codigo;
    }
    public int getPrecio() {
        return precio;
    }
    public int getExistencias() {
        return existencias;
    }
    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", precio=" + precio + ", existencias="
                + existencias + "]";
    }
    
}
