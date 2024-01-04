package EjerciciosObjetos.O23HundirFlota;

public class Casilla {
    private boolean barco;
    private boolean marcado;

    public Casilla() {
        this.barco = false;
        this.marcado = false;
    }

    public boolean hayBarco() {
        return barco;}
    public boolean estaMarcado() {
        return marcado;}

    public void setBarco(boolean barco) {
        this.barco = barco;}
    public void setMarcado(boolean marcado) {
        this.marcado = marcado;}
}
