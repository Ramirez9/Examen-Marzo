package exMarzoFranciscoRamirezRuiz2018.hospital.excepciones;

/**
 * Exception Cama ocupada
 * @author Francisco Ramírez Ruiz, José María Romero Ruiz, Guillermo Boquizo
 *         Sánchez, Rafael Delgado Peña.
 * @version 2.0
 *
 */
public class CamaOcupadaException extends Exception {

	private static final long serialVersionUID = 1L;

	public CamaOcupadaException(String string) {
		super(string);
	}

}
