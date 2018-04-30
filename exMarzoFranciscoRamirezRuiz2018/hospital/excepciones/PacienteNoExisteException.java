package exMarzoFranciscoRamirezRuiz2018.hospital.excepciones;

/**
 * Exception Paciente no existe
 * @author Francisco Ram�rez Ruiz, Jos� Mar�a Romero Ruiz, Guillermo Boquizo
 *         S�nchez, Rafael Delgado Pe�a.
 * @version 2.0
 *
 */
public class PacienteNoExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public PacienteNoExisteException(String string) {
		super(string);
	}
}