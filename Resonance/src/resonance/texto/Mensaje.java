package resonance.texto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Mensaje implements Serializable{

	private String mensaje;
	private Date fecha;
	private ArrayList<Mensaje> links;
	private String idUser;

	/**
	 * Constructor de la clase mensaje
	 * 
	 * @param mensaje Mensaje a crear
	 * @param fecha   Fecha en la que el mensaje es creado
	 */
	public Mensaje(String mensaje, Date fecha, String idUser) {
		this.mensaje = mensaje;
		this.fecha = fecha;
         this.setIdUser(idUser);
		links = new ArrayList<Mensaje>();
	}

	/**
	 * Obntiene el mensaje
	 * 
	 * @return mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Modifica el mensaje
	 * 
	 * @param mensaje a modificar
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	} 

	/**
	 * Obtiene la fecha del mensaje
	 * 
	 * @return fecha del mensaje
	 */
	public Date getFecha() {
		return fecha;
	}

	public void conectar(Mensaje p) {
		links.add(p);
	}

	public Mensaje seguirEnlace() {
		if(links.isEmpty())
		{
			return null;
		}
		return links.get(0);
	}

	public void desconectar() {
		links.remove(0);
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

}
