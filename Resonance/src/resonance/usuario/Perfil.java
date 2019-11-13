package resonance.usuario;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import resonance.archivos.AdministradorDeArchivos;

public class Perfil implements Serializable {
	private OpcionManager opcionManager;
	private String nombre, usuario, correo, direccion, contrasena;
	private Date fechaNacimiento;

	/**
	 * Constructor de la clase Perfil
	 * 
	 * @param opcionManager
	 * @param nombre
	 * @param usuario
	 * @param correo
	 * @param direccion
	 * @param contrasena
	 */
	public Perfil(String nombre, String usuario, String correo, String direccion, String contrasena) {

		opcionManager = new OpcionManager();

		this.nombre = nombre;
		this.usuario = usuario;
		this.correo = correo;
		this.direccion = direccion;

		this.contrasena = contrasena;

		crearOpciones();
	}

	public void crearOpciones() {

		opcionManager.anadirOpcion("solicitudes", "Solicitudes de amistad", true);
		opcionManager.anadirOpcion("listaAmigos", "Permitir ver lista de amigos", true);
		opcionManager.anadirOpcion("busqueda", "Permitir ser buscado", true);
		opcionManager.anadirOpcion("publicaciones", "Permitir ver publicaciones", true);
		opcionManager.anadirOpcion("muro", "Permitir que publiquen en tu muro", true);
		opcionManager.anadirOpcion("compartir", "Permitir compartir tus publicaciones", true);

	}

	public File getFotoPerfil() {
		return AdministradorDeArchivos.getFotoPerfil(nombre);
	}
	// Getters and setters

	/**
	 * Obtiene el gestor de las opciones del perfil
	 * 
	 * @return
	 */

	public OpcionManager getOpcionManager() {
		return opcionManager;
	}

	/**
	 * Asigna un gestor de opciones
	 * 
	 * @param opcionManager
	 */
	public void setOpcionManager(OpcionManager opcionManager) {
		this.opcionManager = opcionManager;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
