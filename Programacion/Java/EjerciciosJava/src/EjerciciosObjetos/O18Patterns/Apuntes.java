package EjerciciosObjetos.O18Patterns;
//regex == regular expresion
import java.util.regex.Pattern;

public class Apuntes {
    public static void main(String[] args){
        //https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
        //https://regex101.com/
        //se pueden usar en el examen
        /*
            * == 0 o mas
            + == 1 o mas
            []== cualquiera de las opciones
        */
        boolean b = Pattern.matches("[ca]+b", "db");
        System.out.println(b); 
    }
}
