package resonance.estructura;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import resonance.excepciones.ExistException;
import resonance.excepciones.LimitException;
import resonance.usuario.Perfil;
import resonance.usuario.Relacion;
import resonance.usuario.Usuario;
import resonance.usuario.Relacion.TipoRelacion;


public class RedDeUsuarios {
   
	private HashMap<String, Usuario> grafo;
	private Usuario nodoInicial;
	public RedDeUsuarios()
	{
		grafo = new HashMap<>();
		nodoInicial = null;
	}
	
	public void agregar(String nombre, Perfil perfil) throws LimitException, ExistException	{
		
			Usuario nodo = new Usuario(nombre, perfil);
			if(grafo.get(nombre)!=null)
			{
				throw new ExistException("El nodo ingresado ya existe dentro del grafo.");
			}else {
				grafo.put(nombre, nodo);
				
			}
			
	}
		
	

	public ArrayList<Usuario> getAmigos(String usuario) {
		ArrayList<Usuario> amigos = new ArrayList<Usuario>();
		if (grafo.get(usuario) != null) {
			amigos = grafo.get(usuario).getAmigos();
		}

		return amigos;
	}
	public void conectar(String nombreOrigen, String nombreDestino, TipoRelacion tipoRelacion) throws ExistException, LimitException
	{
		if(grafo.get(nombreOrigen) != null && grafo.get(nombreDestino) != null){
			grafo.get(nombreOrigen).determinarRelacion(grafo.get(nombreDestino), tipoRelacion);
			grafo.get(nombreDestino).determinarRelacion(grafo.get(nombreOrigen), tipoRelacion);
		}else {
			throw new ExistException("No existen nodos con los nombres ingresados.");
		}
		
	}
	public Relacion seguirEnlance(String nombre, int indice) throws ExistException
	{
		Relacion nodo = null;
		if(grafo.get(nombre) != null)
		{
			nodo = grafo.get(nombre).seguirRelacion(indice);
		}else {
			throw new ExistException("No existen un nodo con el nombre ingresado.");
		}
		
		
		return nodo;
	}
	
	
	 public void modificarLimiteDeAmigos(String nombre, int limite) throws ExistException
	 {
		if(grafo.get(nombre) !=null)
		{
			grafo.get(nombre).setLimiteAmigos(limite);
		}else {
			throw new ExistException("No existe un usuario con el nombre ingresado.");
		}
	 }
	 
	public void eliminar(String nombre) throws ExistException
	{
		if(grafo.get(nombre) != null)
		{
			Iterator<String> keys = grafo.keySet().iterator();
			while(keys.hasNext())
			{
				Usuario aux = grafo.get(keys.next());
				aux.eliminarRelacion(grafo.get(nombre));
			}
			grafo.remove(nombre);
		}else {
			throw new ExistException("No existen un usuario con el nombre ingresado.");
		}
	}
	
	

	
	public int getNumRelaciones(String nombre) throws ExistException
	{
		int size =0;
		if(grafo.get(nombre) != null)
		{
			size = grafo.get(nombre).getNumRelaciones();
		}else {
			throw new ExistException("No existen un nodo con el nombre ingresado.");
		}
		
		return size;
	}
	
	
	
	public String toString()
	{
		String s ="";
		s+= "Estado del Grafo: \n Tamaño: " + getCantUsuarios();
		
		Iterator<String> ite = grafo.keySet().iterator();
		while(ite.hasNext())
		{
			Object obj = ite.next();
			Usuario a = grafo.get(obj);
			s+= "\n" + a.toString();
		}
		
		return s;
	}
	public Usuario getNodoInicial() {
		return nodoInicial;
	}

	public boolean estaRelacionado (String nombreOrigen, String userDestino) throws ExistException
	{
		if(grafo.get(nombreOrigen) != null && grafo.get(userDestino) != null)
		{
			if(grafo.get(nombreOrigen).estaRelacionado(userDestino))
			return true;
		}else {
			throw new ExistException("No existen un nodo con el nombre ingresado.");
		}
		return false;
	}
	public int getCantUsuarios()
	{
		return grafo.size();
	}


	public void setNodoInicial(Usuario nodoInicial) {
		this.nodoInicial = nodoInicial;
	}
	
}
