package src.F17DaoContactos;

public class AccederAgenda {
    public static void main(String[] args) {
        ContactoDao cd = new AgendaArrayList();

        cd.agregarContacto(new Contacto(666, "Inf n69", "farfadox@gmail.com", "El diavlo"));
        System.out.println(cd.getContactoPorNumero(666));
    }
}
