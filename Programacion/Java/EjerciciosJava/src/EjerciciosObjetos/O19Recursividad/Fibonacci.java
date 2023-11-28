package EjerciciosObjetos.O19Recursividad;

public class Fibonacci {
    public static void main(String[] args){

        Fibonacci.calcularSig(1,1,10);
        System.out.println("pausa");
        Fibonacci.calcularAnt(13, 21);

    }
    public static void calcularSig(int num, int numAnt, int reps){
        int numAssist=num;
        num=numAnt+num;
        numAnt= numAssist;
        System.out.println(num);
        if (reps>0) {
            Fibonacci.calcularSig(num, numAnt, reps-1);
        }
    }
    public static void calcularAnt(int num, int numSig){
        int numAssist=num;
        num=numSig-num;
        numSig= numAssist;
        System.out.println(num);
        if (num>1) {
            Fibonacci.calcularAnt(num, numSig);
        }
    }
}
