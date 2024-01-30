package EjerciciosClass;

public class C21_Desencriptador {
	public static void main(String[] args) {
        String encriptado="mmsmmmsm msssmsmm mssmsmmm mssmmsms msssmmsm mssmmsms mmsmmmmm mssmsmms msssmmss mmsmmmmm msssmmss mssmssss mssmssms mssmmsms msssmsmm mssmsmmm mssmsmms mssmsssm mssmmsss mmsmmmmm msssmsss msssmmsm mssmssss mssmsssm mssmsss mmsmmmmm msssmsss mssmsmms msssmsmm mssmsmmm mmsmmmmm msssmsmm mssmsmmm mssmmsms mmsmmmmm mssmsssm msssmsms mssmssms mssmmmsm mssmmsms msssmmsm msssmmss mmsmssmm mmsmmmmm mssmsmms msssmmss mssmsssm mmsmmsss msssmsmm mmsmmmmm msssmsmm mssmsmmm mssmmsms msssmmsm mssmmsms mmssssss";
        //String assist="";
        String desencriptado="";
        int num=0;
        for (int i=0;i<encriptado.length();i++){
            if (encriptado.charAt(i)=='m') {
                desencriptado+='0';
                num++;
            }
            if (encriptado.charAt(i)=='s') {
                desencriptado+='1';
                num++;
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
        System.out.println(num);
    }
}
