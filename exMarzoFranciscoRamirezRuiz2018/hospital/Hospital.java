package exMarzoFranciscoRamirezRuiz2018.hospital;

import java.util.ArrayList;
import java.util.Iterator;

import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.CamaNoValidaException;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.CamaOcupadaException;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.HabitacionNoValidaException;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.NombreNoValidoException;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.PacienteNoExisteException;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.SexoNoValidoException;

/**
 * clase hospital
 * 
 * @author Francisco Ram�rez Ruiz, Jos� Mar�a Romero Ruiz, Guillermo Boquizo
 *         S�nchez, Rafael Delgado Pe�a.
 * @version 2.0
 *
 */
public class Hospital {
	/**
	 * Campo para el Arraylist de pacientes del hospital.
	 */
	private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

	/**
	 * Constante para el nombre del hospital.
	 */
	private final String NOMBRE = "Hospital Gran Capit�n";

	/**
	 * Permite a�adir un paciente al Arraylist. Si sus campos no son v�lidos o la
	 * cama est� ocupada, lanzar� una excepci�n.
	 * 
	 * @param nombre
	 *            Nombre del paciente.
	 * @param sexo
	 *            Sexo del paciente.
	 * @param habitacion
	 *            Habitaci�n del paciente.
	 * @param cama
	 *            Cama del paciente
	 * @throws HabitacionNoValidaException
	 * @throws CamaOcupadaException
	 * @throws NombreNoValidoException
	 * @throws SexoNoValidoException
	 * @throws CamaNoValidaException
	 */
	public void annadir(String nombre, Sexo sexo, int habitacion, Cama cama) throws HabitacionNoValidaException,
			CamaOcupadaException, NombreNoValidoException, SexoNoValidoException, CamaNoValidaException {
		Paciente paciente = new Paciente(nombre, sexo, habitacion, cama);
		if (pacientes.contains(paciente)) {
			throw new CamaOcupadaException("\nLa cama ya est� ocupada");
		}
		pacientes.add(paciente);
	}

	/**
	 * Permite eliminar por identificador. Si el paciente es null, lanzar� una
	 * excepci�n.
	 * 
	 * @param ident
	 *            Identificador del paciente.
	 * @return paciente El paciente eliminado.
	 * @throws PacienteNoExisteException
	 */
	public Paciente eliminar(int ident) throws PacienteNoExisteException {
		Paciente paciente = getPaciente(ident);
		if (paciente == null) {
			throw new PacienteNoExisteException("\nEl paciente no existe en este hospital con ese identificador");
		}
		pacientes.remove(paciente);
		return paciente;
	}

	/**
	 * Permite obtener un paciente por id.
	 * 
	 * @param ident.
	 *            Identificador del paciente.
	 * @return paciente El paciente con un id igual al pasado, o null en otro caso.
	 *
	 */
	Paciente getPaciente(int ident) {
		for (Paciente paciente : pacientes) {
			if (paciente.getId() == ident)
				return paciente;
		}
		return null;
	}

	/**
	 * Permite realizar el cambio de cama de un paciente. Si la cama o la habitaci�n
	 * no son v�lidas, est�n ocupadas o el paciente no existe,lanzar� una excepci�n.
	 * 
	 * @param ident
	 *            Identificador del paciente.
	 * @param habitacion
	 *            Habitaci�n del paciente.
	 * @param cama
	 *            Cama del paciente.
	 * @throws PacienteNoExisteException
	 * @throws HabitacionNoValidaException
	 * @throws CamaNoValidaException
	 * @throws CamaOcupadaException
	 */
	public void cambioDeCama(int ident, int habitacion, Cama cama)
			throws PacienteNoExisteException, HabitacionNoValidaException, CamaNoValidaException, CamaOcupadaException {
		Paciente paciente = getPaciente(ident);
		if (paciente == null)
			throw new PacienteNoExisteException(
					"No puede realizarse el cambio de cama. El paciente con identificador " + ident + " no existe.");
		if (pacientes.contains(new Paciente(habitacion, cama)))
			throw new CamaOcupadaException("No puede realizarse el cambio de cama. La cama " + cama
					+ " de la habitaci�n " + habitacion + " ya est� ocupada.");
		paciente.setCama(cama);
		paciente.setHabitacion(habitacion);
	}

	/**
	 * Devuelve una lista con las camas ocupadas en el hospital.
	 * 
	 * @return camasOcupadas Lista con las camas ocupadas.
	 */
	public ArrayList<String> getCamasOcupadas() {
		ArrayList<String> camasOcupadas = new ArrayList<String>();
		Iterator<Paciente> iterator = pacientes.iterator();
		while (iterator.hasNext()) {
			Paciente paciente = iterator.next();
			camasOcupadas.add(paciente.getHabitacion() + "-" + paciente.getCama());
		}
		return camasOcupadas;
	}

	/**
	 * Comprueba si el hospital est� o no vac�o.
	 * 
	 * @return true o false si el hospital est� o no vac�o.
	 */
	public boolean vacio() {
		return pacientes.isEmpty();
	}

	@Override
	public String toString() {
		return NOMBRE + ", pacientes=" + pacientes;
	}
}