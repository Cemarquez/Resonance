package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentantaInicial extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentantaInicial() {

		this.setExtendedState(MAXIMIZED_BOTH);
		Dimension tamano = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(tamano);
		getContentPane().setLayout(null);
		getContentPane().setSize(tamano);
		JPanel panelBanner = new JPanel();
		panelBanner.setBackground(Color.WHITE);
		panelBanner.setBounds(0, 0, (int) tamano.getWidth() / 2, (int) tamano.getHeight());
		getContentPane().add(panelBanner);
		panelBanner.setLayout(null);

		JPanel panelInicioSesion = new JPanel();
		panelInicioSesion.setBackground(Color.WHITE);
		panelInicioSesion.setBounds((int) tamano.getWidth() / 2 + 1, 0, (int) tamano.getWidth() / 2,
				(int) tamano.getHeight());
		getContentPane().add(panelInicioSesion);
		panelInicioSesion.setLayout(null);

		JLabel lblDescubreLoQue = new JLabel("Descubre lo que esta pasando");
		lblDescubreLoQue.setBounds(311, 171, 207, 37);
		panelInicioSesion.add(lblDescubreLoQue);

		JButton btnIniciarSesin = new JButton("Iniciar sesi\u00F3n");
		btnIniciarSesin.setBounds(321, 237, 177, 37);
		panelInicioSesion.add(btnIniciarSesin);

		JButton btnRegitsrrase = new JButton("regitsrrase");
		btnRegitsrrase.setBounds(346, 326, 89, 23);
		panelInicioSesion.add(btnRegitsrrase);

		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);

	}

	public static void main(String[] args) {
		new VentantaInicial().setVisible(true);
	}
}
