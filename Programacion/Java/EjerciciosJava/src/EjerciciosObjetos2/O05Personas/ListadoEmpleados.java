package EjerciciosObjetos2.O05Personas;

import java.util.ArrayList;
import java.util.Scanner;

/* Ordenar por id / apellidos nombre / salario */
public class ListadoEmpleados {
    
    private ArrayList<Empleado> l;
    private Scanner teclado;

    public ListadoEmpleados(ArrayList<Empleado> l, Scanner sc) {
        this.l = l;
        this.teclado = sc;
    }

    public ArrayList<Empleado> getL() {
        return l;
    }

    public void setL(ArrayList<Empleado> l) {
        this.l = l;
    }
    
    public void addEmp(){
        //String nombre, apellidos, dni, estadoCivil, fecha;
        //int nDespacho;
        switch (teclado.nextLine().charAt(0)) {
            case 'P':
                
            break;
            case 'S':
            
            break;
        }
        l.add(null);
    }
}
