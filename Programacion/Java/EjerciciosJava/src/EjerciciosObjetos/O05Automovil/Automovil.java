package EjerciciosObjetos.O05Automovil;

public class Automovil {
    
    private char marca;
    private char modelo;
    private char motor;
    private char conbustible;
    private char color;
    private int numPuertas;
    private int numAsientos;
    private int velMax;
    private int velocidad;
    
    public Automovil(char marca, char modelo, char motor, char conbustible, char color, int numPuertas, int numAsientos,
            int velMax, int velocidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.conbustible = conbustible;
        this.color = color;
        this.numPuertas = numPuertas;
        this.numAsientos = numAsientos;
        this.velMax = velMax;
        this.velocidad = velocidad;
    }

    public char getMarca() {
        return marca;
    }

    public void setMarca(char marca) {
        this.marca = marca;
    }

    public char getModelo() {
        return modelo;
    }

    public void setModelo(char modelo) {
        this.modelo = modelo;
    }

    public char getMotor() {
        return motor;
    }

    public void setMotor(char motor) {
        this.motor = motor;
    }

    public char getConbustible() {
        return conbustible;
    }

    public void setConbustible(char conbustible) {
        this.conbustible = conbustible;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public int getVelMax() {
        return velMax;
    }

    public void setVelMax(int velMax) {
        this.velMax = velMax;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Automovil [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + ", conbustible=" + conbustible
                + ", color=" + color + ", numPuertas=" + numPuertas + ", numAsientos=" + numAsientos + ", velMax="
                + velMax + ", velocidad=" + velocidad + "]";
    }

    public void acelerar(int velocidad) {
        this.velocidad += velocidad;
        if(this.velocidad>this.velMax){
            this.velocidad = this.velMax;
        }
        System.out.println("velocidad actual: "+this.velocidad);
    }
    public void desacelerar(int velocidad) {
        this.velocidad -= velocidad;
        if(this.velocidad<0){
            this.velocidad = 0;
        }
        System.out.println("velocidad actual: "+this.velocidad);
    }
    public void frenar() {
        this.velocidad = 0;
        System.out.println("velocidad actual: "+this.velocidad);
    }
    public void duracionViaje(int km){
        float horas;
        horas=km/this.velocidad;
        System.out.println("la duracion es de "+horas+" horas");
    }
}
