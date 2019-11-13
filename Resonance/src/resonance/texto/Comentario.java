package resonance.texto;

import java.util.Date;

import resonance.usuario.Usuario;

public class Comentario extends Mensaje
{
	
	/**
	 * Metodo Constructor
	 * @param usuario
	 * @param mensaje
	 * @param fecha
	 */
	public Comentario(String idUser, String mensaje, Date fecha)
	{
		super(mensaje, fecha, idUser);
		
		
	}
	
	
	
		
}
