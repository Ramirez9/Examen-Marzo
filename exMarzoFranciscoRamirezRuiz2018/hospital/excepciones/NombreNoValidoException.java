package exMarzoFranciscoRamirezRuiz2018.hospital.excepciones;

/**
 * Exception Nombre no valido
  * @author Francisco Ramírez Ruiz, José María Romero Ruiz, Guillermo Boquizo
 *         Sánchez, Rafael Delgado Peña.
 * @version 2.0
 *
 */
public class NombreNoValidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public NombreNoValidoException(String string) {
		super(string);
	}
}