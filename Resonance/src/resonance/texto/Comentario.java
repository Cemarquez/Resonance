package resonance.texto;

import java.util.Date;

import resonance.usuario.Usuario;

public class Comentario extends Mensaje
{
	private Usuario usuario;
	private String mensaje;
	private Date fecha;
	
	/**
	 * Metodo Constructor
	 * @param usuario
	 * @param mensaje
	 * @param fecha
	 */
	public Comentario(Usuario usuario, String mensaje, Date fecha)
	{
		super(mensaje, fecha);
		
		this.usuario = usuario;
	}
	
	// Getters and Setters
	public Usuario getUsuario()
	{
		return usuario;
	}
	
	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
		
}
