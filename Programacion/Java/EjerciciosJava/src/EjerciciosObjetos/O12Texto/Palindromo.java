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
            if( texto.charAt(i)=='0'||texto.charAt(i)=='1'||texto.charAt(i)=='2'||texto.charAt(i)=='3'||texto.charAt(i)=='4'||
                texto.charAt(i)=='5'||texto.charAt(i)=='6'||texto.charAt(i)=='7'||texto.charAt(i)=='8'||texto.charAt(i)=='9'){}
            else{
                textoAsist+=texto.charAt(i);}
        }
        for (int i=textoAsist.length()-1; i>-1;i--){
            textoAsist2+=textoAsist.charAt(i);
        }
        System.out.println(texto);
        System.out.println(textoAsist);
        System.out.println(textoAsist2);
        if (textoAsist.toString()==textoAsist2.toString()) {
            return true;
        }
        return false;
    }

    
}
