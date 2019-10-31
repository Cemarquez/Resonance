package resonance;

import java.io.Serializable;
import java.util.ArrayList;

import resonance.estructura.RedDeUsuarios;
import resonance.excepciones.ExistException;
import resonance.excepciones.LimitException;
import resonance.usuario.Relacion;
import resonance.usuario.Usuario;

public class Resonance implements Serializable {
	private RedDeUsuarios administradorDeUsuarios;

	public Resonance() {

		administradorDeUsuarios = new RedDeUsuarios();
	}

	public void anadirUsuario(String nombre, Usuario perfil) throws LimitException, ExistException {
		administradorDeUsuarios.agregar(nombre, perfil);
		cargarUsuarios(perfil);
	}

	public boolean alreadyExist(String name) {
		return administradorDeUsuarios.alreadyExist(name);
	}

	public Usuario obtenerUsuario(String name) {
		return administradorDeUsuarios.obtenerUsuario(name);
	}

	public void eliminarUsuario(String nombre) throws ExistException {
		administradorDeUsuarios.eliminar(nombre);
	}

	public void modificarLimiteDeAmigos(String nombre, int limite) throws ExistException {
		administradorDeUsuarios.modificarLimiteDeAmigos(nombre, limite);
	}

	public ArrayList<Usuario> getAmigos(String usuario) {
		return administradorDeUsuarios.getAmigos(usuario);
	}

	public void cargarUsuarios(Usuario user) throws LimitException, ExistException {
		System.out.println(user.getRelaciones().size());
		for (Relacion r : user.getRelaciones()) {

			if (!alreadyExist(r.getUsuario().getID())) {
				anadirUsuario(r.getUsuario().getID(), r.getUsuario());
			}
		}
	}

}
