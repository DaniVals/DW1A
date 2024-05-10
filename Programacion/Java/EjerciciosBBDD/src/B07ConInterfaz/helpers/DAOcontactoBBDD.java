package B07ConInterfaz.helpers;

public interface DAOcontactoBBDD {
    void mostrarContacto();
    void siguienteContacto();
    void anteriorContacto();
    void primerContacto();
    void ultimoContacto();
    void irAContacto(int pos);


    void selectContactosAll();
    void selectContactosFiltrado();
    void insertarContacto();
    void updatePorIdContacto();
    void deletePorIdContacto();

}
