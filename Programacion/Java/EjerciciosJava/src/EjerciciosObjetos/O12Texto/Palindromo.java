package EjerciciosObjetos.O12Texto;

public class Palindromo {

    private String texto;

    public Palindromo(String texto) {
        this.texto = texto;
    }
    public boolean esPalindromo() {
        String textoAsist="";
        String textoAsist2="";

        for (int i=texto.length()-1; i>-1;i--){
            if(64<=texto.charAt(i)&&texto.charAt(i)<=90 || 97<=texto.charAt(i)&&texto.charAt(i)<=122){
                textoAsist+=texto.charAt(i);}
        }
        for (int i=textoAsist.length()-1; i>-1;i--){
            textoAsist2+=textoAsist.charAt(i);
        }
        System.out.println(texto);
        System.out.println(textoAsist);
        System.out.println(textoAsist2);
        if (textoAsist.compareTo(textoAsist2)==0) {
            return true;
        }
        return false;
    }

    
}
