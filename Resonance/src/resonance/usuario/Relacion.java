package resonance.usuario;

import java.io.Serializable;

public class Relacion implements Serializable{

	private TipoRelacion tipo;
	private Usuario usuario;

	public Relacion(TipoRelacion tipo, Usuario usuario) {
		this.tipo = tipo;
		this.usuario = usuario;
	}

	public TipoRelacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoRelacion tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isAmigo()
	{
		return tipo == TipoRelacion.AMIGOS;
	}
	
	public enum TipoRelacion {
		BLOQUEADO, PENDIENTE, AMIGOS
	}

}
