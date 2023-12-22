package FuncionesCopias;

public class IntArray {
    //metodos de nacho xdd
    /*
    public static int[] ordenarArrayInt(int[] arrayPasado){
        int[] arrayOrdenar=arrayPasado;
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
        //por cada posicion del nuevo array
        for(int i=0; i<arrayOrdenar.length;i++){
            //buscar el menor del array introducido
            for(int j=0; j<arrayOrdenar.length;j++){
                //si el numero es menor al ultimo del array ordenado, guardar su posicion
                if (arrayOrdenar[j]<=menor) {
                    posMenor=j;
                }
            }
            //poner el menor numero en el array
            arrayOrdenado[i]=arrayOrdenar[posMenor];
            //establecer ese numero al mayor para que no se detecte de nuevo
            arrayOrdenar[posMenor]=mayor;
            //cambiar el menor para el siguiente bucle
            menor=mayor;
            for(int k : arrayOrdenar){
                if (k<menor) {
                    menor=k;
                }
            }
        }
        return arrayOrdenado;
    }
    
    public static boolean buscarInt(int[] arrayPasado, int numBuscar){
        int i=(int)(arrayPasado.length/2); //TRUNCA hay que poner -1 al llamarlo
        int j=i; //valor de i anterior
        while (0<=i) {

            //comprobar si lo encuentra
            if (arrayPasado[i]==numBuscar) {
                return true;
            }
            
            j=i;
            //disminuir i
            if (numBuscar<arrayPasado[i]) {
                i=(int)(i/2);
            }else{
                //aumentar i
                if (arrayPasado[i]<numBuscar) {
                    i=((int)(i/2+0.5))+j;
                }
            }
            //evitar que se pase de alto
            if (i>=arrayPasado.length) {
                i=arrayPasado.length-1;
            }
            //comprobar que no se queda estancado
            if (i==j) {
                return false;
            }
        }
        return false;
    }
    */
    
    //metodos que si son utiles
    public static int suma0DInt1D(int[] numeros){
        int suma=0;
        for(int i=0;i<numeros.length;i++){
                suma+=numeros[i];
        }
        return suma;
    }
    public static int[] suma1DInt2D(int[][] numeros){
        int[] suma;
        suma=new int[numeros.length];
        for(int i=0;i<numeros.length;i++){
            suma[i]=0;
            for(int j=0;j<numeros[i].length;j++){
                suma[i]+=numeros[i][j];
            }
        }
        return suma;
    }

    public static String string1D(int[] imprimir){
        String devolver="";
        for(int i=0;i<imprimir.length-1;i++){
            devolver+=imprimir[i]+" ";
        }
        devolver+=imprimir[imprimir.length-1]+"";
        return devolver;
    }
    public static String string2D(int[][] imprimir){
        String devolver="";
        for(int i=0;i<imprimir.length-1;i++){
            devolver+=string1D(imprimir[i]);
            devolver+="\n";
        }
        devolver+=string1D(imprimir[imprimir.length-1]);
        return devolver;
    }
    
    public static int[] media1DInt2D(int[][] numeros){
        int[] media;
        media=new int[numeros.length];
        for(int i=0;i<numeros.length;i++){
            media[i]=0;
            for(int j=0;j<numeros[i].length;j++){
                media[i]+=numeros[i][j];
            }
            media[i]=media[i]/numeros[i].length;
        }
        return media;
    }

    public static int[][] traspuesta2D(int[][] matriz){
        int masLargo=matriz[0].length;
        for(int i=0;i<matriz.length;i++){
            if(masLargo<matriz[i].length){
                masLargo = matriz[i].length;
            }
        }
        int[][] traspuesta = new int[masLargo][matriz.length];

        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                traspuesta[j][i]=matriz[i][j];
            }
        }
        return traspuesta;
    }
    public static int buscar2D(int[][] array, int busca){
        int contador=0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if (array[i][j]==busca) {
                    contador++;
                }
            }
        }
        return contador;
    }
    //Crear un método que reciba dos matrices y devuelve la matriz producto
    public static int[][] producto2Dx1D(int[][] A,int[] B){
        
        int[][] producto = new int[A.length][B.length];

        for(int i=0;i<producto.length;i++){
            for(int j=0;j<producto[0].length;j++){
                System.out.println("posicion "+i+" "+j+" numero "+A[i][j]+"*"+B[j] );
                producto[i][j]=(A[i][j]*B[j]);
            }
        }

        return producto;
    }
    public static int[][] poner0en2D(int[][] A){
        
        int masLargo=A[0].length;
        for(int i=0;i<A.length;i++){
            if(masLargo<A[i].length){
                masLargo = A[i].length;
            }
        }
        int[][] A2 = new int[A.length][masLargo];

        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                A2[i][j]=A[i][j];
            }
        }
        return A2;
    }
    
}
