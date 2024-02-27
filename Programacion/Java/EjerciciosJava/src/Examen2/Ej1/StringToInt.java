package Examen2.Ej1;

public class StringToInt {
    public static int TextoNumero(String s){
        int num=0;
        for(int i=0;i<s.length();i++){
            int IDchar = (int)s.charAt(i);
            if ('0'<=IDchar&&IDchar<='9') {
                num = añadirNum(num, IDchar-48);
            }else{
                return-1;
            }
        }
        return num;
    }
    public static int añadirNum(int num, int add){
        return (num*10)+add;
    }
}
