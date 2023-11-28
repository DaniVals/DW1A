package FuncionesCopias.LeerCrearArchivos;


public class Main {
    public static void main(String[] args){
        Archivo archivo1 = new Archivo(System.getProperty("user.dir")+"\\Programacion\\Java\\EjerciciosJava\\src\\FuncionesCopias\\LeerCrearArchivos\\","file.txt");
        
        //archivo1.añadirLinea("\nlinea");
        //System.out.println(archivo1.buscar(2,"dinero")+"hola");


        System.out.println(archivo1.buscar(11, "dinero"));
        archivo1.remplazar(2,"dinero","10");
        //System.out.println(archivo1);
    }
}
