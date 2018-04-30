package exMarzoFranciscoRamirezRuiz2018.consola;
/**
 * Test de hospital ( comunicaci�n con el usuario)
 * @author Francisco Ram�rez Ruiz, Jos� Mar�a Romero Ruiz, Guillermo Boquizo
 *         S�nchez, Rafael Delgado Pe�a.
 * @version 2.0
 */
import exMarzoFranciscoRamirezRuiz2018.hospital.Cama;
import exMarzoFranciscoRamirezRuiz2018.hospital.Hospital;
import exMarzoFranciscoRamirezRuiz2018.hospital.Sexo;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.CamaNoValidaException;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.CamaOcupadaException;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.HabitacionNoValidaException;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.NombreNoValidoException;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.PacienteNoExisteException;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.SexoNoValidoException;
import utiles.Menu;
import utiles.Teclado;

public class TestPacientes {
	/**
	 * Constante para el nombre en caso de que sea desconocido.
	 */
	private static final String DESCONOCIDO = "DESCONOCIDO";

	/**
	 * Men� principal.
	 */
	private static Menu menuPrincipal = new Menu("Gesti�n de pacientes",
			new String[] { "Alta", "Baja", "Cambio cama/habitaci�n", "Mostrar camas ocupadas" });

	/**
	 * Men� para elegir el sexo del paciente.
	 */
	private static Menu menuSexo = new Menu("Sexo del paciente", Sexo.generarOpcionesMenu());

	/**
	 * Men� para elegir la cama del paciente.
	 */
	private static Menu menuCama = new Menu("Elige una cama de la habitaci�n", Cama.generarOpcionesMenu());

	/**
	 * Envoltorio de hospital empleado en el test.
	 */
	private static Hospital hospital = new Hospital();

	public static void main(String[] args) {

		try {
			cargarPredefinidos();
			mostrar();
		} catch (HabitacionNoValidaException | CamaOcupadaException e) {
			System.err.println(e.getMessage());
		}

		int opcion;
		do {
			opcion = menuPrincipal.gestionar();
			realizarOpcionMenu(opcion);
		} while (opcion != menuPrincipal.getSalir());
	}

	/**
	 * Realiza la opci�n elegida del men�
	 * 
	 * @param opcion
	 *            Opci�n elegida
	 */
	private static void realizarOpcionMenu(int opcion) {
		if (opcion != menuPrincipal.getSalir() && opcion != 1 && hospital.vacio()) {
			System.err.println("\n\tHospital vac�o.");
			return;
		}
		switch (opcion) {
		case 1:
			alta();
			break;
		case 2:
			baja();
			break;
		case 3:
			cambiarCama();
			break;
		case 4:
			mostrarCamas();
			break;
		default:
			salir();
			break;
		}
	}

	/**
	 * A�ade 5 personas predefinidas al hospital.
	 * 
	 * @throws HabitacionNoValidaException
	 * @throws CamaOcupadaException
	 */
	private static void cargarPredefinidos() throws HabitacionNoValidaException, CamaOcupadaException {
		try {
			hospital.annadir("Mar�a del Carmen Salmer�n Guti�rrez", Sexo.MUJER, 345, Cama.A);
			hospital.annadir("Filem�n Ojo", Sexo.HOMBRE, 760, Cama.D);
			hospital.annadir("Paco P�rez L�pez", Sexo.HOMBRE, 760, Cama.A);
			hospital.annadir("John Smith", Sexo.HOMBRE, 666, Cama.D);
			hospital.annadir(DESCONOCIDO, Sexo.HOMBRE, 667, Cama.B);
		} catch (NombreNoValidoException | SexoNoValidoException | CamaNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Muestra los pacientes del hospital.
	 */
	private static void mostrar() {
		System.out.println(hospital);
	}

	/**
	 * Da de alta un paciente nuevo.
	 */
	private static void alta() {
		try {
			hospital.annadir(pedirNombre(), pedirSexo(), pedirHabitacion(), pedirCama());
			mostrar();
		} catch (HabitacionNoValidaException | CamaOcupadaException | NombreNoValidoException | SexoNoValidoException
				| CamaNoValidaException e) {
			System.err.println(e.getMessage() + ". No se ha podido a�adir el paciente en el hospital");
		}
	}

	/**
	 * Da de baja un paciente
	 */
	private static void baja() {
		try {
			System.out.println("Paciente de baja en el hospital:" + hospital.eliminar(pedirId()));
			mostrar();
		} catch (PacienteNoExisteException e) {
			System.err.println(e.getMessage() + " No se ha podido dar de baja al paciente");
		}
	}

	/**
	 * Cambia la cama del paciente.
	 */
	private static void cambiarCama() {
		try {
			hospital.cambioDeCama(pedirId(), pedirHabitacion(), pedirCama());
			mostrar();
		} catch (PacienteNoExisteException | HabitacionNoValidaException | CamaNoValidaException
				| CamaOcupadaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Muestra las camas ocupadas.
	 */
	private static void mostrarCamas() {
		System.out.println(hospital.getCamasOcupadas() + "\n");
	}

	/**
	 * Recoge la id del paciente.
	 * 
	 * @return id pedido por teclado.
	 */
	private static int pedirId() {
		return Teclado.leerEntero("Introduce el identificador del paciente: ");
	}

	/**
	 * Recoge el nombre del paciente
	 * 
	 * @return Nombre del paciente
	 */
	private static String pedirNombre() {
		return Teclado.leerCadena("Nombre y apellidos del paciente");
	}

	/**
	 * Recoge la habitaci�n del paciente
	 * 
	 * @return Habitaci�n del paciente
	 */
	private static int pedirHabitacion() {
		return Teclado.leerEntero("N�mero de habitaci�n del paciente");
	}

	/**
	 * Recoge el sexo del paciente
	 * 
	 * @return Sexo del paciente
	 */
	private static Sexo pedirSexo() {
		int opcion = menuSexo.gestionar();
		Sexo[] sexo = Sexo.values();
		if (opcion == sexo.length + 1)
			return null;
		return sexo[opcion - 1];
	}

	/**
	 * Recoge la cama del paciente
	 * 
	 * @return Cama del paciente
	 */
	private static Cama pedirCama() {
		int opcion = menuCama.gestionar();
		Cama[] camas = Cama.values();
		if (opcion == camas.length + 1)
			return null;
		return camas[opcion - 1];
	}
	private static void salir() {
		System.out.println("Hasta pronto");
	}
}
