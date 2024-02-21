package EjerciciosObjetos2.O11InterfazEstadisticas;

public class ArrayNumeros implements Interfaz{
    private int[] lista;

    public ArrayNumeros() {
        this.lista = new int[0];
    }

    @Override
    public void meter(int n) {
        int[] asist=new int[lista.length+1];
        for(int i=0;i<lista.length;i++){
            asist[i]=lista[i];
        }
        asist[lista.length]=n;
        lista=asist;
    }

    @Override
    public int max() {
        int max = lista[0];
        for(int i=1;i<lista.length;i++){
            if (max<lista[i]) {
                max=lista[i];
            }
        }
        return max;
    }

    @Override
    public int min() {
        int min = lista[0];
        for(int i=1;i<lista.length;i++){
            if (lista[i]<min) {
                min=lista[i];
            }
        }
        return min;
    }

    @Override
    public double media() {
        int sumatorio = lista[0];
        for(int i=1;i<lista.length;i++){
            sumatorio+=lista[i];
        }
        return (double) sumatorio/lista.length;
    }

    @Override
    public int[] toArray() {
        return lista;
    }

    @Override
    public String toString() {
        String textoDevolver=""+lista[0];
        for(int i=1;i<lista.length;i++){
            textoDevolver+=", "+lista[i];
        }
        return "ListaNumeros [" + textoDevolver + "]";
    } 
}
