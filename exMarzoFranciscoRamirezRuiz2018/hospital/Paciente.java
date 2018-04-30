package exMarzoFranciscoRamirezRuiz2018.hospital;

import java.util.regex.Pattern;

import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.CamaNoValidaException;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.HabitacionNoValidaException;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.NombreNoValidoException;
import exMarzoFranciscoRamirezRuiz2018.hospital.excepciones.SexoNoValidoException;


/**
 * Clase Paciente
 * 
 * @author Francisco Ramírez Ruiz, José María Romero Ruiz, Guillermo Boquizo
 *         Sánchez, Rafael Delgado Peña.
 * @version 2.0
 *
 */
public class Paciente {

	/**
	 * Campo contador, establece un contador para la id autoincrementable.
	 */
	private static int contador = 1;
	
	/**
	 * Campo id, el identificador del paciente.
	 */
	private int id;
	
	/**
	 * Campo nombre, el nombre del paciente.
	 */
	private String nombre;
	
	/**
	 * Campo sexo, el sexo del paciente.
	 */
	private Sexo sexo;
	
	/**
	 * Campo habitación, la habitación del paciente.
	 */
	private int habitacion;
	
	/**
	 * Campo cama, la cama del paciente.
	 */
	private Cama cama;
	
	/**
	 * Campo REGEX_NOMBRE_APELLIDOS, una expresión regular para el nombre.
	 */
	private static final String REGEX_NOMBRE_APELLIDOS = "(?i)^DESCONOCIDO|([a-záéíóúñÁÉÍÓÚÑ]{3,}(\\s[a-záéíóúñÁÉÍÓÚÑ]{3,})+)$";
	
	/**
	 * Campo PATRON_NOMBRE_APELLIDOS, compila un patrón a partir del campo REGEX_NOMBRE_APELLIDOS.
	 */
	private static final Pattern PATRON_NOMBRE_APELLIDOS = Pattern.compile(REGEX_NOMBRE_APELLIDOS);
	
	/**
	 * Constructor del paciente. Lanza excepciones si alguno de sus parámetros no es correcto.
	 * @param nombre Nombre del paciente.
	 * @param sexo Sexo del paciente.
	 * @param habitacion Habitación del paciente.
	 * @param cama Cama del paciente.
	 * @throws HabitacionNoValidaException
	 * @throws NombreNoValidoException
	 * @throws SexoNoValidoException
	 * @throws CamaNoValidaException
	 */
	Paciente(String nombre, Sexo sexo, int habitacion, Cama cama)
			throws HabitacionNoValidaException, NombreNoValidoException, SexoNoValidoException, CamaNoValidaException {
		setNombre(nombre);
		setSexo(sexo);
		setHabitacion(habitacion);
		setCama(cama);
		setId();
	}
	
	/**
	 * Constructor sobrecargado para el control de cama y alta en el alta del paciente.
	 * Arroja excepciones si sus atributos no son válidos.
	 * @param habitacion La habitación del paciente.
	 * @param cama La cama del paciente.
	 * @throws HabitacionNoValidaException
	 * @throws CamaNoValidaException
	 */
	Paciente(int habitacion, Cama cama) throws HabitacionNoValidaException, CamaNoValidaException {
		setHabitacion(habitacion);
		setCama(cama);
	}
	
	/**
	 * Método para obtener el id.
	 * @return id el id a establecer.
	 */
	int getId() {
		return id;
	}
	
	/**
	 * Método para establecer el id, incrementado en cada establecimiento.
	 */
	private void setId() {
		this.id = contador++;
	}

	String getNombre() {
		return nombre;
	}
	
	/**
	 * Establece el nombre. Si no es válido, arroja una excepción.
	 * @param nombre nombre a establecer.
	 * @throws NombreNoValidoException
	 */
	private void setNombre(String nombre) throws NombreNoValidoException {
		if (!esValido(nombre))
			throw new NombreNoValidoException("\n\tNombre no válido");
		this.nombre = nombre;
	}
	
	/**
	 * Método que comprueba si el nombre se ajusta a un patrón predefinido.
	 * @param nombre El nombre a comprobar.
	 * @return true si se adapta el nombre al patrón, false en caso contrario.
	 */
	private boolean esValido(String nombre) {
		return PATRON_NOMBRE_APELLIDOS.matcher(nombre).matches();
	}
	
	/**
	 * Permite obtener el sexo.
	 * @return sexo El sexo obtenido.
	 */
	Sexo getSexo() {
		return sexo;
	}
	
	/**
	 * Permite establecer el sexo. Si el sexo es null, arroja una excepción.
	 * @param sexo El sexo a establecer.
	 * @throws SexoNoValidoException
	 */
	private void setSexo(Sexo sexo) throws SexoNoValidoException {
		if (sexo == null)
			throw new SexoNoValidoException("\n\tSexo no válido");
		this.sexo = sexo;
	}
	
	/**
	 * Permite obtener la habitación.
	 * @return habitacion Habitación obtenida.
	 */
	int getHabitacion() {
		return habitacion;
	}
	
	/**
	 * Permite establecer la habitación. Si la habitación es 0 o negativa, arroja una excepción.
	 * @param habitacion La habitación a establecer.
	 * @throws HabitacionNoValidaException
	 */
	void setHabitacion(int habitacion) throws HabitacionNoValidaException {
		if (habitacion <= 0)
			throw new HabitacionNoValidaException("\n\tHabitación no válida");
		this.habitacion = habitacion;
	}

	/**
	 * Permite obtener la cama.
	 * @return cama La cama obtenida.
	 */
	Cama getCama() {
		return cama;
	}
	
	/**
	 * Permite establecer la cama.Si la cama es null, arroja una excepción.
	 * @param cama La cama a establecer.
	 * @throws CamaNoValidaException
	 */
	void setCama(Cama cama) throws CamaNoValidaException {
		if(cama == null)
			throw new CamaNoValidaException("\n\tCama no válida");
		this.cama = cama;
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\n\t[id=" + id + ", " + sexo + " " + habitacion + "-" + cama + ", nombre=" + nombre + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cama == null) ? 0 : cama.hashCode());
		result = prime * result + habitacion;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Paciente))
			return false;
		Paciente other = (Paciente) obj;
		if (cama != other.cama)
			return false;
		if (habitacion != other.habitacion)
			return false;
		return true;
	}	
	
}