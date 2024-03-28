package src.F14Impresoras;

import java.util.Comparator;

public class OrdenarImpresora implements Comparator<Impresora> {
    
    @Override
    public int compare(Impresora i1, Impresora i2) {
        return i1.getNumSerie() - i2.getNumSerie();
    }
}
