package resonance.texto;

import java.io.Serializable;

import resonance.usuario.Usuario;

public class Reaccion implements Serializable {

	private String idUser;
	private TipoReaccion tipoReaccion;
	
	
	
	/**
	 * Metodo constructor
	 * @param usuario
	 * @param tipo
	 */
	public Reaccion(String usuario, TipoReaccion tipo)
	{
		this.setIdUser(usuario);
		this.tipoReaccion = tipo;
	}
	
	
	/**
	 * Enumeracion de reacciones
	 */
	public enum TipoReaccion {
		INFORMATIVO, MEGUSTA, NOMEGUSTA, DIVERTIDO, UTIL, OPTIMISTA, CREATIVO
	}



	
	
	//Getters and setters
	




	public TipoReaccion getTipoReaccion() {
		return tipoReaccion;
	}

	public void setTipoReaccion(TipoReaccion tipoReaccion) {
		this.tipoReaccion = tipoReaccion;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	
}




