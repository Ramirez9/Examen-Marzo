package exMarzoFranciscoRamirezRuiz2018.hospital;


/**
 * Enumeracion del sexo 
 * 
 * @author Francisco Ramírez Ruiz, José María Romero Ruiz, Guillermo Boquizo
 *         Sánchez, Rafael Delgado Peña.
 * @version 2.0
 *
 */
public enum Sexo {
	/**
	 * Sexo hombre
	 */
	HOMBRE,
	/**
	 * Sexo mujer
	 */
	MUJER;
	
	/**
	 * Genera las opciones para un menú de sexos.
	 * @return opcionesMenu las opciones para el menú.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[values().length];
		int i = 0;
		for (Sexo sexo : Sexo.values()) {
			opcionesMenu[i++] = sexo.name();
		}
		return opcionesMenu;
	}
}