package Ej1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Pais {
    private String nombre;
    private double poblacion;
    private double extension;
    private double PIB;
    
    public Pais(String nombre, double poblacion, double extension, double pIB) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.extension = extension;
        PIB = pIB;
    }

    public String getNombre() {return nombre;}
    public double getPoblacion() {return poblacion;}
    public double getExtension() {return extension;}
    public double getPIB() {return PIB;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setPoblacion(double poblacion) {this.poblacion = poblacion;}
    public void setExtension(double extension) {this.extension = extension;}
    public void setPIB(double pIB) {PIB = pIB;}


    
    @Override
    public String toString() {
        return "Pais [nombre=" + nombre + ", poblacion=" + poblacion + ", extension=" + extension + ", PIB=" + PIB
                + "]";
    }

    public boolean esValido(){

        if ( !(500000<extension)) {
            return false;
        }

        if (!(30<=poblacion && poblacion<=250)) {
            return false;
        }

        return true;
    }


   /**
    * <p>Lee los datos de un {@code Archivo} en texto plano con informacion de paises (un parametro en cada linea) y los separa en otro {@code Archivo} con un pais en cada linea, separado por caracteres especiales
    
    * <p>Ejemplo de pais entrante
    * <ul>
    * <li>{@code Nombre}
    * <li>{@code Poblacion}
    * <li>{@code Extension}
    * <li>{@code PIB}
    * </ul>
    
    * <p>Ejemplo de pais saliente
    * <ul>
    * <li>{@code Nombre;Poblacion*Extension;PIB}
    * </ul>
    
    * <p>Puedes añadir tantos paises como quieras, pero ten en cuenta que solo se escribira si esta completo
    
    * @param      inputFileDir la dirreccion del archivo del que se leeran los datos
    * @param      outputFileDir la dirreccion del archivo en el que se guardara la version comprimida
    * @throws     IOException  if the file does not exist,
    *             is a directory rather than a regular file,
    *             or for some other reason cannot be opened for
    *             reading.
    */
    public static void comprimirLineasDeUnArchivoEnOtro(String inputFileDir, String outputFileDir) throws IOException {
        
        BufferedReader in = null;
        PrintWriter out = null;

        in = new BufferedReader(new FileReader(inputFileDir));
        out = new PrintWriter(  new FileWriter(outputFileDir));
        
        String inputLine, outputLine="";
        int contador=0;
        
        while ((inputLine = in.readLine()) != null) {
            switch (contador%4) {
                
                case 0:
                outputLine += inputLine+";";
                break;
                
                case 1:
                outputLine += inputLine+"*";
                break;
                
                // este coincide con el 'case 0:' pero lo separo para que se entienda mejor
                case 2:
                outputLine += inputLine+";";
                break;
                
                // añadir solo cuando este completo los datos del pais
                case 3:
                outputLine += inputLine;
                out.println(outputLine);
                outputLine = "";
                break;
            }
            contador++;
        }
        if (in != null) {
            in.close();
        }
        if (out != null) {
            out.close();
        }
    }
    

   /**
    * <p>Lee los datos de un {@code Archivo} de lineas comprimidas (como el del metodo {@link Pais#comprimirLineasDeUnArchivoEnOtro}) y etc...
    
    * <p>Ejemplo de pais entrante
    * <ul>
    * <li>{@code Nombre;Poblacion*Extension;PIB}
    * </ul>
    
    * <p>Puedes añadir tantos paises como quieras, pero ten en cuenta que solo se escribira si esta completo
    
    * @param      inputFileDir la dirreccion del archivo del que se leeran los datos
    * @param      outputFileDir la dirreccion del archivo en el que se guardara la version comprimida
    * @throws     IOException  if the file does not exist,
    *             is a directory rather than a regular file,
    *             or for some other reason cannot be opened for
    *             reading.
    */
    public static ArrayList<Pais> crearArrayListDePaisesValidosDesdeArchivoDeLineasCompimidas(String inputFileDir) throws IOException {
        
        ArrayList<Pais> paisesDevolver = new ArrayList<Pais>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(inputFileDir));
            
            String inputLine;
            Pais paisParaGuardar;

            while ((inputLine = in.readLine()) != null) {
                String[] paisLeido = inputLine.split("[;*]");
                try {
                    paisParaGuardar = new Pais(
                        paisLeido[0], 
                        Double.parseDouble(paisLeido[1]),
                        Double.parseDouble(paisLeido[2]),
                        Double.parseDouble(paisLeido[3])
                    );
                    if (paisParaGuardar.esValido()) {
                        paisesDevolver.add(paisParaGuardar);
                    }
                } catch (NumberFormatException  e) {
                    // pais no valido
                    // System.out.println(paisLeido[0]+" no valido");
                }
            }
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
        return paisesDevolver;
    }


    public static void crearArchivoBinarioConNombreYPoblacionDesdeArrayList(ArrayList<Pais> inputArray, String outputFileDir) throws IOException {
        
		File fichero = new File(outputFileDir);
		RandomAccessFile output = new RandomAccessFile(fichero, "rw");

        for (Pais pais : inputArray) {
            if (600000 < pais.getExtension()) {
                output.writeUTF(pais.getNombre());
                output.writeDouble(pais.getPoblacion());
            }
        }
        
        output.close();
    }
}
