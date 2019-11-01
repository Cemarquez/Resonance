package resonance.estructura;

import java.io.Serializable;

import resonance.texto.Mensaje;

public class ListaMensajes implements Serializable {
	private Mensaje primero;
	private Mensaje actual;
	private Mensaje ultimo;
	private int longitud;

	public ListaMensajes() {
		primero = null;
		actual = null;
		ultimo = null;
		longitud = 0;
	}

	public void agregar(Mensaje p) {

		if (longitud == 0) {
			primero = p;
		} else {
			ultimo.conectar(p);
		}
		actual = p;
		ultimo = p;

		longitud++;

	}

	public void irAlPrimero() {
		actual = primero;
	}

	public boolean irSiguiente() {
		if (actual != null) {
			actual = actual.seguirEnlace();

			return true;
		}

		return false;

	}

	public Mensaje getActual() {
		return actual;
	}

	public void eliminarSiEsUnico() {
		if (longitud == 1) {
			primero = null;
			actual = null;
			ultimo = null;
			longitud = 0;
		}
	}

	public void eliminarPrimero() {
		irAlPrimero();
		primero = actual.seguirEnlace();
		actual = primero;
		longitud--;
	}

	public Mensaje getPublicacion(int indice) {
		irAlPrimero();
		for (int i = 0; i < indice; i++) {
			irSiguiente();
		}
		return actual;
	}

	public boolean eliminar(Mensaje p) {
		irAlPrimero();
		for (int i = 0; i < longitud; i++) {
			if (actual == primero) {
				if (actual == p) {
					eliminarPrimero();
					longitud--;
					return true;
				}
			} else {
				if (actual.seguirEnlace() != null) {
					if (actual.seguirEnlace() == p) {
						actual.conectar(actual.seguirEnlace().seguirEnlace());
						longitud--;
						return true;
					}
				}
			}

			irSiguiente();
		}

		return false;
	}

	public Mensaje getPrimero() {
		return primero;
	}

	public Mensaje getUltimo() {
		return ultimo;
	}
}
