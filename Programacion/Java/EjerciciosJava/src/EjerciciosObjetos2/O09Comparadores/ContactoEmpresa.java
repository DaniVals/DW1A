package EjerciciosObjetos2.O09Comparadores;

public class ContactoEmpresa extends Contacto {
    
    private String sector;
    private int postal;

    public ContactoEmpresa(String correo, int telefono, String sector, int postal) {
        super(correo, telefono);
        this.sector = sector;
        this.postal = postal;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getPostal() {
        return postal;
    }

    public void setPostal(int postal) {
        this.postal = postal;
    }

    @Override
    public String toString() {
        return "ContactoEmpresa \n\tsector:" + sector + "\n\tpostal:" + postal + super.toString();
    }
    
}
