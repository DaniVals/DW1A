package B07ConInterfaz.helpers;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;

import B07ConInterfaz.Interfaz;
import Singleton.SingletonContactosBBDD;

public class ContactoBBDD implements DAOcontactoBBDD{

    private static ResultSet cursor;


    ////////////////////////////////// MOSTRAR DATOS //////////////////////////////////

    @Override
    public void mostrarContacto() {
        if (cursor != null) {
            try {
                Interfaz.labelSelectedNombre.setText("N: "+cursor.getString("nombre"));
                Interfaz.labelSelectedApellido.setText("A: "+cursor.getString("apellido"));
                Interfaz.labelSelectedId.setText("I: "+cursor.getInt("id"));
                Interfaz.labelSelectedTelefono.setText("T: "+cursor.getInt("telefono"));
                Interfaz.labelSelectedEmail.setText("E: "+cursor.getString("email"));
                Interfaz.textareaCurrentData.setText(cursor.getRow()+"");
            } catch (SQLException e) {
                showCursorEmpty();
            }
        }
    }

    @Override
    public void siguienteContacto() {
        moveCursor(1);
        mostrarContacto();
    }

    @Override
    public void anteriorContacto() {
        moveCursor(-1);
        mostrarContacto();
    }

    @Override
    public void primerContacto() {
        try {
            Interfaz.labelError.setText("Cargando el primero...");
            cursor.first();
            mostrarContacto();
        } catch (SQLException e) {
            Interfaz.labelError.setText("Error al mover el cursor");
            e.printStackTrace();
        }
    }

    @Override
    public void ultimoContacto() {
        try {
            Interfaz.labelError.setText("Cargando el ultimo...");
            cursor.last();
            mostrarContacto();
        } catch (SQLException e) {
            Interfaz.labelError.setText("Error al mover el cursor");
            e.printStackTrace();
        }
    }

    @Override
    public void irAContacto(int pos) {
    
        pos = -1;
        try {
            pos = Integer.parseInt(Interfaz.textareaCurrentData.getText());
        } catch (NumberFormatException e) {
            try {
                Interfaz.textareaCurrentData.setText(cursor.getRow()+"");
            } catch (SQLException e1) {}
            Interfaz.labelError.setText("Ese numero no es valido");
        }
        
        if (cursor==null) {
            return;
        }
        if (pos<1) {
            try {
                Interfaz.textareaCurrentData.setText(cursor.getRow()+"");
            } catch (SQLException e1) {}
            Interfaz.labelError.setText("Ese numero es muy pequeño");
            return;
        }
        if (Integer.parseInt(Interfaz.labelSelectedData.getText().substring(2))<pos) {
            try {
                Interfaz.textareaCurrentData.setText(cursor.getRow()+"");
            } catch (SQLException e1) {}
            Interfaz.labelError.setText("Ese numero es muy grande");
            return;
        }

        try {
            cursor.absolute(pos);
            mostrarContacto();
        } catch (SQLException e) {
            Interfaz.labelError.setText("Error al mover el cursor");
            e.printStackTrace();
        }
    }

    @Override
    public void selectContactosAll() {
        String sql = "SELECT COUNT(*) FROM contacto";
                        
        System.out.println(sql);
        try {
            ResultSet selected = SingletonContactosBBDD.getConnection().createStatement().executeQuery("SELECT COUNT(*) "+sql);
            selected.next();
            int contContactos = selected.getInt("COUNT(*)");
            
            if (contContactos <= 0) {
                Interfaz.labelError.setText("No se han encontrado datos");
                cursor = null;
                showCursorEmpty();
                Interfaz.textareaCurrentData.setText("0");
                Interfaz.labelSelectedData.setText("/ 0");
            }else{
                cursor = SingletonContactosBBDD.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * "+sql);
                cursor.next();
                mostrarContacto();
                
                Interfaz.labelError.setText("Se ha realizado el select");
                Interfaz.labelSelectedData.setText("/ "+contContactos);
            }
        } catch (SQLException e) {
            showCursorEmpty();
            Interfaz.textareaCurrentData.setText("0");
            Interfaz.labelSelectedData.setText("/ 0");
            Interfaz.labelError.setText("Error al hacer el select");
            e.printStackTrace();
        }
    }
    @Override
    public void selectContactosFiltrado() {
        if (chekearDatos()) {
            
            String sql = "FROM contacto";
            
            // si puso un filtro
            if (
                0<Interfaz.textareaId.getText().length() 
                || 0<Interfaz.textareaNombre.getText().length()
                || 0<Interfaz.textareaApellido.getText().length()
                || 0<Interfaz.textareaTelefono.getText().length()
                || 0<Interfaz.textareaEmail.getText().length()
                ) {
                    sql+=" WHERE "+crearWhere();
            }
                
            System.out.println("SELECT COUNT(*) "+sql);
            try {
                ResultSet selected = SingletonContactosBBDD.getConnection().createStatement().executeQuery("SELECT COUNT(*) "+sql);
                selected.next();
                int contContactos = selected.getInt("COUNT(*)");
                
                if (contContactos <= 0) {
                    Interfaz.labelError.setText("No se han encontrado datos");
                    cursor = null;
                    showCursorEmpty();
                    Interfaz.textareaCurrentData.setText("0");
                    Interfaz.labelSelectedData.setText("/ 0");
                }else{
                    cursor = SingletonContactosBBDD.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * "+sql);
                    cursor.next();
                    mostrarContacto();
                    
                    Interfaz.labelError.setText("Se ha realizado el select");
                    Interfaz.labelSelectedData.setText("/ "+contContactos);
                }
            } catch (SQLException e) {
                showCursorEmpty();
                Interfaz.textareaCurrentData.setText("0");
                Interfaz.labelSelectedData.setText("/ 0");
                Interfaz.labelError.setText("Error al hacer el select");
                e.printStackTrace();
            }
            
        }
    }

    ////////////////////////////////// GESTIONAR DATOS //////////////////////////////////
    @Override
    public void insertarContacto() {
        if (chekearDatos()) {
            try {
                if (idExist(Integer.parseInt(Interfaz.textareaId.getText()))) {
                    
                    Interfaz.labelError.setText("Esa id ya existe");
                    return;
                }

                String sql = 
                    "INSERT INTO contacto(id, nombre, apellido, telefono, email) "+
                    "VALUES ('"+Integer.parseInt(Interfaz.textareaId.getText())+
                    "', '"+Interfaz.textareaNombre.getText()+
                    "', '"+Interfaz.textareaApellido.getText()+
                    "', '"+Integer.parseInt(Interfaz.textareaTelefono.getText())+
                    "', '"+Interfaz.textareaEmail.getText()+
                    "')"
                ;
                
                System.out.println(sql);
                SingletonContactosBBDD.getConnection().createStatement().executeUpdate(sql);
                Interfaz.labelError.setText("Se ha realizado el insert");
                
                Interfaz.textareaApellido.setText("");
                Interfaz.textareaNombre.setText("");
                Interfaz.textareaId.setText("");
                Interfaz.textareaTelefono.setText("");
                Interfaz.textareaEmail.setText("");
                    
            } catch (SQLException e) {
                Interfaz.labelError.setText("Error al hacer el insert");
                e.printStackTrace();
            }
            
        }
    }

    @Override
    public void updatePorIdContacto() {
        if (checkId() && chekearDatos()) {
            
            try {
                if (!idExist(Integer.parseInt(Interfaz.textareaId.getText()))) {
                    
                    Interfaz.labelError.setText("Esa id no existe");
                    return;
                }
                ResultSet selected = SingletonContactosBBDD.getConnection().createStatement().executeQuery("SELECT * FROM contacto WHERE id = "+Interfaz.textareaId.getText());
                selected.next();

                String sql = 
                    "UPDATE contacto SET "+
                    "nombre = '" + ponerConPlaceholder(Interfaz.textareaNombre.getText(), selected.getString("nombre")) + 
                    "', apellido = '" + ponerConPlaceholder(Interfaz.textareaApellido.getText(), selected.getString("apellido")) + 
                    "', telefono = '" +  ponerConPlaceholder(Interfaz.textareaTelefono.getText(), selected.getString("telefono")) + 
                    "', email = '" +  ponerConPlaceholder(Interfaz.textareaEmail.getText(), selected.getString("email")) + 
                    "' WHERE id = " + Interfaz.textareaId.getText();
                ;
                    
                System.out.println(sql);
                SingletonContactosBBDD.getConnection().createStatement().executeUpdate(sql);
                Interfaz.labelError.setText("Se ha realizado el update");

            } catch (SQLException e) {
                Interfaz.labelError.setText("Error al hacer el update");
                e.printStackTrace();
            }
            
        }
    }

    @Override
    public void deletePorIdContacto() {
        if (checkId() && chekearDatos()) {
            
            try {
                if (!idExist(Integer.parseInt(Interfaz.textareaId.getText()))) {
                    
                    Interfaz.labelError.setText("Esa id no existe");
                    return;
                }
                ResultSet selected = SingletonContactosBBDD.getConnection().createStatement().executeQuery("SELECT * FROM contacto WHERE id = "+Interfaz.textareaId.getText());
                selected.next();

                String sql = 
                    "DELETE FROM contacto WHERE id = " + Interfaz.textareaId.getText();
                ;
                    
                System.out.println(sql);
                SingletonContactosBBDD.getConnection().createStatement().executeUpdate(sql);
                Interfaz.labelError.setText("Se ha realizado el delete");

            } catch (SQLException e) {
                Interfaz.labelError.setText("Error al hacer el delete");
                e.printStackTrace();
            }
            
        }
    }
    
    ////////////////////////////////// HELPERS BASICOS //////////////////////////////////
    
    private static String ponerConPlaceholder(String textoOG,String placeholder){
        if (textoOG.equals("")) {
            return placeholder;
        }
        return textoOG;
    }
    
    ////////////////////////////////// HELPERS AVANZADOS //////////////////////////////////
    private static boolean idExist(int idBuscada) throws SQLException{

        ResultSet selected = SingletonContactosBBDD.getConnection().createStatement().executeQuery("SELECT COUNT(*) FROM contacto WHERE id = "+idBuscada);
        selected.next();

        if (0<selected.getInt("COUNT(*)")) {
            return true;
        }
        return false;
    }

    private static String crearWhere(){
        String devuelto="";
        if (0<Interfaz.textareaId.getText().length()) {
            if (devuelto.length()<=0) {
                devuelto += "id = "+Interfaz.textareaId.getText();
            }else{
                devuelto += " AND id = "+Interfaz.textareaId.getText();
            }
        }
        if (0<Interfaz.textareaNombre.getText().length()) {
            if (devuelto.length()<=0) {
                devuelto += "nombre LIKE '"+Interfaz.textareaNombre.getText()+"%'";
            }else{
                devuelto += " AND nombre LIKE '"+Interfaz.textareaNombre.getText()+"%'";
            }
        }
        if (0<Interfaz.textareaApellido.getText().length()) {
            if (devuelto.length()<=0) {
                devuelto += "apellido LIKE '"+Interfaz.textareaApellido.getText()+"%'";
            }else{
                devuelto += " AND apellido LIKE '"+Interfaz.textareaApellido.getText()+"%'";
            }
        }
        if (0<Interfaz.textareaTelefono.getText().length()) {
            if (devuelto.length()<=0) {
                devuelto += "telefono LIKE '"+Interfaz.textareaTelefono.getText()+"%'";
            }else{
                devuelto += " AND telefono LIKE '"+Interfaz.textareaTelefono.getText()+"%'";
            }
        }
        if (0<Interfaz.textareaEmail.getText().length()) {
            if (devuelto.length()<=0) {
                devuelto += "email LIKE '"+Interfaz.textareaEmail.getText()+"%'";
            }else{
                devuelto += " AND email LIKE '"+Interfaz.textareaEmail.getText()+"%'";
            }
        }
        return devuelto;
    }
    
    private static void moveCursor(int cant){
        if (cursor==null) {
            return;
        }
        if (cant==0) {
            return;
        }
        try {
            if (0<cant) {
                for (int i = 0; i < cant; i++) {
                    if (cursor.next()) {
                        Interfaz.labelError.setText("Mostrando contacto...");
                        Interfaz.labelError.setText("Mostrando contacto");
                    }else{
                        Interfaz.labelError.setText("No hay un siguiente");
                        cursor.previous();
                        break;
                    }
                }
            } else {
                for (int i = cant; i < 0; i++) {
                    if (cursor.previous()) {
                        Interfaz.labelError.setText("Mostrando contacto...");
                        Interfaz.labelError.setText("Mostrando contacto");
                    }else{
                        Interfaz.labelError.setText("No hay un anterior");
                        cursor.next();
                        break;
                    }
                }
                
            }
        } catch (SQLException e) {
            Interfaz.labelError.setText("Error al mover el cursor");
            e.printStackTrace();
        }
    }

    private static boolean chekearDatos(){
        boolean devuelto = true;
        String mensajeError = "";
        if (0<Interfaz.textareaId.getText().length()) {
            try {
                Integer.parseInt(Interfaz.textareaId.getText());
            } catch (NumberFormatException e) {
                mensajeError += "Id no valida (un numero) \n";
                devuelto = false;
            }
        }
        if (0<Interfaz.textareaTelefono.getText().length()) {
            try {
                Integer.parseInt(Interfaz.textareaTelefono.getText());
            } catch (NumberFormatException e) {
                mensajeError += "Telefono no valido (un numero) \n";
                devuelto = false;
            }
        }
        if (!devuelto) {
            Interfaz.labelError.setText(mensajeError);
        }
        Interfaz.labelError.setText(mensajeError);
        return devuelto;
    }
    private static void showCursorEmpty(){
        Interfaz.labelSelectedNombre.setText("N: ");
        Interfaz.labelSelectedApellido.setText("A: ");
        Interfaz.labelSelectedId.setText("I: ");
        Interfaz.labelSelectedTelefono.setText("T: ");
        Interfaz.labelSelectedEmail.setText("E: ");
    }

    private static boolean checkId(){
        String mensajeError = "";
        if (0<Interfaz.textareaId.getText().length()) {
            try {
                Integer.parseInt(Interfaz.textareaId.getText());
            } catch (NumberFormatException e) {
                mensajeError += "Id no valida (un numero) \n";
                Interfaz.labelError.setText(mensajeError);
                return false;
            }
        }else{
            mensajeError += "Se necesita una id \n";
            Interfaz.labelError.setText(mensajeError);
            return false;
        }
        return true;
    }



    ////////////////////////////////////////////// ARCHIVOS /////////////////////////////////////////////

    public void crearJson(){

        String sql = "SELECT COUNT(*) FROM contacto";
        try {
            ResultSet selected = SingletonContactosBBDD.getConnection().createStatement().executeQuery(sql);
            selected.next();
            int contContactos = selected.getInt("COUNT(*)");
            
            if (contContactos <= 0) {
                Interfaz.labelError.setText("No se han encontrado datos para el archivo");

            }else{
                sql = "SELECT * FROM contacto";
                ResultSet paraArchivo = SingletonContactosBBDD.getConnection().createStatement().executeQuery(sql);
                
                JSONObject archivo = new JSONObject();
                JSONObject contacto;
                while (paraArchivo.next()) {
                    contacto = new JSONObject();
                    contacto.put("nombre",paraArchivo.getString("nombre"));
                    contacto.put("apellido", paraArchivo.getString("apellido"));
                    contacto.put("telefono", paraArchivo.getInt("telefono"));
                    contacto.put("email", paraArchivo.getString("email"));
                    
                    archivo.put("contacto "+paraArchivo.getInt("id"), contacto);
                }
                System.out.println("JSON acabado:");
                System.out.println(archivo.toString(4));
                
                try (FileWriter file = new FileWriter("Programacion/Java/EjerciciosBBDD/src/B07ConInterfaz/agenda.json")) {
                    file.write(archivo.toString(4));
                    System.out.println("Successfully wrote JSON object to file.");
                    
                } catch (IOException e) {
                    System.out.println("Error al guardar el json");
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            Interfaz.labelError.setText("Error en el select para el archivo");
            e.printStackTrace();
        }
    }
}
