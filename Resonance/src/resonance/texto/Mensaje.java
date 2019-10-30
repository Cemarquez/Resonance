package resonance.texto;

import java.util.ArrayList;
import java.util.Date;

public class Mensaje {

	private String mensaje;
	private Date fecha;
	private ArrayList<Mensaje> links;
	// foto
	// stickers

	/**
	 * Constructor de la clase mensaje
	 * 
	 * @param mensaje Mensaje a crear
	 * @param fecha   Fecha en la que el mensaje es creado
	 */
	public Mensaje(String mensaje, Date fecha) {
		this.mensaje = mensaje;
		this.fecha = fecha;

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
		links.set(0, p);
	}

	public Mensaje seguirEnlace() {
		return links.get(0);
	}

	public void desconectar() {
		links.remove(0);
	}

}
