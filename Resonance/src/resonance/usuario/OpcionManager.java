package resonance.usuario;

import java.io.Serializable;
import java.util.HashMap;

public class OpcionManager implements Serializable {

	private HashMap<String, Opcion> opciones;

	/**
	 * Metodo constructor de la clase.
	 */
	public OpcionManager() {
		opciones = new HashMap<String, Opcion>();
	}

	/**
	 * Metodo que permite añadir una opcion al panel de opciones disponibles.
	 * 
	 * @param nombre      Nombre de la opcion.
	 * @param descripcion Breve descripcion de la opcion.
	 * @param activo      Estado inicial de la opcion.
	 */
	public void anadirOpcion(String nombre, String descripcion, boolean activo) {
		opciones.put(nombre, new Opcion(nombre, descripcion, activo));
	}

	/**
	 * Metodo que permite comprobar si una opcion se encuentra activa.
	 * 
	 * @param nombre Nombre de la opciona revisar.
	 * @return
	 */
	public boolean isActivo(String nombre) {
		if (opciones.get(nombre) != null) {
			return opciones.get(nombre).isActivo();
		}

		return false;
	}

	/**
	 * Metodo que desactiva la opcion ingresada.
	 * 
	 * @param nombre Nombre de al opcion a desactivar.
	 * @return
	 */
	public boolean desactivarOpcion(String nombre) {
		if (opciones.get(nombre) != null) {
			opciones.get(nombre).setActivo(false);
			return true;
		}

		return false;
	}

	/**
	 * Metodo que activa la opcion ingresada.
	 * 
	 * @param nombre Nombre de la opcion a activar.
	 * @return
	 */
	public boolean activarOpcion(String nombre) {
		if (opciones.get(nombre) != null) {
			opciones.get(nombre).setActivo(true);
			return true;
		}

		return false;
	}
}
