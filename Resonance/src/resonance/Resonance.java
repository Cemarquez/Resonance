package resonance;

import resonance.excepciones.ExistException;
import resonance.excepciones.LimitException;
import resonance.usuario.Grafo;
import resonance.usuario.Perfil;

public class Resonance {
 private Grafo administradorDeUsuarios;
 public Resonance()
 {
	 
	 administradorDeUsuarios = new Grafo();
 }
 
 
 public void añadirUsuario(String nombre, Perfil perfil) throws LimitException, ExistException
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
	
}
