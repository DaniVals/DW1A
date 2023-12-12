package FuncionesCopias;

public class Arrays {
    public static int[] ordenarArrayInt(int[] arrayOrdenar){
        int[] arrayOrdenado=new int[arrayOrdenar.length];
        int mayor=arrayOrdenar[0];
        int menor=arrayOrdenar[0];
        int posMenor=0;

        //sacar el mayor y el menor
        for(int i : arrayOrdenar){
            if (mayor<i) {
                mayor=i;
            }
            if (i<menor) {
                menor=i;
            }
        }
        arrayOrdenar[0]=menor;

        //por cada numero del array introducido
        for(int i=0; i<arrayOrdenar.length;i++){
            
            //buscar por el proximo menor
            for(int j=0; i<arrayOrdenar.length;i++){
                
                //si el numero es menor al ultimo del array ordenado, guardar su posicion
                if (arrayOrdenado[i]<menor) {
                    posMenor=j;
                }
            }
            //establecer en la posicion del menor el numero del mayor
            arrayOrdenado[arrayOrdenado.length-1]=arrayOrdenar[posMenor];
            arrayOrdenar[posMenor]=mayor;
        }

        return arrayOrdenado;
    }
    
    public static void mostrarArrayString(int[] arrayAnalizar){
        for (int txt : arrayAnalizar) {
            System.out.println(txt);
        }
    }
}
