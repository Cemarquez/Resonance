package resonance.usuario;

import java.util.ArrayList;

import resonance.excepciones.LimitException;


public class Usuario {
	private String name;
	private Object value;
	private ArrayList<Usuario> links;
	private int linksLimits;
	private ArrayList<Usuario> conexionesEntrantes;
	public Usuario(String nombre)
	{
		conexionesEntrantes = new ArrayList<>();
		this.name = nombre;
		links = new ArrayList<Usuario>();
		linksLimits = 0;
		links.add(null);
	}

	public String getNombre() 
	{
		return name;
	}

	public void setNombre(String nombre) 
	{
		this.name = nombre;
	}

	public Object getDato() 
	{
		return value;
	}

	public void setDato(Object dato) 
	{
		this.value = dato;
	}
	
	public int getSize() 
	{
		return links.size();
	}
	
	public int getLimiteEnlaces() 
	{
		return linksLimits;
	}

	public void setLimiteEnlaces(int limiteEnlaces) 
	{
		this.linksLimits = limiteEnlaces;
	}

	public void conectar(int indice, Usuario destino) throws LimitException
	{
		if(indice > linksLimits && linksLimits != 0) 
		{
			throw new LimitException("No es posible realizar la conexi�n. �ndice supera el l�mite establecido");
		}
			
		if(indice >= links.size())
		{
			int n = indice - links.size();
			
			for(int i = 0; i < n; i++)
			{
				links.add(null);
			}
			
			links.add(destino);
		}
		else
		{
			links.set(indice, destino);
		}
	}
	
	
	public void desconectar(int indice)
	{

		links.set(indice, null);
	}
	
	public boolean isConected(int indice)
	{
		if(indice >= getSize())
		return false;
		
		return links.get(indice) != null;
	}
	
	public Usuario seguirEnlace(int indice)
	{
		return links.get(indice);
	}
	
	public String toString() {

		String s = name + ": ";
		s += "{" + value + "}\n";
		s += "Enlaces: " + links.size() + "\n";

		for (int i = 0; i < links.size(); i++) {

		s += "[" + i + "]:";
		if (links.get(i) != null) {

		s += links.get(i).getNombre() + "\n";

		} else {

		s += null + "\n";

		}

		}
		return s;
	}

	public int getConexionesEntrantes()
	{
		return conexionesEntrantes.size();
	}
	
	

	
	
}
