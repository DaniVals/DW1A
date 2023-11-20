package EjerciciosObjetos.O14FrabicanteProducto;

public class Fabricante {
    
    private String nombre;
    private String telefono;
    private String email;
    
    public Fabricante(String nombre, String telefono, String email) {
        this.nombre = validarNombre(nombre);
        this.telefono = validarTelefono(telefono);
        this.email = validarEmail(email);
    }

    public String getNombre() {
        return nombre;}
    public String getTelefono() {
        return telefono;}
    public String getEmail() {
        return email;}

    public void setNombre(String nombre) {
        this.nombre = nombre;}
    public void setTelefono(String telefono) {
        this.telefono = telefono;}
    public void setEmail(String email) {
        this.email = email;}
        
    @Override
    public String toString() {
        return "Fabricante "+nombre+"\n   tel="+telefono+"\n   email="+email;
    }  
    public String validarNombre(String nombre) {
        String textoAsist="";
        for (int i=0; i<nombre.length();i++){
            if('a'<=nombre.charAt(i)&&nombre.charAt(i)<='z' || 'A'<=nombre.charAt(i)&&nombre.charAt(i)<='Z'){
                textoAsist+=nombre.charAt(i);
            }
        }
        return textoAsist;
    }
    public String validarTelefono(String telefono) {
        String textoAsist="";
        if (9<=telefono.length()&&telefono.length()<=11) {
            for (int i=0; i<telefono.length();i++){
                if('0'<=telefono.charAt(i)&&telefono.charAt(i)<='9'){
                    textoAsist+=telefono.charAt(i);
                }else{
                    //textoAsist="ERROR1";
                    return textoAsist;
                }
            }
        }else{
            textoAsist="ERROR2";
        }
        return textoAsist;
    }
    public String validarEmail(String email) {
        int paso=0, longitud=email.length();
        String textoAsist="";
        email += " ";
        for (int i=0; i<longitud;i++){
            if(email.charAt(i)!='@'||email.charAt(i)!='.'&&paso==3){
                textoAsist+=email.charAt(i);
                if (paso==0) {
                    paso=1;}
                if (paso==2) {
                    paso=3;}
                if (paso==4) {
                    paso=5;}
            }
            if (email.charAt(i)=='@'&&paso==1&&
            ('a'<=email.charAt(i+1)&&email.charAt(i+1)<='z' || 'A'<=email.charAt(i+1)&&email.charAt(i+1)<='Z')){
                    textoAsist+=email.charAt(i);
                    paso=2;
            }
            if (email.charAt(i)=='.'&&paso==3&&
            ('a'<=email.charAt(i+1)&&email.charAt(i+1)<='z' || 'A'<=email.charAt(i+1)&&email.charAt(i+1)<='Z')){
                    paso=4;
            }
        }
        if (paso==5) {
            return textoAsist;
        }
        textoAsist="Sin email";
        return textoAsist;
    }    
}
