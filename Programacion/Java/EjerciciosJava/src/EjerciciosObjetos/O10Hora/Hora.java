package EjerciciosObjetos.O10Hora;

public class Hora {
    
    private int segundo;
    private int minuto;
    private int hora;

    public Hora(int segundo, int minuto, int hora) {
        this.segundo = segundo;
        this.minuto = minuto;
        this.hora = hora;
    }
    public Hora() {
        this.segundo = 0;
        this.minuto = 0;
        this.hora = 0;
    }
    @Override
    public String toString() {
        return "Fecha [" + hora + ":" + minuto + ":" + segundo + "]";
    }

    public void validar(){
        if (this.hora<0||23<this.hora) {
            this.hora=0;
        }
        if (this.minuto<0||59<this.minuto) {
            this.minuto=0;
        }
        if (this.segundo<0||59<this.segundo) {
            this.segundo=0;
        }
    }

    public void siguiente(){
        if (this.hora==23&&this.minuto==59&&this.segundo==59) {
            this.hora= 0;
            this.minuto= 0;
            this.segundo= 0;
        }else{
            if (this.minuto==59&&this.segundo==59) {
                this.hora+=1;
                this.minuto= 0;
                this.segundo= 0;
                
            }else if (this.segundo==59) {
                this.minuto+=1;
                this.segundo= 0;
            }else{
                this.segundo+=1;
            }
        }
    }
    public void anterior(){
        if (this.hora==0&&this.minuto==0&&this.segundo==0) {
            this.hora= 23;
            this.minuto= 59;
            this.segundo= 59;
        }else{
            this.segundo-=1;
            if (this.segundo<0) {
                this.minuto-=1;
                this.segundo=59;
                if (this.minuto<0) {
                    this.hora-=1;
                    this.minuto= 59;                  
                }
            }
        }
    }
    //calcular dias entre fechas (diferencias de dias entre dos fechas)
    public int calcularDias(Hora fechaComparar){
        int contDias=0;
        Hora fechaTemporal;
        fechaTemporal=new Hora(this.segundo, this.minuto, this.hora);

        if (fechaTemporal.compararFechas(fechaComparar)=='-') {
            while (!(fechaTemporal.compararFechas(fechaComparar)=='=')) {
                fechaTemporal.siguiente();
                contDias++;
            }
        }
        if (fechaTemporal.compararFechas(fechaComparar)=='+') {
            while (!(fechaTemporal.compararFechas(fechaComparar)=='=')) {
                fechaTemporal.anterior();
                contDias--;
            }
        }
        return contDias;
    }
    private char compararFechas(Hora horaComparar){
        if (this.segundo==horaComparar.segundo&&
            this.minuto==horaComparar.minuto&&
            this.hora==horaComparar.hora) {
            return '=';
        }else if (this.segundo<horaComparar.segundo&&
                this.minuto==horaComparar.minuto&&
                this.hora==horaComparar.hora) {
            return '-';
        }else if (this.minuto<horaComparar.minuto&&
                this.hora==horaComparar.hora) {
            return '-';
        }else if (this.hora<horaComparar.hora) {
            return '-';
        }
        return '+';
    }
}
