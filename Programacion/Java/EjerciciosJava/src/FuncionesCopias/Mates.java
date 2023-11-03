package FuncionesCopias;

//cosas que faltan en math
public class Mates {
    /*
        Mates mates;
        mates=new Mates();
    */
    public boolean comprobarPrimo(int n){
        for(int i=2; i<n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public int randomInt(int nInicial, int nFinal){
        int aleatorio=0;
        aleatorio= (int) (nInicial+(Math.random()*(nFinal-nInicial+1)));
        return aleatorio;
    }
    public int factorial(int n){
        int r=1;
        for(int i=2; i<=n; i++){
            r=r*i;
        }
        return r;
    }
}
