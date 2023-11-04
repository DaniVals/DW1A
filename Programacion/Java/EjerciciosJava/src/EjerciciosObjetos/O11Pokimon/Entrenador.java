package EjerciciosObjetos.O11Pokimon;

public class Entrenador {
    //posicion del jugador
    private int x;
    private int y;
    //tamaño maximo del jugador
    private int xM;
    private int yM;
    //estadisticas
    private int dinero;
    private int victorias;
    private int derrotas;
    private int casillasRecorridas;

    public Entrenador(int xM, int yM) {
        this.x = (int) xM/2;
        this.y = (int) yM/2;
        this.xM = xM;
        this.yM = yM;
        this.dinero = 0;
        this.victorias = 0;
        this.derrotas = 0;
        this.casillasRecorridas = -1;
    }
    public void moverse(int direccion){
        switch (direccion){ //1.ARRIBA 2.DERECHA 3.ABAJO 4.IZQUIERDA
            case 1:
                this.y--;
            break;
            case 2:
                this.x++;
            break;
            case 3:
                this.y++;
            break;
            case 4:
                this.x--;
            break;
        }
        if (this.x<0) {
            this.x=0;}
        if (this.x>=this.xM) {
            this.x=this.xM-1;}
        if (this.y<0) {
            this.y=0;}
        if (this.y>=this.yM) {
            this.y=this.yM-1;}
        for (int j=0; j<this.yM;j++){//cambiar de linea
            for (int i=0; i<this.xM;i++){//dibujar la linea
                if (i==this.x&&j==this.y) {
                    System.out.print("@ ");
                }else{
                    System.out.print("_ ");
                }
            }
            System.out.println("");
        }
        this.casillasRecorridas++;
    }
    public void mostrarStats(){

    }
    @Override
    public String toString() {
        return "Entrenador [x=" + x + ", y=" + y + ", xM=" + xM + ", yM=" + yM + ", dinero=" + dinero + ", victorias="
                + victorias + ", derrotas=" + derrotas + ", casillasRecorridas=" + casillasRecorridas + "]";
    }
    

    
    

    
}
