package src.F17DaoContactos.ConInterfazes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import src.F17DaoContactos.AgendaArrayList;
import src.F17DaoContactos.Contacto;

public class AgendaSaveLoad extends AgendaArrayList{

	// en este caso la lista funciona como la base de datos, y luego se guarda como un archivo y luego se carga
	String fileDir;
    int maxChars;
    char nullChar;


    public AgendaSaveLoad(String fileDir, int maxChars, char nullChar) {
        super();
        this.fileDir = fileDir;
        this.maxChars = maxChars;
        this.nullChar = nullChar;
        // file = new RandomAccessFile(new File(fileDir), "rw");
    }
    
    public void GuardarArchivo() throws IOException{
        RandomAccessFile file = new RandomAccessFile(new File(fileDir), "rw");

        for (Contacto c : this.getContactos()) {
            file.writeInt(c.getTelefono());
            file.writeChars(ajustarTextoAlMaximo(c.getNombre()));
            file.writeChars(ajustarTextoAlMaximo(c.getCorreo()));
            file.writeChars(ajustarTextoAlMaximo(c.getDireccion()));
        }

        file.close();
    }
    public void CargarArchivo() throws IOException{
        RandomAccessFile file = new RandomAccessFile(new File(fileDir), "r");

        this.getContactos().clear();
        while (file.getFilePointer()<file.length()) {
            this.agregarContacto(new Contacto(file.readInt(), getString(file), getString(file), getString(file)));
        }

        file.close();
    }




    private String getString(RandomAccessFile file) throws IOException {
        String devolver="";
        char nextchar;
        for (int i = 0; i < maxChars; i++) {
            nextchar=file.readChar();
            if (nextchar != nullChar) {
                devolver += nextchar;
            }else{
                file.seek(file.getFilePointer() + ((maxChars - i - 1)*2));
                return devolver;
            }
        }
        return devolver;
    }
    private String ajustarTextoAlMaximo(String texto){
        
        if (texto.length() < maxChars) {
            for (int i = texto.length(); i < maxChars; i++) {
                texto += nullChar;
            }
            return texto;
        }
        if (maxChars < texto.length()) {
            return texto.substring(0, maxChars);
        }
        return texto;

    }
    // private int tamañoEnBytesTotal(){
    //     return
    //     4+
    //     2*maxChars+
    //     2*maxChars+
    //     2*maxChars;
    // }

    public String getFileDir() {return fileDir;}
    public void setFileDir(String fileDir) {this.fileDir = fileDir;}

}
