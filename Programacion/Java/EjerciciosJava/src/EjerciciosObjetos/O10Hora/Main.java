package EjerciciosObjetos.O10Hora;


public class Main {
    public static void main(String[] args){

        Hora hora1, hora2;

        hora1=new Hora(30, 5, 1);
        hora2=new Hora();

        System.out.println(hora1);
        System.out.println(hora2);
        System.out.println(hora1.calcularDias(hora2));
        
        
    }
}
/*

5. Crea una clase Hora con atributos para las horas, los minutos y los segundos de la hora.
Incluye, al menos, los siguientes métodos:

Constructor sin argumentos con el 00:00:00 como hora por defecto.
Constructor parametrizado con horas, minutos y segundos.


Getters y setters para los tres atributos

print(): mostrará la hora por pantalla.

aSegundos(): devolverá el número de segundos transcurridos desde la medianoche.

segundosDesde(Hora): devolverá el número de segundos entre la hora y la proporcionada como
argumento.

siguiente(): pasará al segundo siguiente.
anterior(): pasará al segundo anterior.

igualQue(Hora): indica si la hora es la misma que la proporcionada como argumento.
menorQue(Hora): indica si la hora es anterior a la proporcionada como argumento.
mayorQue(Hora): indica si la hora es posterior a la proporcionada como argumento

Probar los métodos de la clase creando varios objetos y operando con ellos en un programa. */