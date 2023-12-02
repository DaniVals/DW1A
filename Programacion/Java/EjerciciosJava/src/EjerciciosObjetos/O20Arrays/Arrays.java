package EjerciciosObjetos.O20Arrays;

public class Arrays {
    public static void mostrarArrayString(String[] arrayAnalizar){
        for (String txt : arrayAnalizar) {
            System.out.println(txt);
        }
    }
    public static String stringMasLargo(String[] arrayAnalizar){
        String devolver= arrayAnalizar[0];
    for (String txt : arrayAnalizar) {
        if (devolver.length()<txt.length()) {
            devolver=txt;
        }
    }
        return devolver;
    }
    public static boolean stringOrdenadoAlfabeticamente(char[] arrayAnalizar){
        int caracterMasAlto=-1;
        String abecedario="abcdefghijklmnñopqrstuvwxyz";
        for (char txt : arrayAnalizar) {
            if (caracterMasAlto<=abecedario.indexOf(txt)) {
                caracterMasAlto=abecedario.indexOf(txt);
            }else if (caracterMasAlto<=abecedario.toUpperCase().indexOf(txt)) {
                caracterMasAlto=abecedario.toUpperCase().indexOf(txt);
            }else{
                return false;
            }
        }
        return true;
    }
    public static int numeroPalindromos(String[] arrayAnalizar){
        int devolver=0;
        String textoAsist;
    for (String txt : arrayAnalizar) {
        textoAsist= "";
        for (int i=txt.length()-1; i>-1;i--){
            textoAsist+=txt.charAt(i);
        }
        if (textoAsist.compareTo(txt)==0) {
            devolver++;
        }
    }
        return devolver;
    }
    public static String[] invertirArray(String[] arrayAnalizar){
        String[] devolver=new String[arrayAnalizar.length];
        for (int i=0; i<arrayAnalizar.length;i++){
            devolver[i]=arrayAnalizar[arrayAnalizar.length-i-1];
        }
        return devolver;
    }
    public static String valorAleatorio(String[] arrayAnalizar){
        return arrayAnalizar[Mates.randomInt(0, arrayAnalizar.length-1)];
    }
    public static void main(String[] args) {

        String[] array1={"hola","ccc","mi mami","gh"};
        System.out.println(stringMasLargo(array1));

        char[] array2={'a','c','E','d'};
        System.out.println(stringOrdenadoAlfabeticamente(array2));

        String[] array3={"hola","ccc","mi mami","g * g"};
        System.out.println(numeroPalindromos(array3));

        String[] array4={"num1","2","mi mami","numero 4"};
        mostrarArrayString(invertirArray(array4));
        
        String[] array5={"num1","2","mi mami3","numero 4"};
        System.out.println(valorAleatorio(array5));

    }
}

    