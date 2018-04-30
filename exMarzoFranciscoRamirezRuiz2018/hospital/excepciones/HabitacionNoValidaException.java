package exMarzoFranciscoRamirezRuiz2018.hospital.excepciones;

/**
 * Exception Habitacion no valida
 * 
 * @author Francisco Ramírez Ruiz, José María Romero Ruiz, Guillermo Boquizo
 *         Sánchez, Rafael Delgado Peña.
 * @version 2.0
 */
public class HabitacionNoValidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public HabitacionNoValidaException(String string) {
		super(string);
	}
}
