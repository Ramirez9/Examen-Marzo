package exMarzoFranciscoRamirezRuiz2018.hospital;

/**
 * Enumeraci�n de las camas
 * 
 * @author Francisco Ram�rez Ruiz, Jos� Mar�a Romero Ruiz, Guillermo Boquizo
 *         S�nchez, Rafael Delgado Pe�a.
 * @version 2.0
 *
 */
public enum Cama {
	
	/**
	 * Cama A
	 */
	A,
	
	/**
	 * Cama B
	 */
	B,
	
	/**
	 * Cama C
	 */
	C,
	
	/**
	 * Cama D
	 */
	D;
	
	/**
	 * Genera las opciones para un men� de camas.
	 * @return opcionesMenu las opciones del men� de camas.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[values().length];
		int i = 0;
		for (Cama cama : Cama.values()) {
			opcionesMenu[i++] = cama.name();
		}
		return opcionesMenu;
	}
}
