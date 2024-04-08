package src.F17DaoContactos;

import java.util.ArrayList;
import java.util.List;

public class AgendaArrayList implements ContactoDao {

	// en este caso la lista funciona como la base de datos
	private List<Contacto> agenda;

	public AgendaArrayList() {
		this.agenda = new ArrayList<Contacto>();
	}

	@Override
	public List<Contacto> getContactos() {
		return agenda;
	}

	@Override
	public Contacto getContactoPorNumero(int num) {
		for (int i = 0; i < agenda.size(); i++) {
			if (agenda.get(i).getTelefono() == num) {
				return agenda.get(i);
			}
		}
		return null;
	}

	public Contacto getContactoByArrayID(int i) {
		return agenda.get(i);
	}

	@Override
	public void agregarContacto(Contacto c) {
		agenda.add(c);
	}

	@Override
	public void borrarContacto(Contacto c) {
		agenda.remove(c);
	}

}
