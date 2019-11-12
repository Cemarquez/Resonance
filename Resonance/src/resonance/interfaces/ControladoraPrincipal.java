package resonance.interfaces;

import resonance.Resonance;
import resonance.archivos.AdministradorDeArchivos;
import resonance.estructura.RedDeUsuarios;

public class ControladoraPrincipal {

	private static Resonance resonance;
	private static VentantaLogIN ventanaLogin;

	public ControladoraPrincipal() {

		loadFiles();
		ventanaLogin = new VentantaLogIN(resonance);

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
		resonance = new Resonance();
		RedDeUsuarios red = null;
		if(AdministradorDeArchivos.existData()) {
			red = AdministradorDeArchivos.deserializarGrafo();
		}
		
		if(red !=null)
		{
			resonance.setRedUsuarios(red);
		}
		AdministradorDeArchivos.inicializar();

	}
}
