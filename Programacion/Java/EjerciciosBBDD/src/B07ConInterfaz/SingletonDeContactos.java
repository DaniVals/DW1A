package B07ConInterfaz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Singleton.SingletonBBDD;

public class SingletonDeContactos implements ContactoDao{

    @Override
    public List<Contacto> getContactos() {
        ArrayList<Contacto> listaDev = new ArrayList<Contacto>();
        try {
            ResultSet selected = SingletonBBDD.getConnection().createStatement().executeQuery("SELECT COUNT(*) FROM contacto");

            while (selected.next()) {
                
                listaDev.add( new Contacto(
                    selected.getInt("id"), 
                    selected.getInt("telefono"), 
                    selected.getString("email"),
                    selected.getString("nombre"), 
                    selected.getString("apellido") 
                ));
            }
        } catch (SQLException e) {
        }
        return listaDev;
    }
    
    @Override
    public Contacto getContactoPorNumero(int num) {
        try {
            ResultSet selected = SingletonBBDD.getConnection().createStatement().executeQuery("SELECT * FROM contacto WHERE id = "+num);
            selected.next();
            return new Contacto(
                selected.getInt("id"), 
                selected.getInt("telefono"), 
                selected.getString("email"),
                selected.getString("nombre"), 
                selected.getString("apellido") 
            );
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void agregarContacto(Contacto c) {
    }

    @Override
    public void borrarContacto(Contacto c) {
    }

    
}
