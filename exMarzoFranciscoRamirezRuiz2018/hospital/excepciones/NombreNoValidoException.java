package exMarzoFranciscoRamirezRuiz2018.hospital.excepciones;

/**
 * Exception Nombre no valido
  * @author Francisco Ram�rez Ruiz, Jos� Mar�a Romero Ruiz, Guillermo Boquizo
 *         S�nchez, Rafael Delgado Pe�a.
 * @version 2.0
 *
 */
public class NombreNoValidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public NombreNoValidoException(String string) {
		super(string);
	}
}