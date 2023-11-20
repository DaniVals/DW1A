package EjerciciosObjetos.O13CuentaBanco;

public class Fecha {
    
    private int dia;
    private int mes;
    private int año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    @Override
    public String toString() {
        return "[" + dia + "-" + mes + "-" + año + "]";
    }
    
    public boolean bisiesto(){
        if (this.año%4==0&&this.año%100!=0||this.año%400==0) {
            return true;}
        else{
            return false;}
    }
    
    public int diasMes(){
        switch (this.mes) {
            case 1,3,5,7,8,10,12:
                return (int)31;
            case 4,6,9,11:
                return (int)30;
            case 2:
                if (this.bisiesto()) {
                    return (int)29;}
                else{
                    return (int)28;}
            default:
        }
        return 0;
    }

    public void validar(){
        if (this.año<1900||2500<this.año) {
            this.año=1900;
        }
        if (this.mes<1||12<this.mes) {
            this.mes=1;
        }
        if (this.dia<0||this.diasMes()<this.dia) {
            this.dia=1;
        }
    }

    public void siguiente(){
        if (this.año==2500&&this.mes==12&&this.dia==31) {
            this.año= 1900;
            this.mes= 1;
            this.dia= 1;
        }else{
            if (this.mes==12&&this.dia==31) {
                this.año+=1;
                this.mes= 1;
                this.dia= 1;
                
            }else if (this.diasMes()==this.dia) {
                this.mes+=1;
                this.dia= 1;
            }else{
                this.dia+=1;
            }
        }
    }
    public void anterior(){
        if (this.año==1900&&this.mes==1&&this.dia==1) {
            this.año= 2500;
            this.mes= 12;
            this.dia= 31;
        }else{
            this.dia-=1;
            if (this.dia<1) {
                this.mes-=1;
                this.dia= this.diasMes();
                if (this.mes<1) {
                    this.año-=1;
                    this.mes= 12;
                    this.dia= 31;                    
                }
            }
        }
    }
    //calcular dias entre fechas (diferencias de dias entre dos fechas)
    public int calcularDias(Fecha fechaComparar){
        int contDias=0;
        Fecha fechaTemporal;
        fechaTemporal=new Fecha(this.dia, this.mes, this.año);

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
    private char compararFechas(Fecha fechaComparar){
        if (this.dia==fechaComparar.dia&&
            this.mes==fechaComparar.mes&&
            this.año==fechaComparar.año) {
            return '=';
        }else if (this.dia<fechaComparar.dia&&
                this.mes==fechaComparar.mes&&
                this.año==fechaComparar.año) {
            return '-';
        }else if (this.mes<fechaComparar.mes&&
                this.año==fechaComparar.año) {
            return '-';
        }else if (this.año<fechaComparar.año) {
            return '-';
        }
        return '+';
    }
}
