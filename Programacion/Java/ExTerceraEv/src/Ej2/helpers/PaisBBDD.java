package Ej2.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Ej2.Interfaz;

public class PaisBBDD implements DAOPaisesBBDD{

    @Override
    public void mostrarPoblacionPorNombre() {
        try {
            if (isTextValid(Interfaz.textareaNombre.getText())) {

                
                String sql = "SELECT * FROM paises WHERE nombre = '"+Interfaz.textareaNombre.getText()+"'";
                System.out.println(sql);
                
                ResultSet select = SingletonPaisBBDD.getConnection().createStatement().executeQuery(sql);
                
                if (select.next()) {
                    Interfaz.textareaPoblacion.setText(select.getString("poblacion"));
                    Interfaz.labelError.setText("Pais encontrado");
                    
                }else{
                    Interfaz.labelError.setText("No se encontro ningun pais");
                }

            }else{
                Interfaz.labelError.setText("Por favor introduzca un nombre");
            }
        } catch (SQLException e) {
            Interfaz.labelError.setText("Error con la base de datos");
            e.printStackTrace();
        }
    }
    
    @Override
    public void insertarNuevoPais() {
        try {
            if (isTextValid(Interfaz.textareaNombre.getText()) && isTextValid(Interfaz.textareaPoblacion.getText())) {
    
                if (nombreExist(Interfaz.textareaNombre.getText())) {
                    Interfaz.labelError.setText("Esa id ya existe");
                    
                }else{
                    
                    String sql = 
                        "INSERT INTO paises(nombre, poblacion) "+
                        "VALUES ('"+Interfaz.textareaNombre.getText()+
                        "', '"+Interfaz.textareaPoblacion.getText()+
                        "')"
                    ;
                    
                    System.out.println(sql);
                    SingletonPaisBBDD.getConnection().createStatement().executeUpdate(sql);
                    Interfaz.labelError.setText("Se ha realizado el insert");
                }
                
            }else{
                Interfaz.labelError.setText("Por favor introduzca un nombre y una poblacion");
            }

        } catch (SQLException e) {
            Interfaz.labelError.setText("Error con la base de datos");
            e.printStackTrace();
        }
    }

    @Override
    public void insertarArchivo() {

        String outputLine="";

        try {
            BufferedReader in = new BufferedReader(new FileReader(Ej2.Main.DIR_ARCHIVO_PAISES));
            String inputLine;
            int contador=0;

            while ((inputLine = in.readLine()) != null) {
                switch (contador%4) {

                    case 0:
                        outputLine += inputLine+",";
                    break;

                    case 1:
                        outputLine += inputLine+";";
                    break;
                }
                contador++;
            }
            in.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        String[] separarPaises = outputLine.split(";"), temporal;
        String[][] separarTotal = new String[separarPaises.length][2];
        for (int i = 0; i < separarPaises.length; i++) {
            temporal = separarPaises[i].split(",");
            separarTotal[i][0] = temporal[0];
            separarTotal[i][1] = temporal[1];
        }

        String sql;
        for (int i = 0; i < separarTotal.length; i++) {
            for (int j = 0; j < separarTotal[i].length; j++) {
                try {
                    if (!nombreExist(separarTotal[i][0])) {
                        sql = 
                            "INSERT INTO paises(nombre, poblacion) "+
                            "VALUES ('"+separarTotal[i][0]+
                            "', '"+separarTotal[i][1]+
                            "')"
                        ;
                        
                        System.out.println(sql);
                        SingletonPaisBBDD.getConnection().createStatement().executeUpdate(sql);
                        Interfaz.labelError.setText("Se ha realizado el insert desde el archivo");
                    }
        
                } catch (SQLException e) {
                    Interfaz.labelError.setText("Error con la base de datos al introducir el pais "+separarTotal[i][0]);
                    System.out.println("====== ERROR DE PAIS "+separarTotal[i][0]+" ======");
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isTextValid(String text){
        if (text==null) {
            return false;
        }
        if (text.equals("")) {
            return false;
        }
        return true;
    }
    private static boolean nombreExist(String nombreBuscado) throws SQLException{

        ResultSet selected = SingletonPaisBBDD.getConnection().createStatement().executeQuery("SELECT COUNT(*) FROM paises WHERE nombre = '"+nombreBuscado+"'");
        selected.next();

        if (0<selected.getInt("COUNT(*)")) {
            return true;
        }
        return false;
    }

    // ////////////////////////////////// GESTIONAR DATOS //////////////////////////////////
    // @Override
    // public void insertarContacto() {
    //     if (chekearDatos()) {
    //         try {
    //             if (idExist(Integer.parseInt(Interfaz.textareaId.getText()))) {
                    
    //                 Interfaz.labelError.setText("Esa id ya existe");
    //                 return;
    //             }

    //             String sql = 
    //                 "INSERT INTO contacto(id, nombre, apellido, telefono, email) "+
    //                 "VALUES ('"+Integer.parseInt(Interfaz.textareaId.getText())+
    //                 "', '"+Interfaz.textareaNombre.getText()+
    //                 "', '"+Interfaz.textareaApellido.getText()+
    //                 "', '"+Integer.parseInt(Interfaz.textareaTelefono.getText())+
    //                 "', '"+Interfaz.textareaEmail.getText()+
    //                 "')"
    //             ;
                
    //             System.out.println(sql);
    //             SingletonContactosBBDD.getConnection().createStatement().executeUpdate(sql);
    //             Interfaz.labelError.setText("Se ha realizado el insert");
                
    //             Interfaz.textareaApellido.setText("");
    //             Interfaz.textareaNombre.setText("");
    //             Interfaz.textareaId.setText("");
    //             Interfaz.textareaTelefono.setText("");
    //             Interfaz.textareaEmail.setText("");
                    
    //         } catch (SQLException e) {
    //             Interfaz.labelError.setText("Error al hacer el insert");
    //             e.printStackTrace();
    //         }
            
    //     }
    // }
}
