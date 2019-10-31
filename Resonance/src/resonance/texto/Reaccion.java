package resonance.texto;

import java.io.Serializable;

import resonance.usuario.Usuario;

public class Reaccion implements Serializable {

	private Usuario usuario;
	private TipoReaccion tipoReaccion;
	
	
	
	/**
	 * Metodo constructor
	 * @param usuario
	 * @param tipo
	 */
	public Reaccion(Usuario usuario, TipoReaccion tipo)
	{
		this.usuario = usuario;
		this.tipoReaccion = tipo;
	}
	
	
	/**
	 * Enumeracion de reacciones
	 */
	public enum TipoReaccion {
		INFORMATIVO, MEGUSTA, NOMEGUSTA, DIVERTIDO, UTIL, OPTIMISTA, CREATIVO
	}



	
	
	//Getters and setters
	


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoReaccion getTipoReaccion() {
		return tipoReaccion;
	}

	public void setTipoReaccion(TipoReaccion tipoReaccion) {
		this.tipoReaccion = tipoReaccion;
	}
	
	
}




