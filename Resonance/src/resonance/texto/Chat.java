package resonance.texto;

import java.util.ArrayList;
import java.util.List;

import resonance.usuario.Usuario;

public class Chat {

	private List<Mensaje> mensajes; 
	private Usuario usuario;
	
	public Chat(List<Mensaje> mensajes, Usuario usuario) {
		this.mensajes = mensajes;
		this.usuario = usuario;
		mensajes = new ArrayList<Mensaje>();
	}
	
	
	
	
	
	
	
	
	/**
	 *  Metodo que elimina mensaje del chat
	 * @param mensaje
	 * @return
	 */
	
	public boolean eliminarMensaje(Mensaje mensaje) {
		
		
		for(Mensaje m : mensajes)
		{
			if(m.getMensaje().equals(mensaje.getMensaje()) && m.getFecha().compareTo(mensaje.getFecha())==0 ) {
				
				mensajes.remove(mensaje);
				
				return true;
				
			}
		}
		
		
		return false;
		
		
		
		
	}
	
	/**
	 * Metodo que agrega mensaje al chat
	 * @param mensaje
	 */
	public void anadirMensaje (Mensaje mensaje) {
		
		mensajes.add(mensaje);
		
		
	}
	
	
	
	// Getters y Setters


	public List<Mensaje> getMensajes() {
		return mensajes;
	}
	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
