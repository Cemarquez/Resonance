package resonance.texto;

import java.util.ArrayList;

import resonance.estructura.ListaMensajes;
import resonance.usuario.Usuario;

public class Chat {

	private ListaMensajes mensajes;
	private Usuario usuario;
	private ArrayList<Chat> links;

	public Chat(Usuario usuario) {
		this.mensajes = new ListaMensajes();
		this.usuario = usuario;
		links = new ArrayList<Chat>();

	}

	/**
	 * Metodo que elimina mensaje del chat
	 * 
	 * @param mensaje
	 * @return
	 */

	public boolean eliminarMensaje(Mensaje mensaje) {

		return mensajes.eliminar(mensaje);
	}

	public void conectar(Chat p) {
		links.set(0, p);
	}

	public Chat seguirEnlace() {
		return links.get(0);
	}

	public void desconectar() {
		links.remove(0);
	}

	/**
	 * Metodo que agrega mensaje al chat
	 * 
	 * @param mensaje
	 */
	public void anadirMensaje(Mensaje mensaje) {

		mensajes.agregar(mensaje);

	}

	// Getters y Setters

	public ListaMensajes getMensajes() {
		return mensajes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
