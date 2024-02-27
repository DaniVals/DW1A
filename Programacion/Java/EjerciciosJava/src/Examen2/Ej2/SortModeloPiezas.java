package Examen2.Ej2;

import java.util.Comparator;

public class SortModeloPiezas implements Comparator<Robot>{
    @Override
    public int compare(Robot o1, Robot o2) {
        if (o1.getModelo().compareTo(o2.getModelo())==0) {
            return o1.getnPiezas()-o2.getnPiezas();
        }
        return o1.getModelo().compareTo(o2.getModelo());
    }
    
}
