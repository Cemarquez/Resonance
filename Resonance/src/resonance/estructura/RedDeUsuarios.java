package resonance.estructura;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import resonance.excepciones.ExistException;
import resonance.excepciones.LimitException;
import resonance.usuario.Relacion;
import resonance.usuario.Relacion.TipoRelacion;
import resonance.usuario.Usuario;

public class RedDeUsuarios implements Serializable {

	private HashMap<String, Usuario> grafo;
	private Usuario nodoInicial;
	private int limiteAmigos = 0;

	public RedDeUsuarios() {
		grafo = new HashMap<>();
		nodoInicial = null;
	}

	public boolean alreadyExist(String name) {
		if (grafo.get(name) != null) {
			return true;
		}
		return false;
	}

	public Usuario obtenerUsuario(String name) {
		return grafo.get(name);
	}

	public void agregar(String nombre, Usuario user) throws LimitException, ExistException {

		if (grafo.get(nombre) != null) {
			throw new ExistException("El nodo ingresado ya existe dentro del grafo.");
		} else {
			grafo.put(nombre, user);

		}

	}

	public ArrayList<Usuario> getAmigos(String usuario) {
		ArrayList<Usuario> amigos = new ArrayList<Usuario>();
		if (grafo.get(usuario) != null) {
			amigos = grafo.get(usuario).getAmigos();
		}

		return amigos;
	}

	public void conectar(String nombreOrigen, String nombreDestino, TipoRelacion tipoRelacion)
			throws ExistException, LimitException {
		if (grafo.get(nombreOrigen) != null && grafo.get(nombreDestino) != null) {
			grafo.get(nombreOrigen).determinarRelacion(grafo.get(nombreDestino), tipoRelacion);
			grafo.get(nombreDestino).determinarRelacion(grafo.get(nombreOrigen), tipoRelacion);
		} else {
			throw new ExistException("No existen nodos con los nombres ingresados.");
		}

	}

	public boolean isBloqueado(String nombreOrigen, String nombreDestino) {
		if (grafo.get(nombreOrigen) != null && grafo.get(nombreDestino) != null) {

			return grafo.get(nombreOrigen).isBloqueado(nombreDestino);
		} else {
			return false;
		}
	}

	public Relacion seguirEnlance(String nombre, int indice) throws ExistException {
		Relacion nodo = null;
		if (grafo.get(nombre) != null) {
			nodo = grafo.get(nombre).seguirRelacion(indice);
		} else {
			throw new ExistException("No existen un nodo con el nombre ingresado.");
		}

		return nodo;
	}

	public void modificarLimiteDeAmigos(String nombre, int limite) throws ExistException {
		if (grafo.get(nombre) != null) {
			grafo.get(nombre).setLimiteAmigos(limite);
		} else {
			throw new ExistException("No existe un usuario con el nombre ingresado.");
		}
	}

	public void eliminar(String nombre) throws ExistException {
		if (grafo.get(nombre) != null) {
			Iterator<String> keys = grafo.keySet().iterator();
			while (keys.hasNext()) {
				Usuario aux = grafo.get(keys.next());
				aux.eliminarRelacion(grafo.get(nombre));
			}
			grafo.remove(nombre);
		} else {
			throw new ExistException("No existen un usuario con el nombre ingresado.");
		}
	}

	public int getNumRelaciones(String nombre) throws ExistException {
		int size = 0;
		if (grafo.get(nombre) != null) {
			size = grafo.get(nombre).getNumRelaciones();
		} else {
			throw new ExistException("No existen un nodo con el nombre ingresado.");
		}

		return size;
	}

	@Override
	public String toString() {
		String s = "";
		s += "Estado del Grafo: \n Tamano: " + getCantUsuarios();

		Iterator<String> ite = grafo.keySet().iterator();
		while (ite.hasNext()) {
			Object obj = ite.next();
			Usuario a = grafo.get(obj);
			s += "\n" + a.toString();
		}

		return s;
	}

	public Usuario getNodoInicial() {
		return nodoInicial;
	}

	public boolean isEmpty() {
		return grafo.isEmpty();
	}

	public boolean estaRelacionado(String nombreOrigen, String userDestino) throws ExistException {
		if (grafo.get(nombreOrigen) != null && grafo.get(userDestino) != null) {
			if (grafo.get(nombreOrigen).estaRelacionado(userDestino))
				return true;
		} else {
			throw new ExistException("No existen un nodo con el nombre ingresado.");
		}
		return false;
	}

	public int getCantUsuarios() {
		return grafo.size();
	}

	public void setNodoInicial(Usuario nodoInicial) {
		this.nodoInicial = nodoInicial;
	}

	public HashMap<String, Usuario> getGrafo() {
		return grafo;
	}

	public double getPromedioDeAmigos() {
		double promedio = 0;

		Iterator<String> it = grafo.keySet().iterator();

		while (it.hasNext()) {
			Object obj = it.next();
			Usuario a = grafo.get(obj);
			promedio += a.getAmigos().size();
		}

		promedio = promedio / grafo.size();

		return promedio;
	}

	public double getPromedioDePublicaciones() {
		double promedio = 0;

		Iterator<String> it = grafo.keySet().iterator();

		while (it.hasNext()) {
			Object obj = it.next();
			Usuario a = grafo.get(obj);
			promedio += a.getPublicaciones(a.getID()).getLongitud();
		}

		promedio = promedio / grafo.size();

		return promedio;
	}

	public double getPromedioDeChats() {
		double promedio = 0;

		Iterator<String> it = grafo.keySet().iterator();

		while (it.hasNext()) {
			Object obj = it.next();
			Usuario a = grafo.get(obj);
			promedio += a.getChats().getLongitud();
		}

		promedio = promedio / grafo.size();

		return promedio;
	}

	public int getLimiteAmigos() {
		return limiteAmigos;
	}

	public int getMayorNumAmigos() {
		int mayor = 0;
		Iterator<String> it = grafo.keySet().iterator();

		while (it.hasNext()) {
			Object obj = it.next();
			Usuario a = grafo.get(obj);
			if (mayor < a.getAmigos().size()) {
				mayor = a.getAmigos().size();
			}

		}

		return mayor;
	}

	public void setLimiteAmigos(int limiteAmigos) {
		this.limiteAmigos = limiteAmigos;
	}

}
