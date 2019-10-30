package resonance.interfaces;

import resonance.Resonance;
import resonance.archivos.AdministradorDeArchivos;

public class ControladoraPrincipal {

	private Resonance resonance;
	private VentantaLogIN ventanaLogin;

	public ControladoraPrincipal() {
		resonance = new Resonance();
		ventanaLogin = new VentantaLogIN(resonance);

		loadFiles();
		ventanaLogin.setVisible(true);
	}

	public void loadFiles() {

		AdministradorDeArchivos.inicializar();

	}
}
