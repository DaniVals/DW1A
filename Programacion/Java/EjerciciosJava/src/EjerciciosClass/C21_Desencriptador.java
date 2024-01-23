package EjerciciosClass;

public class C21_Desencriptador {
	public static void main(String[] args) {
        String encriptado="ººªªºªººººªªººªªºªºººªªºººªªººªªººªªºººººªººººªº ºªºººªººººªªªºººººªªººªººªºººªªºººªªººººººªªºªªº ººªªººººººªªºªªºººªªºªººººªªºªªººªºººªººººªªªººº ººªªººªºººªªººªººªºººªªºººªªºªªººªºººªºººªººººªª";
        String assist="";
        String desencriptado="";
        
        for (int i=0;i<encriptado.length();i++){
            if (encriptado.charAt(i)=='º') {
                desencriptado+='0';
            }
            if (encriptado.charAt(i)=='ª') {
                desencriptado+='1';
            }
            if (encriptado.charAt(i)==' ') {
                desencriptado+=' ';
            }
        }
        /*
        for (int i=0;i<encriptado.length();i++){
            if (encriptado.charAt(i)==' ') {
                desencriptado+=(char)Integer.parseInt(assist);
                assist="";
            }else{
                assist+=encriptado.charAt(i);
            }
        }
        */
        System.out.println(desencriptado);
    }
}
