package EjerciciosObjetos.O20Arrays;

public class DetectarPrimoArray {
    public static void main(String[] args) {

        int[] array={1,2,3,4,5};
        
        for(int i=0; i<array.length; i++){
            if (Mates.comprobarPrimo(array[i])) {
                System.out.println(array[i]+" es primo");
            }else{
                System.out.println(array[i]+" NO es primo");
            }
        }
    }
}
