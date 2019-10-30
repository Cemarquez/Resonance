package resonance.usuario;

import java.util.ArrayList;

import resonance.estructura.ListaChats;
import resonance.estructura.ListaPublicaciones;
import resonance.excepciones.LimitException;
import resonance.texto.Publicacion;
import resonance.usuario.Relacion.TipoRelacion;

public class Usuario {

	private String id;
	private ArrayList<Relacion> relaciones;
	private int limiteAmigos;
	private Perfil perfil;
	private ListaChats chats;
	private boolean admin = false;
	private ListaPublicaciones publicaciones;
	// Fotos

	/**
	 * Metodo constructor
	 * 
	 * @param nombre
	 * @param perfil
	 */
	public Usuario(String nombre, Perfil perfil) {
		this.setPerfil(perfil);
		this.id = nombre;
		publicaciones = new ListaPublicaciones();
		chats = new ListaChats();
		relaciones = new ArrayList<Relacion>();
		limiteAmigos = 0;
		relaciones.add(null);
	}

	/**
	 * Metodo que verifica si hay dos usuarios relacionados
	 * 
	 * @param nombre
	 * @return
	 */
	public boolean estaRelacionado(String nombre) {

		for (Relacion r : relaciones) {
			if (r.getUsuario().getID().equals(nombre)) {
				return true;
			}
		}

		return false;
	}

	public void setLimiteAmigos(int limiteAmigos) {
		this.limiteAmigos = limiteAmigos;
	}

	/**
	 * Metodo que permite conectar usuarios
	 * 
	 * @param destino
	 * @param relacion
	 * @throws LimitException
	 */
	public void determinarRelacion(Usuario destino, TipoRelacion relacion) throws LimitException {

		if (modificarConexion(destino, relacion)) {
			return;
		}
		if (relacion == TipoRelacion.AMIGOS) {
			if (getAmigos().size() > limiteAmigos && limiteAmigos != 0) {
				throw new LimitException("Excedes el número de amigos permitidos por el administrador.");
			} else {
				relaciones.add(new Relacion(relacion, destino));
			}
		} else {
			relaciones.add(new Relacion(relacion, destino));
		}

	}

	/**
	 * Metodo que obtiene los amigos de una persona
	 * 
	 * @return
	 */
	public ArrayList<Usuario> getAmigos() {
		ArrayList<Usuario> amigos = new ArrayList<Usuario>();
		for (Relacion r : relaciones) {
			if (r.getTipo() == TipoRelacion.AMIGOS) {
				amigos.add(r.getUsuario());
			}
		}
		return amigos;
	}

	/**
	 * Metodo que permite modificar una relacion ya existente
	 * 
	 * @param usuario
	 * @param relacion
	 * @return
	 */
	public boolean modificarConexion(Usuario usuario, TipoRelacion relacion) {
		for (Relacion r : relaciones) {
			if (r.getUsuario() == usuario) {
				r.setTipo(relacion);
				return true;
			}
		}

		return false;

	}

	/**
	 * Metodo que elimina todo tipo de relacion con una persona.
	 * 
	 * @param usuario
	 * @return
	 */
	public boolean eliminarRelacion(Usuario usuario) {

		for (Relacion r : relaciones) {
			if (r.getUsuario() == usuario) {
				relaciones.remove(r);
				return true;
			}
		}

		return false;
	}

	/**
	 * Metodo que obtiene la lista de publicaciones que puede ver una persona
	 * 
	 * @param user
	 * @return
	 */
	public ListaPublicaciones getPublicaciones(String user) {
		ListaPublicaciones lista = new ListaPublicaciones();

		if (isAmigo(user)) {
			return publicaciones;
		}

		return lista;
	}

	/**
	 * Metodo que permite agregar una publicacion
	 * 
	 * @param p
	 */
	public void agregarPublicacion(Publicacion p) {
		publicaciones.agregar(p);
	}

	/**
	 * Metodo que permite eliminar una publicacion
	 * 
	 * @param p
	 */
	public void eliminarPublicacion(Publicacion p) {
		publicaciones.eliminar(p);
	}

	/**
	 * Metodo que permite verificar que el usuario ingresado sea amigo
	 * 
	 * @param user
	 * @return
	 */
	public boolean isAmigo(String user) {
		for (Relacion r : relaciones) {
			if (id.equals(user)) {
				if (r.isAmigo()) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Metodo que permite seguir la relacion de un usuario en un indice dado
	 * 
	 * @param indice
	 * @return
	 */
	public Relacion seguirRelacion(int indice) {
		return relaciones.get(indice);
	}

	// Getters and setters

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public ListaChats getChats() {
		return chats;
	}

	public boolean isAdmin() {
		return admin;
	}

	public String getID() {
		return id;
	}

	public int getNumRelaciones() {
		return relaciones.size();
	}

	public int getLimiteAmigos() {
		return limiteAmigos;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
