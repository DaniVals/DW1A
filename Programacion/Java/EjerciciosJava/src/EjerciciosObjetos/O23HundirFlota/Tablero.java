package EjerciciosObjetos.O23HundirFlota;

public class Tablero {
    private Casilla[][] casillas;
    private Barco[] barcos;
    private boolean rendido;

    public Tablero() {
        this.casillas = new Casilla[10][10];
        for(int i=0;i<casillas.length;i++){
            for(int j=0;j<casillas[i].length;j++){
                casillas[i][j] = new Casilla();
            }
        }
        this.barcos = new Barco[5];
        for(int i=0;i<5;i++){
            barcos[i]=new Barco(0);
        }
        this.rendido=false;
    }
    public void reiniciar(){
        for(int i=0;i<casillas.length;i++){
            for(int j=0;j<casillas[i].length;j++){
                casillas[i][j].setBarco(false);
                casillas[i][j].setMarcado(false);
            }
        }
        for(int i=0;i<5;i++){
            barcos[i].setSize(0);
            barcos[i].setOculto(false);
        }
        this.rendido=false;
    }
    public void imprimirTablero(boolean show){
        System.out.print("  A B C D E F G H I J");
        for(int i=0;i<casillas.length;i++){
            System.out.print("\n"+i);
            for(int j=0;j<casillas[i].length;j++){
                if (casillas[i][j].estaMarcado()||show) {
                    if (casillas[i][j].hayBarco()) {
                        System.out.print(" x");
                    }else{
                        System.out.print(" .");
                    }
                }else{
                    System.out.print(" ?");
                }
            }
            //imprimir solo en las lineas impares
            if ((i/2)!=((float)(i)/2)) {
            }else{
                //mostrar el estado de los 5 barcos
                if (i/2<5&&0<barcos[i/2].getSize()) {
                    //poner que barco es
                    System.out.print("    Barco "+i/2);
                    //su tamaño si no esta oculto
                    if (!barcos[i/2].isOculto()||show) {
                        System.out.print(" ("+barcos[i/2].getSize()+")");
                    }
                    //y si esta derrumbado
                    if (barcos[i/2].derrumbado()) {
                        System.out.print(" -- derrumbado");
                    }else{
                        System.out.print(" -- activo");
                    }
                }
            }
        }
        System.out.println();
    }
    private boolean dibujarBarco(Barco barco){

        if (barco.isHorizontal()) {
            if(barco.getPosX()+barco.getSize()-1>=this.casillas.length
                ||barco.getPosY()>=this.casillas.length){
                return false;
            }
            for(int i=barco.getPosX();i<barco.getPosX()+barco.getSize();i++){
                if (this.casillas[barco.getPosY()][i].hayBarco()) {
                    return false;
                }
            }

            for(int i=barco.getPosX();i<barco.getPosX()+barco.getSize();i++){
                this.casillas[barco.getPosY()][i].setBarco(true);
            }
            
        }else{
            if(barco.getPosY()+barco.getSize()-1>=this.casillas.length
                ||barco.getPosX()>=this.casillas.length){
                return false;
            }
            for(int i=barco.getPosY();i<barco.getPosY()+barco.getSize();i++){
                if (this.casillas[i][barco.getPosX()].hayBarco()) {
                    return false;
                }
            }

            for(int i=barco.getPosY();i<barco.getPosY()+barco.getSize();i++){
                this.casillas[i][barco.getPosX()].setBarco(true);
            }
        }
        return true;
    }
    public void crearBarco(int pos, int size){
        int x, y;
        //poner los barcos de forma aleatoria
        barcos[pos].setSize(size);
        do {
            x= (int) (Math.random()*10);
            y= (int) (Math.random()*10);
            barcos[pos].ponerBarco(x, y);
            if (Math.random()<0.5) {
                barcos[pos].setHorizontal(true);
            }else{
                barcos[pos].setHorizontal(false);
            }
        } while (!this.dibujarBarco(barcos[pos]));
    }
    public void descubrirCasilla(int x, int y){
        if (!this.casillas[x-48][y-97].estaMarcado()) {
            //no estaba marcada
            this.casillas[x-48][y-97].setMarcado(true);
            if (this.casillas[x-48][y-97].hayBarco()) {
                for(int i=0;i<5;i++){
                    if (barcos[i].getSize()!=0) {
                        if(barcos[i].estaEntre(x-48, y-97)){
                            //sumar un golpe    
                            barcos[i].setGolpes(barcos[i].getGolpes()+1);
                            if (barcos[i].derrumbado()) {
                                System.out.println("                         -- tocado y hundido --");
                            }else{
                                System.out.println("                         -- tocado --");
                            }
                        }
                    }
                }
            }else{
                System.out.println("                         -- agua --");
            }
        }else{
            System.out.println("casilla ya marcada");
        }
    }
    public boolean acabado(){
        for(Barco b: barcos){
            if (!b.derrumbado()) {
                return false;
            }
        }
        //si pasa por todas y ninguna falla, devolver true
        return true;
    }
    //G&S
    public Casilla[][] getCasillas() {
        return casillas;}
    public Barco[] getBarcos() {
        return barcos;}
    public boolean isRendido() {
        return rendido;}
    
    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;}
    public void setBarcos(Barco[] barcos) {
        this.barcos = barcos;}
    public void setRendido(boolean rendido) {
        this.rendido = rendido;}
    
}
