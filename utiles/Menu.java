package utiles;

/**
 * Clase utilizada para la gesti�n de un men�. Se dedica a:
 * 
 * <li>Mostrar las opciones del men�
 * 
 * <li>Recoger y devolver las opciones de un men�;
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
	 *            t�tulo del men�
	 * @param opciones
	 *            opciones del men�
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
	 * Gestiona el men�. Consiste en mostrar las opcines y recoger la opci�n
	 * seleccionada por el usuario
	 * 
	 * @return opci�n v�lida del men�
	 */
	public int gestionar() {
		mostrar();
		return recogerOpcion();
	}

	/**
	 * Muestra las opciones del men�
	 */
	private void mostrar() {
		int i = 1;
		System.out.println("**" + titulo);
		for (String elemento : opciones)
			System.out.println("(" + (i++) + ") " + elemento);
	}

	/**
	 * Recoge la opci�n v�lida del men�
	 * 
	 * @return opci�n v�lida
	 */
	private int recogerOpcion() {
		int opcion;
		do {
			opcion = Teclado.leerEntero("Introduce una opci�n v�lida: ");
		} while (opcion < 1 || opcion > numOpciones);
		return opcion;
	}

	public int getSalir() {
		return opciones.length;
	}

}