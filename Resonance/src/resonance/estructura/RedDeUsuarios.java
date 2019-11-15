package resonance.estructura;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import resonance.archivos.AdministradorDeArchivos;
import resonance.excepciones.ExistException;
import resonance.excepciones.LimitException;
import resonance.texto.Publicacion;
import resonance.usuario.Perfil;
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
		cargarPruebas();
	}

	public void cargarPruebas() {
		if (grafo.get("Cemarquez") == null && grafo.get("RyanDeep") == null && grafo.get("DaftClub") == null
				&& grafo.get("Kikhe") == null && grafo.get("Sebastian") == null) {
			File fileFoto = new File(RedDeUsuarios.class.getResource("/imagenes/fotoperfil_icono.png").getFile());
			Perfil perfilCesar = new Perfil("Cesar Marquez", "Cemarquez", "cesar@hotmail.com", "calle 12", "cesar");
			Usuario userCesar = new Usuario("Cemarquez", perfilCesar);

			Perfil perfilBrian = new Perfil("Brian Giraldo", "RyanDeep", "brian@hotmail.com", "calle 12", "brian");
			Usuario userBrian = new Usuario("RyanDeep", perfilBrian);

			Perfil perfilEsteban = new Perfil("Esteban Sanchez", "DaftClub", "esteban@hotmail.com", "calle 12",
					"esteban");
			Usuario userEsteban = new Usuario("DaftClub", perfilEsteban);

			Perfil perfilKikhe = new Perfil("Kikhe Suarez", "Kikhe", "kikhe@hotmail.com", "calle 12", "kikhe");
			Usuario userKikhe = new Usuario("Kikhe", perfilKikhe);

			Perfil perfilSebastian = new Perfil("Sebastian Medina", "Sebastian", "sebastian@hotmail.com", "calle 12",
					"sebas");
			Usuario userSebastian = new Usuario("Sebastian", perfilSebastian);

			try {
				agregar(userCesar.getID(), userCesar);
				agregar(userBrian.getID(), userBrian);
				agregar(userEsteban.getID(), userEsteban);
				agregar(userKikhe.getID(), userKikhe);
				agregar(userSebastian.getID(), userSebastian);
			} catch (LimitException | ExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AdministradorDeArchivos.crearCarpetaUsuario(userCesar.getID());
			AdministradorDeArchivos.cambiarFotoPerfil(fileFoto, userCesar.getID());

			AdministradorDeArchivos.crearCarpetaUsuario(userBrian.getID());
			AdministradorDeArchivos.cambiarFotoPerfil(fileFoto, userBrian.getID());

			AdministradorDeArchivos.crearCarpetaUsuario(userEsteban.getID());
			AdministradorDeArchivos.cambiarFotoPerfil(fileFoto, userEsteban.getID());

			AdministradorDeArchivos.crearCarpetaUsuario(userKikhe.getID());
			AdministradorDeArchivos.cambiarFotoPerfil(fileFoto, userKikhe.getID());

			AdministradorDeArchivos.crearCarpetaUsuario(userSebastian.getID());
			AdministradorDeArchivos.cambiarFotoPerfil(fileFoto, userSebastian.getID());
		}
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

	public void enviarSolicitud(String nombreOrigen, String nombreDestino, TipoRelacion tipoRelacion)
			throws ExistException, LimitException {
		if (grafo.get(nombreOrigen) != null && grafo.get(nombreDestino) != null) {
			grafo.get(nombreOrigen).determinarRelacion(grafo.get(nombreDestino), tipoRelacion);
			grafo.get(nombreDestino).addSolicitud(grafo.get(nombreOrigen));
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
			promedio += a.getPublicaciones().getLongitud();
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

	public void enviarMensajeGlobal(Publicacion p) {
		Iterator<String> it = grafo.keySet().iterator();

		while (it.hasNext()) {
			Object obj = it.next();
			Usuario a = grafo.get(obj);

			a.agregarPublicacionAdmin(p);
		}

	}

}
