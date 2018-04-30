package utiles;

/**
 * Clase utilizada para la gestión de un menú. Se dedica a:
 * 
 * <li>Mostrar las opciones del menú
 * 
 * <li>Recoger y devolver las opciones de un menú;
 * 
 * @author mlmagarinc
 * 
 */
public class Menu {
	String titulo;
	String opciones[];
	int numOpciones;

	/**
	 * 
	 * @param titulo
	 *            título del menú
	 * @param opciones
	 *            opciones del menú
	 */
	public Menu(String titulo, String[] opciones) {
		this.titulo = titulo;
		setOpciones(opciones);
		this.numOpciones = this.opciones.length;
	}

	private void setOpciones(String[] opciones) {
		String[] array = new String[opciones.length + 1];
		int i = 0;
		for (String string : opciones) {
			array[i++] = string;
		}
		array[i] = "Salir";
		this.opciones= array;
	}

	/**
	 * Gestiona el menú. Consiste en mostrar las opcines y recoger la opción
	 * seleccionada por el usuario
	 * 
	 * @return opción válida del menú
	 */
	public int gestionar() {
		mostrar();
		return recogerOpcion();
	}

	/**
	 * Muestra las opciones del menú
	 */
	private void mostrar() {
		int i = 1;
		System.out.println("**" + titulo);
		for (String elemento : opciones)
			System.out.println("(" + (i++) + ") " + elemento);
	}

	/**
	 * Recoge la opción válida del menú
	 * 
	 * @return opción válida
	 */
	private int recogerOpcion() {
		int opcion;
		do {
			opcion = Teclado.leerEntero("Introduce una opción válida: ");
		} while (opcion < 1 || opcion > numOpciones);
		return opcion;
	}

	public int getSalir() {
		return opciones.length;
	}

}