package EjerciciosObjetos.O20Arrays;

public class CifradoCesar {
    public static void main(String[] args) {

        System.out.println(cifrar("abcdefghijklmnñopqrstuvwxyz", 5));
        System.out.println(descifrar("abcdefghijklmnñopqrstuvwxyz", 5));
    }
    public static String cifrar(String texto, int cantidad){
        char[] array={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z',
                    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
        String textoAssist="";
        for(int i=0; i<texto.length();i++){
            for(int j=0; j<array.length; j++){
                if (texto.charAt(i)==array[j]) {
                    textoAssist+=array[(j+cantidad)%27];
                    break;
                }
            }
        }
        return textoAssist;
    }
    public static String descifrar(String texto, int cantidad){
        char[] array={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z',
                    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
        String textoAssist="";
        for(int i=0; i<texto.length();i++){
            for(int j=27; j<array.length; j++){
                if (texto.charAt(i)==array[j]) {
                    textoAssist+=array[(j-cantidad)%27];
                    break;
                }
            }
        }
        return textoAssist;

        
        
    }
}
