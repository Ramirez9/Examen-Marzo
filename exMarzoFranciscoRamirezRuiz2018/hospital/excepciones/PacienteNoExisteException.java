package exMarzoFranciscoRamirezRuiz2018.hospital.excepciones;

/**
 * Exception Paciente no existe
 * @author Francisco Ramírez Ruiz, José María Romero Ruiz, Guillermo Boquizo
 *         Sánchez, Rafael Delgado Peña.
 * @version 2.0
 *
 */
public class PacienteNoExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public PacienteNoExisteException(String string) {
		super(string);
	}
}