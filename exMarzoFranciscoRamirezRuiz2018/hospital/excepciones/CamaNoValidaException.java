package exMarzoFranciscoRamirezRuiz2018.hospital.excepciones;

/**
 * Exception Cama no valida
 * @author Francisco Ram�rez Ruiz, Jos� Mar�a Romero Ruiz, Guillermo Boquizo
 *         S�nchez, Rafael Delgado Pe�a.
 * @version 2.0
 *
 */
public class CamaNoValidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public CamaNoValidaException(String string) {
		super(string);
	}
}