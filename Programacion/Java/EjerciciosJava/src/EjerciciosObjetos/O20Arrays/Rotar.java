package EjerciciosObjetos.O20Arrays;

public class Rotar {
    public static void main(String[] args) {
        // declares an array of integers
        int[] anArray;

        // allocates memory for 10 integers
        anArray = new int[5];
           
        // initialize first element
        anArray[0] = 0;
        // initialize second element
        anArray[1] = 1;
        // and so forth
        anArray[2] = 2;
        anArray[3] = 3;
        anArray[4] = 4;

        int arrayAssist=0;
        for(int i=0; i<anArray.length; i++){
            if(i==0) {
                arrayAssist=anArray[i];
            }
            if (i==anArray.length-1) {
                anArray[i]=arrayAssist;
            }else{
                anArray[i]=anArray[i+1];
            }
            System.out.println("Posicion "+i+" valor "+anArray[i]);
        }
    }
}
