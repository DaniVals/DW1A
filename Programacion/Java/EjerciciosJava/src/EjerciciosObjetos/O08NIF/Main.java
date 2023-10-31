package EjerciciosObjetos.O08NIF;
/*  
Crea una clase NIF que se usará para mantener DNIs 
con su correspondiente letra. Los atributos
serán el número de DNI (entero) y la letra que 
le corresponde (char). La clase dispondrá de los
siguientes métodos:
Constructor sin argumentos que inicialice el nº de DNI 
a 0 y la letra a espacio en blanco (será un
NIF no válido).
Constructor que reciba el DNI y establezca la letra 
que le corresponde.
Método que nos permita mostrar el NIF (ocho dígitos, 
un guión y la letra)
La letra se calculará con un método auxiliar (privado) 
de la siguiente forma: se obtiene el resto de la
división entera del número de DNI entre 23 y se usa 
la siguiente tabla para obtener la letra que
corresponde:
0 - T 1 - R 2 - W 3 - A 4 - G 5 - M 6 – Y 7 - F 8 - P 
9 - D 10 - X 11 - B 12 - N 13 – J
14 - Z 15 - S 16 - Q 17 - V 18 - H 19 - L 20 – C 21 - K 
22 – E
Probar los métodos de la clase creando 
varios objetos y operando con ellos en un programa.
*/
public class Main {
    public static void main(String[] args){

        NIF dni1;
        dni1=new NIF();
        dni1.crearNIF(23);
        System.out.println(dni1);
    }
}
