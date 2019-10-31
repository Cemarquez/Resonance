package resonance.usuario;

import java.io.Serializable;

public class Opcion implements Serializable{

	private String nombre;
	private String descripcion;
	private boolean activo;

	/**
	 * Metodo constructor de la clase.
	 * 
	 * @param nombre      Nombre de la opcion.
	 * @param descripcion Breve descripcion de la opcion.
	 * @param activo      Estado inicial de la opcion.
	 */
	public Opcion(String nombre, String descripcion, boolean activo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	// Getters and setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
