package resonance;

import java.util.ArrayList;

import resonance.estructura.RedDeUsuarios;
import resonance.excepciones.ExistException;
import resonance.excepciones.LimitException;
import resonance.usuario.Perfil;
import resonance.usuario.Usuario;

public class Resonance {
 private RedDeUsuarios administradorDeUsuarios;
 public Resonance()
 {
	 
	 administradorDeUsuarios = new RedDeUsuarios();
 }
 
 
 public void anadirUsuario(String nombre, Perfil perfil) throws LimitException, ExistException
 {
	 administradorDeUsuarios.agregar(nombre, perfil);
 }
 
 public void eliminarUsuario(String nombre) throws ExistException {
	 administradorDeUsuarios.eliminar(nombre);
 }
 
 public void modificarLimiteDeAmigos(String nombre, int limite) throws ExistException
 {
	 administradorDeUsuarios.modificarLimiteDeAmigos(nombre, limite);
 }

	public ArrayList<Usuario> getAmigos(String usuario) {
		return administradorDeUsuarios.getAmigos(usuario);
	}
	
}
