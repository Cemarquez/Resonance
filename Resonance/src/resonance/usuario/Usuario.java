package resonance.usuario;

import java.io.Serializable;
import java.util.ArrayList;

import resonance.estructura.ListaChats;
import resonance.estructura.ListaPublicaciones;
import resonance.excepciones.LimitException;
import resonance.texto.Chat;
import resonance.texto.Publicacion;
import resonance.usuario.Relacion.TipoRelacion;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario instance;
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
		this.instance = this;
		this.setPerfil(perfil);
		this.id = nombre;
		publicaciones = new ListaPublicaciones();
		chats = new ListaChats();
		relaciones = new ArrayList<Relacion>();
		limiteAmigos = 0;
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
				throw new LimitException("Excedes el nï¿½mero de amigos permitidos por el administrador.");
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
			if (r.getUsuario().getID().equals(usuario.getID())) {
				if ((r.getTipo() != TipoRelacion.BLOQUEADO)) {

					r.setTipo(relacion);

				}
				return true;
			}
		}

		return false;

	}

	public Chat getChat(String user) {

		ArrayList<Chat> chats = covertirArrayList(getChats());

		Chat chatEncontrado = null;

		System.out.println(chats.size());
		for (int i = 0; i < chats.size(); i++) {

			if (chats.get(i).getUsuario().getID().equals(user)) {
				chatEncontrado = chats.get(i);
				System.out.println("chat encontrado");
			}

		}
		return chatEncontrado;
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
	public ListaPublicaciones getPublicaciones() {

			return publicaciones;
	}

	public void crearChat(Usuario user) {
		chats.agregar(new Chat(user));
	}

	/**
	 * Metodo que obtiene las publicaciones que se mostraran en el menu inicial.
	 * 
	 * @return
	 */
	public ListaPublicaciones obtenerPublicacionesInicio() {
		ListaPublicaciones lista = new ListaPublicaciones();
		for (int i = 0; i<getAmigos().size(); i++) 
		{
			Usuario u = getAmigos().get(i);
			
			for (int j = 0; j < u.getPublicaciones().getLongitud(); j++) 
			{
				Publicacion p = u.getPublicaciones().getPublicacion(j);
				lista.agregar(p);
			}
		}

		for (int i = 0; i < publicaciones.getLongitud(); i++) {
			Publicacion p = publicaciones.getPublicacion(i);
			lista.agregar(p);
		}

		lista = ordenarPorFecha(covertirArrayList(lista));

		return lista;
	}

	/**
	 * Metodo que ordena una lista sencilla de publicaciones por fecha.
	 * 
	 * @param lista
	 * @return
	 */
	public ListaPublicaciones ordenarPorFecha(ArrayList<Publicacion> A) {
		ListaPublicaciones listaR = new ListaPublicaciones();

		Publicacion aux;
		for (int i = 1; i <= A.size(); i++) {
			for (int j = 0; j < A.size() - i; j++) {
				if (A.get(j).getFecha().compareTo(A.get(j + 1).getFecha()) > 0) {
					aux = A.get(j);
					A.set(j, A.get(j + 1));
					A.set(j + 1, aux);
				}
			}
		}

//		int i = A.size()-1;i>=0;i++
		for (Publicacion p : A) {
			listaR.agregar(p);
		}
		return listaR;
	}

	public static ArrayList<String> ordenar(ArrayList<String> A) {
		ArrayList<String> array = new ArrayList<String>();
		String aux;
		for (int i = 1; i <= A.size(); i++) {
			for (int j = 0; j < A.size() - i; j++) {
				if (A.get(j).compareTo(A.get(j + 1)) > 0) {
					aux = A.get(j);
					A.set(j, A.get(j + 1));
					A.set(j + 1, aux);
				}
			}
		}

		return A;
	}

	public ArrayList<Usuario> obtenerSolicitudesPendientes() {

		ArrayList<Usuario> listaSolicitudes = new ArrayList<Usuario>();

		for (int i = 0; i < relaciones.size(); i++) {

			if (relaciones.get(i).getTipo() == TipoRelacion.PENDIENTE) {

				listaSolicitudes.add(relaciones.get(i).getUsuario());
			}
		}

		return listaSolicitudes;

	}

	/**
	 * Metodo que convierte una lista sencilla en un ArrayList
	 * 
	 * @param lista
	 * @return
	 */
	public ArrayList<Publicacion> covertirArrayList(ListaPublicaciones lista) {
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		for (int i = 0; i < lista.getLongitud(); i++) {
			Publicacion p = lista.getPublicacion(i);
			publicaciones.add(p);
		}

		return publicaciones;
	}

	/**
	 * Metodo que convierte una lista sencilla en un ArrayList
	 * 
	 * @param lista
	 * @return
	 */
	public ArrayList<Chat> covertirArrayList(ListaChats lista) {
		ArrayList<Chat> chats = new ArrayList<>();
		for (int i = 0; i < lista.getLongitud(); i++) {
			Chat p = lista.getChat(i);
			chats.add(p);
		}

		return chats;
	}

	/**
	 * Metodo que permite agregar una publicacion
	 * 
	 * @param p
	 */
	public void agregarPublicacion(Publicacion p) {
		p.setFotoPerfilUsuario(perfil.getFotoPerfil());
		p.setIdUser(id);
		publicaciones.agregar(p);
	}

	/**
	 * Método que agrega publicacion global
	 * 
	 * @param p
	 */
	public void agregarPublicacionAdmin(Publicacion p) {
		p.setFotoPerfilUsuario(perfil.getFotoPerfil());
		p.setIdUser("ADMIN");
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
	 * Metodo que permite verificar que el usuario ingresado tenga o no solicitud
	 * pendiente
	 * 
	 * @param user
	 * @return
	 */

	public boolean isPendiente(String user) {
		for (Relacion r : relaciones) {
			if (id.equals(user)) {
				if (r.isPendiente()) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Metodo que permite verificar si el usuario ingresado esta bloqueado o no
	 * 
	 * @param user
	 * @return
	 */
	public boolean isBloqueado(String user) {
		for (Relacion r : relaciones) {
			if (id.equals(user)) {
				if (r.isBloqueado()) {
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

	public ArrayList<Relacion> getRelaciones() {
		return relaciones;
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

	@Override
	public String toString() {

		String s = id + ": ";
		s += "{" + getPerfil().getNombre() + "}\n";
		s += "Relaciones: " + relaciones.size() + "\n";

		for (int i = 0; i < relaciones.size(); i++) {

			s += "[" + i + "]:";
			if (relaciones.get(i) != null) {

				s += relaciones.get(i).getUsuario().getID() + "\n";

			} else {

				s += null + "\n";

			}

		}
		return s;
	}

	public void setNombre(String nombre) {

		perfil.setNombre(nombre);
	}

	public void setCorreo(String correo) {
		perfil.setCorreo(correo);
	}

	public void setPublicaciones(ListaPublicaciones publicaciones) {
		this.publicaciones = publicaciones;
	}

	public void setDireccion(String d) {
		perfil.setDireccion(d);
	}
}
