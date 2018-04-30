package exMarzoFranciscoRamirezRuiz2018.hospital;

/**
 * Enumeración de las camas
 * 
 * @author Francisco Ramírez Ruiz, José María Romero Ruiz, Guillermo Boquizo
 *         Sánchez, Rafael Delgado Peña.
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
	 * Genera las opciones para un menú de camas.
	 * @return opcionesMenu las opciones del menú de camas.
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
