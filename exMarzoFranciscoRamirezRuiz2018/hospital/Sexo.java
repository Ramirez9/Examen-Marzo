package exMarzoFranciscoRamirezRuiz2018.hospital;


/**
 * Enumeracion del sexo 
 * 
 * @author Francisco Ram�rez Ruiz, Jos� Mar�a Romero Ruiz, Guillermo Boquizo
 *         S�nchez, Rafael Delgado Pe�a.
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
	 * Genera las opciones para un men� de sexos.
	 * @return opcionesMenu las opciones para el men�.
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