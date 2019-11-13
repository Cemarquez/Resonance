package resonance.texto;

import java.awt.Image;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import resonance.usuario.Usuario;

public class Publicacion extends Mensaje implements Serializable {

	private List<Reaccion> reacciones;
	private File fotoPerfilUsuario;
	private ArrayList<Publicacion> links;
	private ArrayList<Comentario> comentarios;
	private Image imagen;

	/**
	 * Metodo constructor
	 * 
	 * @param mensaje
	 * @param fecha
	 */
	public Publicacion(String mensaje, Date fecha, Image imagen, String idUser) {
		super(mensaje, fecha, idUser);

		reacciones = new ArrayList<Reaccion>();
		links = new ArrayList<Publicacion>();
		comentarios = new ArrayList<Comentario>();
		this.imagen = imagen;
	}

	public Publicacion(String mensaje, Date fecha, String idUser) {
		super(mensaje, fecha, idUser);
		reacciones = new ArrayList<Reaccion>();
		links = new ArrayList<Publicacion>();
		comentarios = new ArrayList<Comentario>();
		imagen = null;
	}

	public void conectar(Publicacion p) {
		links.add(p);
	}

	@Override
	public Publicacion seguirEnlace() {
		if (links.isEmpty()) {
			return null;
		}
		return links.get(0);
	}

	public boolean yaReacciono(String user)
	{
		for (Reaccion r : reacciones) {

			if (r.getIdUser().equals(user)) {

				return true;
			}

		}
		
		return false;
	}
	@Override
	public void desconectar() {
		links.remove(0);
	}

	
	/**
	 * Metodo que permite a�adir una reaccion a la publicacion.
	 * 
	 * @param reaccion Reaccion a a�adir
	 * @return Retorna true si se pudo a�adir y false en caso contrario.
	 */
	public boolean agregarReaccion(Reaccion reaccion) {

		for (Reaccion r : reacciones) {

			if (r.getIdUser().equals(reaccion.getIdUser())) {

				return false;
			}

		}

		reacciones.add(reaccion);
		return true;

	}

	/**
	 * Metodo que permite eliminar una reaccion de la publicacion.
	 * 
	 * @param reaccion
	 */
	public void eliminarReaccion(Reaccion reaccion) {

		reacciones.remove(reaccion);

	}

	/**
	 * Metodo que permite anadir un comentario a la publicacion.
	 * 
	 * @param comentario a anadir
	 */
	public void agregarComentario(Comentario comentario) {
		comentarios.add(comentario);
	}

	/**
	 * Metodo que permite eliminar una reaccion de la publicacion.
	 * 
	 * @param reaccion
	 */
	public void eliminarComentario(Comentario comentario) {

		comentarios.remove(comentario);

	}

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	public File getFotoPerfilUsuario() {
		return fotoPerfilUsuario;
	}

	public void setFotoPerfilUsuario(File fotoPerfilUsuario) {
		this.fotoPerfilUsuario = fotoPerfilUsuario;
	}

	
	public List<Reaccion> getReacciones() {
		return reacciones;
	}

	public void setReacciones(List<Reaccion> reacciones) {
		this.reacciones = reacciones;
	}

	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}


}
