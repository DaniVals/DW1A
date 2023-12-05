package FuncionesCopias.LeerCrearArchivos;


public class Main {
    public static void main(String[] args){
        Archivo archivo1 = new Archivo(System.getProperty("user.dir")+"\\Programacion\\Java\\EjerciciosJava\\src\\FuncionesCopias\\LeerCrearArchivos\\","file.txt");
        /*
        
        archivo1.añadirLinea("\nlinea");
        System.out.println(archivo1.buscar(2,"dinero")+"hola");
        
        System.out.println(archivo1.buscar(1, "nombre"));
        archivo1.remplazar(1,"dinero","150");
        
        archivo1.añadirLinea("null");
        System.out.println(archivo1);
        
        
        archivo1.formatear();        
        archivo1.añadirPersonaje("tierra");
        archivo1.añadirPersonaje("normal");
        archivo1.añadirPersonaje("aaaaaaaaaaaaaaa");
        
        */
        archivo1.cambiarConfig("numJugadores", "6");

        System.out.println( archivo1.detectarConfig("numJugadores"));
        System.out.println( archivo1.buscar(1, "lvl"));
    }
}
