package resonance.usuario;

import java.util.ArrayList;

import resonance.excepciones.LimitException;
import resonance.texto.Chat;
import resonance.usuario.Relacion.TipoRelacion;

public class Usuario {
	
	private String id;
	private ArrayList<Relacion> relaciones;
	private int limiteAmigos;
    private Perfil perfil;
    private ArrayList<Chat> chats;
    private boolean admin=false;
    //Fotos
    
	public Usuario(String nombre, Perfil perfil) {
		this.setPerfil(perfil);
		this.id = nombre;
		setChats(new ArrayList<Chat>());
		relaciones = new ArrayList<Relacion>();
		limiteAmigos = 0;
		relaciones.add(null);
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

	public boolean estaRelacionado(String nombre) {
		
		for(Relacion r : relaciones)
		{
			if(r.getUsuario().getID().equals(nombre))
			{
				return true;
			}
		}
		
		return false;
	}
	public void setLimiteAmigos(int limiteAmigos) {
		this.limiteAmigos = limiteAmigos;
	}

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

	public ArrayList<Usuario> getAmigos() {
		ArrayList<Usuario> amigos = new ArrayList<Usuario>();
		for (Relacion r : relaciones) {
			if (r.getTipo() == TipoRelacion.AMIGOS) {
				amigos.add(r.getUsuario());
			}
		}
		return amigos;
	}

	public boolean modificarConexion(Usuario usuario, TipoRelacion relacion) {
		for (Relacion r : relaciones) {
			if (r.getUsuario() == usuario) {
				r.setTipo(relacion);
				return true;
			}
		}

		return false;

	}

	public boolean eliminarAmigo(Usuario usuario) {
		for (Relacion r : relaciones) {
			if (r.getUsuario() == usuario) {
				relaciones.remove(r);
				return true;
			}
		}

		return false;
	}
	

	public boolean eliminarRelacion(Usuario usuario)
	{
		
		for(Relacion r : relaciones)
		{
			if(r.getUsuario() == usuario) {
				relaciones.remove(r);
				return true;
			}
		}
		
		return false;
	}
	public boolean isConected(int indice) {
		if (indice >= getNumRelaciones())
			return false;

		return relaciones.get(indice) != null;
	}

	public Relacion seguirRelacion(int indice) {
		return relaciones.get(indice);
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public ArrayList<Chat> getChats() {
		return chats;
	}

	public void setChats(ArrayList<Chat> chats) {
		this.chats = chats;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	

}
