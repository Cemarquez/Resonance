package resonance.usuario;

import java.util.ArrayList;

import resonance.excepciones.LimitException;
import resonance.usuario.Relacion.TipoRelacion;

public class Usuario {
	private String id;
	private ArrayList<Relacion> relaciones;
	private int limiteAmigos;
	private ArrayList<Usuario> conexionesEntrantes;

	public Usuario(String nombre) {
		conexionesEntrantes = new ArrayList<>();
		this.id = nombre;
		relaciones = new ArrayList<Relacion>();
		limiteAmigos = 0;
		relaciones.add(null);
	}

	public String getID() {
		return id;
	}

	public int getSize() {
		return relaciones.size();
	}

	public int getLimiteAmigos() {
		return limiteAmigos;
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

	public void desconectar(int indice) {

		relaciones.set(indice, null);
	}

	public boolean isConected(int indice) {
		if (indice >= getSize())
			return false;

		return relaciones.get(indice) != null;
	}

	public Relacion seguirRelacion(int indice) {
		return relaciones.get(indice);
	}

	public int getConexionesEntrantes() {
		return conexionesEntrantes.size();
	}

}
