package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class VentantaInicial extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField textField;

	public VentantaInicial() {

		this.setExtendedState(MAXIMIZED_BOTH);
		Dimension tamano = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(tamano);
		getContentPane().setLayout(null);
		getContentPane().setSize(tamano);
		getContentPane().setBackground(Color.decode("#5B5151"));
		JPanel panelBanner = new JPanel();
		panelBanner.setBackground(Color.decode("#557B83"));
		panelBanner.setBounds(0, 0, (int) tamano.getWidth() / 2, (int) tamano.getHeight());
		getContentPane().add(panelBanner);
		panelBanner.setLayout(null);

		JLabel lblResonance = new JLabel("Resonance");
		lblResonance.setFont(new Font("Century Gothic", Font.PLAIN, 33));
		lblResonance.setForeground(Color.WHITE);
		lblResonance.setBackground(Color.WHITE);
		lblResonance.setBounds(34, 26, 186, 29);
		panelBanner.add(lblResonance);

		JPanel panelInicioSesion = new JPanel();
		panelInicioSesion.setBorder(null);
		panelInicioSesion.setBackground(Color.decode("#5B5151"));
		panelInicioSesion.setBounds(711, 0, (int) tamano.getWidth() / 2,
				(int) tamano.getHeight());
		getContentPane().add(panelInicioSesion);
		panelInicioSesion.setLayout(null);

		JLabel lblIniciaSesionO = new JLabel("Inicia sesion o registrate");
		lblIniciaSesionO.setForeground(Color.WHITE);
		lblIniciaSesionO.setFont(new Font("Century Gothic", Font.PLAIN, 33));
		lblIniciaSesionO.setBackground(Color.WHITE);
		lblIniciaSesionO.setBounds(157, 87, 439, 58);
		panelInicioSesion.add(lblIniciaSesionO);

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(Color.LIGHT_GRAY);
		lblUsuario.setFont(new Font("Century Gothic", Font.BOLD, 33));
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setBounds(157, 224, 439, 58);
		panelInicioSesion.add(lblUsuario);

		JLabel lblClave = new JLabel("CLAVE");
		lblClave.setForeground(Color.LIGHT_GRAY);
		lblClave.setFont(new Font("Century Gothic", Font.BOLD, 33));
		lblClave.setBackground(Color.WHITE);
		lblClave.setBounds(157, 338, 439, 58);
		panelInicioSesion.add(lblClave);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(157, 326, 389, 2);
		panelInicioSesion.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(157, 443, 389, 2);
		panelInicioSesion.add(separator_1);

		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setText("");
			}
		});
		passwordField.setBackground(Color.decode("#5B5151"));
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		passwordField.setForeground(Color.WHITE);
		passwordField.setText("password");

		passwordField.setBorder(null);
		passwordField.setBounds(157, 403, 394, 37);
		panelInicioSesion.add(passwordField);

		textField = new JTextField();

		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				textField.setText("");
			}
		});
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		textField.setText("Ingrese su nombre de usuario");
		textField.setBorder(null);
		textField.setBackground(Color.decode("#5B5151"));
		textField.setBounds(157, 290, 389, 31);
		panelInicioSesion.add(textField);
		textField.setColumns(10);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Acepto los terminos y condiciones");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setBorder(null);
		chckbxNewCheckBox.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		chckbxNewCheckBox.setBackground(Color.decode("#5B5151"));
		chckbxNewCheckBox.setBounds(157, 516, 333, 23);
		panelInicioSesion.add(chckbxNewCheckBox);

		JPanel panel = new JPanel();
		panel.setBounds(151, 595, 195, 47);
		panel.setBackground(Color.decode("#557B83"));
		panelInicioSesion.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("Iniciar sesion");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		label.setBackground(Color.WHITE);
		label.setBounds(10, 11, 185, 29);
		panel.add(label);

		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);

	}

	public static void main(String[] args) {
		new VentantaInicial().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
