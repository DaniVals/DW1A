package EjerciciosObjetos.O14FrabicanteProducto;

public class Producto {
    private String codigo;
    private String marca;
    private String modelo;
    private double precio;
    private Fabricante fabricante;
    
    public Producto(String codigo, String marca, String modelo, double precio, Fabricante fabricante) {
        this.codigo = validarCodigo(codigo);
        this.marca = eliminarCaracteresEspeciales(marca);
        this.modelo = eliminarCaracteresEspeciales(modelo);
        this.precio = precio;
        this.fabricante = fabricante;
    }

    public String getCodigo() {
        return codigo;}
    public String getMarca() {
        return marca;}
    public String getModelo() {
        return modelo;}
    public double getPrecio() {
        return precio;}
    public Fabricante getFabricante() {
        return fabricante;}

    public void setCodigo(String codigo) {
        this.codigo = codigo;}
    public void setMarca(String marca) {
        this.marca = marca;}
    public void setModelo(String modelo) {
        this.modelo = modelo;}
    public void setPrecio(double precio) {
        this.precio = precio;}
    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;}

    @Override
    public String toString() {
        return "Producto "+codigo+"\n   marca="+marca+"\n   modelo="+modelo+ 
        "\n   precio="+precio+"\n   "+fabricante;
    }

    public String validarCodigo(String texto){
        if ('A'<=texto.charAt(0)&&texto.charAt(0)<='Z'&&
            '0'<=texto.charAt(1)&&texto.charAt(1)<='9'&&
            '0'<=texto.charAt(2)&&texto.charAt(2)<='9'&&
            '0'<=texto.charAt(3)&&texto.charAt(3)<='9'&&
            'a'<=texto.charAt(4)&&texto.charAt(4)<='z'){
                
            return texto;
        }
        return "A000a";
    }
    public String eliminarCaracteresEspeciales(String texto){
        String textoAsist="";
        for (int i=0; i<texto.length();i++){
            if ('A'<=texto.charAt(i)&&texto.charAt(i)<='Z'||
                'a'<=texto.charAt(i)&&texto.charAt(i)<='z'||
                '0'<=texto.charAt(i)&&texto.charAt(i)<='9'){
                    textoAsist+=texto.charAt(i);
            }
        }
        return textoAsist;
    }
    
}
