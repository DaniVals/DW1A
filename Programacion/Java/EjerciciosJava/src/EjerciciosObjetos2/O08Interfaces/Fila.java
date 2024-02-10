package EjerciciosObjetos2.O08Interfaces;

public class Fila implements Lista{
    //lifo
    private int[] datos;

    
    public Fila() {
        this.datos = new int[0];
    }

    @Override
    public int sacar() {

        int devolver=0;
        try {
            devolver=datos[0];

            int[] asist=new int[datos.length-1];
            for(int i=1;i<datos.length;i++){
                asist[i-1]=datos[i];
            }
            datos=asist;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Fallo: "+e.getMessage());
        }
        return devolver;
    }

    @Override
    public void meter(int dato) {
        int[] asist=new int[datos.length+1];
        for(int i=0;i<datos.length;i++){
            asist[i]=datos[i];
        }
        asist[datos.length]=dato;
        datos=asist;
    }

    @Override
    public String toString(){
        String txt="Lista[";
        try {
            for(int i=0;i<datos.length-1;i++){
                txt+=datos[i]+", ";
            }
            txt+=datos[datos.length-1];
        } catch (IndexOutOfBoundsException e) {}
        txt+="]";
        return txt;
    }
}
