package EjerciciosObjetos.O18Patterns;

import java.util.regex.Pattern;

public class Ejercicios {
    public static void main(String[] args){

        String texto="255.4.36.112";

        //1. solo una minuscula
        System.out.println(Pattern.matches("[a-z]", texto)); 

        //2. una mayuscula o una minuscula
        System.out.println(Pattern.matches("[a-zA-Z]", texto)); 

        //3. x/y/z seguido de un digito
        System.out.println(Pattern.matches("[xyz][0-9]", texto)); 

        //4. una o mas mayusculas seguida de un digito
        System.out.println(Pattern.matches("[A-Z]+[0-9]", texto));

        //5. 8 digitos seguido de una letra mayuscula
        System.out.println(Pattern.matches("[0-9]{8}[A-Z]", texto));

        //6. +, digito, digito y luego de 9 a 12 digitos
        System.out.println(Pattern.matches("[+]\\d[0-9] [0-9]{0,12}", texto)); 

        //7. aaaa/mm/dd
        System.out.println(Pattern.matches("(19[0-9][0-9]||2[0-4][0-9][0-9]||2500)[/](0[1-9]||1[0-2])[/]([0-2][0-9]||3[0-1])", texto)); 

        //8. email
        System.out.println(Pattern.matches("[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-zA-Z]+", texto)); 

        //9. ip tipo 4
        System.out.println(Pattern.matches("([0-9]||\\d\\d||[1-2][0-4]\\d||25[0-5])[.]([0-9]||\\d\\d||[1-2][0-4]\\d||25[0-5])[.]([0-9]||\\d\\d||[1-2][0-4]\\d||25[0-5])[.]([0-9]||\\d\\d||[1-2][0-4]\\d||25[0-5])", texto)); 
        
        
        

    }
}
