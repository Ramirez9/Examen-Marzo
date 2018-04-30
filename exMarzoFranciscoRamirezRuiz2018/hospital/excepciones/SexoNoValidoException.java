package exMarzoFranciscoRamirezRuiz2018.hospital.excepciones;
/**
 * Enumeracion sexo no valido
 * @author Francisco Ramírez Ruiz, José María Romero Ruiz, Guillermo Boquizo
 *         Sánchez, Rafael Delgado Peña.
 * @version 2.0
 *
 */
public class SexoNoValidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public SexoNoValidoException(String string) {
		super(string);
	}
}