package EjerciciosObjetos.O11Pokimon;
//hecho por daniel vals
//cosas que me faltan en math
//para su uso, copie el archivo, cambie el nombre del packaje y use el constructor de abajo
public class Mates {
    /*constructor:
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
        aleatorio=(int) (nInicial+(Math.random()*(nFinal-nInicial+1)));
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
