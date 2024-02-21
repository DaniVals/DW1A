package EjerciciosObjetos2.O11InterfazEstadisticas;

import java.util.ArrayList;

public class ListaNumeros implements Interfaz{

    private ArrayList<Integer> lista;

    public ListaNumeros() {
        this.lista = new ArrayList<Integer>();
    }

    @Override
    public void meter(int n) {
        lista.add(n);
    }

    @Override
    public int max() {
        int max = lista.get(0);
        for(int i=1;i<lista.size();i++){
            if (max<lista.get(i)) {
                max=lista.get(i);
            }
        }
        return max;
    }

    @Override
    public int min() {
        int min = lista.get(0);
        for(int i=1;i<lista.size();i++){
            if (lista.get(i)<min) {
                min=lista.get(i);
            }
        }
        return min;
    }

    @Override
    public double media() {
        int sumatorio = lista.get(0);
        for(int i=1;i<lista.size();i++){
            sumatorio+=lista.get(i);
        }
        return (double) sumatorio/lista.size();
    }

    @Override
    public int[] toArray() {
        int[] arrayDevolver = new int[lista.size()];
        for(int i=0;i<lista.size();i++){
            arrayDevolver[i]=lista.get(i);
        }
        return arrayDevolver;
    }

    @Override
    public String toString() {
        String textoDevolver=""+lista.get(0);
        for(int i=1;i<lista.size();i++){
            textoDevolver+=", "+lista.get(i);
        }
        return "ListaNumeros [" + textoDevolver + "]";
    }   
     
}
