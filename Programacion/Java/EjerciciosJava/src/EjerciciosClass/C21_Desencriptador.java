package EjerciciosClass;

public class C21_Desencriptador {
	public static void main(String[] args) {
        String encriptado="85 72 86 48 98 121 66 87 89 87 120 122";
        String assist="";
        String desencriptado="";
        
        for (int i=0;i<encriptado.length();i++){
            if (encriptado.charAt(i)==' ') {
                desencriptado+=(char)Integer.parseInt(assist);
                assist="";
            }else{
                assist+=encriptado.charAt(i);
            }
        }
        /*
        for (int i=0;i<encriptado.length();i++){
            if (encriptado.charAt(i)=='a') {
                desencriptado+='1';
            }
            if (encriptado.charAt(i)=='b') {
                desencriptado+='0';
            }
        }
        */
        System.out.println(desencriptado);
    }
}
