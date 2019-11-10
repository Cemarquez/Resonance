package resonance.interfaces;

import resonance.Resonance;
import resonance.archivos.AdministradorDeArchivos;

public class ControladoraPrincipal {

	private static Resonance resonance;
	private static VentantaLogIN ventanaLogin;

	public ControladoraPrincipal() {
		resonance = new Resonance();
		ventanaLogin = new VentantaLogIN(resonance);

		loadFiles();
		ventanaLogin.setVisible(true);
	}

	public static VentantaLogIN getI() {
		if (ventanaLogin != null) {
			return ventanaLogin;
		} else if (resonance != null) {
			return new VentantaLogIN(resonance);
		}
		resonance = new Resonance();

		return new VentantaLogIN(resonance);
	}

	public void loadFiles() {

		AdministradorDeArchivos.inicializar();

	}
}
