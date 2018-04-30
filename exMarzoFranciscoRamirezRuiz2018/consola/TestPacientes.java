package exMarzoFranciscoRamirezRuiz2018.consola;
/**
 * Test de hospital ( comunicación con el usuario)
 * @author Francisco Ramírez Ruiz, José María Romero Ruiz, Guillermo Boquizo
 *         Sánchez, Rafael Delgado Peña.
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
	 * Menú principal.
	 */
	private static Menu menuPrincipal = new Menu("Gestión de pacientes",
			new String[] { "Alta", "Baja", "Cambio cama/habitación", "Mostrar camas ocupadas" });

	/**
	 * Menú para elegir el sexo del paciente.
	 */
	private static Menu menuSexo = new Menu("Sexo del paciente", Sexo.generarOpcionesMenu());

	/**
	 * Menú para elegir la cama del paciente.
	 */
	private static Menu menuCama = new Menu("Elige una cama de la habitación", Cama.generarOpcionesMenu());

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
	 * Realiza la opción elegida del menú
	 * 
	 * @param opcion
	 *            Opción elegida
	 */
	private static void realizarOpcionMenu(int opcion) {
		if (opcion != menuPrincipal.getSalir() && opcion != 1 && hospital.vacio()) {
			System.err.println("\n\tHospital vacío.");
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
	 * Añade 5 personas predefinidas al hospital.
	 * 
	 * @throws HabitacionNoValidaException
	 * @throws CamaOcupadaException
	 */
	private static void cargarPredefinidos() throws HabitacionNoValidaException, CamaOcupadaException {
		try {
			hospital.annadir("María del Carmen Salmerón Gutiérrez", Sexo.MUJER, 345, Cama.A);
			hospital.annadir("Filemón Ojo", Sexo.HOMBRE, 760, Cama.D);
			hospital.annadir("Paco Pérez López", Sexo.HOMBRE, 760, Cama.A);
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
			System.err.println(e.getMessage() + ". No se ha podido añadir el paciente en el hospital");
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
	 * Recoge la habitación del paciente
	 * 
	 * @return Habitación del paciente
	 */
	private static int pedirHabitacion() {
		return Teclado.leerEntero("Número de habitación del paciente");
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
