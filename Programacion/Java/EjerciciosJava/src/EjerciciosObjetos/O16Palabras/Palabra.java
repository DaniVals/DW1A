package EjerciciosObjetos.O16Palabras;

public class Palabra {
    public static int contarPalabras(String texto, String separadores){
        int numeroPalabras=0;
        String textoAsist=new String(" "+texto+" ");

        for(int i=0; i<textoAsist.length()-1; i++){
            for(int j=0; j<separadores.length(); j++){
                if (textoAsist.charAt(i)==separadores.charAt(j)&&esLetra(textoAsist.charAt(i+1), true, true, false)) {
                    numeroPalabras++;
                }
            }
        }

        return numeroPalabras;
    }
    public static boolean esLetra(char car, boolean mayus, boolean minus, boolean num){
        if ('A'<=car&&car<='Z'&&mayus||
        'a'<=car&&car<='z'&&minus||
        '0'<=car&&car<='9'&&num){
            return true;
        }
        return false;
    }
    public static boolean buscarPalabraExacta(String texto, String palabra){
        String textoAsist=new String(" "+texto+" ");
        String textoComparar="";

        for(int i=0;i<textoAsist.length()-1;i++){
            if (textoAsist.charAt(i)==' '&&esLetra(textoAsist.charAt(i+1), true, true, false)) {
                if (textoComparar.compareTo(palabra)==0) {
                    return true;
                }
                textoComparar="";
            }else{
                textoComparar+=textoAsist.charAt(i);
            }
        }
        if (textoComparar.compareTo(palabra)==0) {//comprobar con la ultima palabra
            return true;
        }
        return false;
    }
    public static String buscarTextoTipo(String texto, String palabra){
        String textoAsist=new String(" "+texto+" ");
        String textoComparar="";

        for(int i=0;i<textoAsist.length()-1;i++){
            if (textoAsist.charAt(i)==' '&&esLetra(textoAsist.charAt(i+1), true, true, false)) {
                if (textoComparar.compareTo(palabra)==0) {
                    return "palabra";
                }
                textoComparar="";
            }else{
                textoComparar+=textoAsist.charAt(i);
            }
        }
        if (textoComparar.compareTo(palabra)==0) {//comprobar con la ultima palabra
            return "palabra";
        }

        if (texto.indexOf(palabra)>=0) {
            return "cadena";
        }

        return "no";
    }
    public static String printCoincidenciasTexto(String texto, String palabra){
        
        return "hay "+numeroPalabras(texto, palabra)+" palabras y "+
        (numeroCadenas(texto, palabra)-numeroPalabras(texto, palabra))+" cadenas";
    }
    public static int numeroCadenas(String texto, String palabra){
        String textoComparar2="";
        int cont=0;
        if (palabra=="") {
            return cont;
        }
        for(int i=texto.length()-1;i>=0;i--){
            textoComparar2=texto.charAt(i)+textoComparar2;
            if (textoComparar2.indexOf(palabra)==0) {
                cont++;
            }
        }
        return cont;
    }
    public static int numeroPalabras(String texto, String palabra){
        String textoAsist=new String(" "+texto+" ");
        String textoComparar="";
        int cont=0;

        if (palabra=="") {
            return cont;
        }
        //palabra exacta
        for(int i=0;i<textoAsist.length()-1;i++){
            if (textoAsist.charAt(i)==' '&&esLetra(textoAsist.charAt(i+1), true, true, false)) {
                if (textoComparar.compareTo(palabra)==0) {
                    cont++;
                }
                textoComparar="";
            }else{
                textoComparar+=textoAsist.charAt(i);
            }
        }
        //comprobar con la ultima palabra
        if (textoComparar.compareTo(palabra)==0) {
            cont++;
        }
        return cont;
    }
}
