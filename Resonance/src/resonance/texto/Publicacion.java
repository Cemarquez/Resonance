package resonance.texto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Publicacion  extends Mensaje{

	private List<Reaccion> reacciones;	
	
	/**
	 * Metodo constructor
	 * @param mensaje
	 * @param fecha
	 */
	public Publicacion(String mensaje, Date fecha) {
		super(mensaje, fecha);
		reacciones = new ArrayList<Reaccion>();
		
		
	}

	
	/**
	 * Metodo que permite a�adir una reaccion a la publicacion.
	 * @param reaccion Reaccion a a�adir
	 * @return Retorna true si se pudo a�adir y false en caso contrario.
	 */
	public boolean agregarReaccion (Reaccion reaccion) {
		
		
		for (Reaccion r: reacciones) {
			
			if (r.getUsuario()== reaccion.getUsuario()) {
				
				return false;
			}
	
		}

		reacciones.add(reaccion);
		return true;
		
	}
	
	/**
	 * Metodo que permite eliminar una reaccion de la publicacion.
	 * @param reaccion
	 */
	public void eliminarReaccion (Reaccion reaccion) {
		
		reacciones.remove(reaccion);
	
	}
	
	
}
