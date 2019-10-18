package resonance.usuario;


import java.util.HashMap;
import java.util.Iterator;

import resonance.excepciones.ExistException;
import resonance.excepciones.LimitException;
import resonance.texto.Reaccion.TipoReaccion;
import resonance.usuario.Relacion.TipoRelacion;


public class Grafo {
   
	private HashMap<String, Usuario> grafo;
	private int limite;
	private Usuario nodoInicial;
	public Grafo()
	{
		grafo = new HashMap<>();
		limite =0;
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
	public void eliminar(String nombre) throws ExistException
	{
		if(grafo.get(nombre) != null)
		{
			Iterator<String> keys = grafo.keySet().iterator();
			while(keys.hasNext())
			{
				Nodo aux = grafo.get(keys.next());
				aux.desconectarNodo(nombre);
			}
			grafo.remove(nombre);
		}else {
			throw new ExistException("No existen un nodo con el nombre ingresado.");
		}
	}
	
	
	public void setDato(String nombre, Object dato) throws ExistException
	{
		if(grafo.get(nombre) != null)
		{
			grafo.get(nombre).setDato(dato);
		}else {
			throw new ExistException("No existen un nodo con el nombre ingresado.");
		}
	}
	
	public Object getDato(String nombre) throws ExistException
	{
		Object obj = null;
		if(grafo.get(nombre) != null)
		{
			obj = grafo.get(nombre).getDato();
		}else {
			throw new ExistException("No existen un nodo con el nombre ingresado.");
		}
		return obj;
	}
	
	public int getSizeNodo(String nombre) throws ExistException
	{
		int size =0;
		if(grafo.get(nombre) != null)
		{
			size = grafo.get(nombre).getTamañoNoNulas();
		}else {
			throw new ExistException("No existen un nodo con el nombre ingresado.");
		}
		
		return size;
	}
	
	
	
	public String toString()
	{
		String s ="";
		s+= "Estado del Grafo: \n Tamaño: " + getTamanio();
		
		Iterator<String> ite = grafo.keySet().iterator();
		while(ite.hasNext())
		{
			Object obj = ite.next();
			Nodo a = grafo.get(obj);
			s+= "\n" + a.toString();
		}
		
		return s;
	}
	public Nodo getNodoInicial() {
		return nodoInicial;
	}

	public boolean estaConectado (String nombre, int indice) throws ExistException
	{
		if(grafo.get(nombre) != null)
		{
			if(grafo.get(nombre).isConected(indice))
			return true;
		}else {
			throw new ExistException("No existen un nodo con el nombre ingresado.");
		}
		return false;
	}
	public int getTamanio()
	{
		return grafo.size();
	}


	public void setNodoInicial(Nodo nodoInicial) {
		this.nodoInicial = nodoInicial;
	}
	
}
