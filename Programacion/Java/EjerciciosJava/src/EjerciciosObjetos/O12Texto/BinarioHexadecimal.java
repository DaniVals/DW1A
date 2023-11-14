package EjerciciosObjetos.O12Texto;

public class BinarioHexadecimal {
    private String texto;
    
    public BinarioHexadecimal(String texto) {
        while (texto.length()%4!=0) {
            texto= "0"+texto;
        }
        this.texto = texto;
    }
    private boolean esBinario(){
        for (int i=0; i<texto.length();i++){
            if(!(texto.charAt(i)=='0' || texto.charAt(i)=='1')){
                return false;}                
        }
        return true;
    }

    public String binarioAhexadecimal(){
        int numero=0, grupo=0, elevada=0;
        String valorHexadecimal="";
        if (esBinario()) {
            for (int i=0; i<texto.length()/4;i++){
                for(int j=3+grupo*4;j>=grupo*4;j--){//separarlo en cadenas de 4
                    
                    if(texto.charAt(j)=='1'){
                        numero+=Math.pow(2,(elevada));
                    }
                    elevada+=1;
                }
                switch (numero) {//sumarlo al texto en hexadecimal
                    case 10:
                    valorHexadecimal+="a";
                    break;
                    case 11:
                    valorHexadecimal+="b";
                    break;
                    case 12:
                    valorHexadecimal+="c";
                    break;
                    case 13:
                    valorHexadecimal+="d";
                    break;
                    case 14:
                    valorHexadecimal+="e";
                    break;
                    case 15:
                    valorHexadecimal+="f";
                    break;
                    default:
                    valorHexadecimal+=numero;
                    break;
                }
                //reiniciar cadena de 4
                numero=0;
                elevada=0;
                grupo+=1;
            }
        }else{
            valorHexadecimal="error";//devolver error
        }
        return valorHexadecimal;
    }
}
