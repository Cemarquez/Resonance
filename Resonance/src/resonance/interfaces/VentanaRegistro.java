/**
 * 
 */
package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import rojeru_san.componentes.RSDateChooser;

/**
 * @author Esteban
 *
 */
public class VentanaRegistro extends JFrame implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;


	public VentanaRegistro() {
		getContentPane().setBackground(Color.DARK_GRAY);

		this.setExtendedState(MAXIMIZED_BOTH);
		Dimension tamano = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(tamano);
		getContentPane().setLayout(null);
		getContentPane().setSize(tamano);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(((int) tamano.getWidth() / 2) - 300, ((int) tamano.getHeight() / 2) - 320,
				(int) tamano.getWidth() / 2, ((int) tamano.getHeight() / 2) + 200);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCreaTuCuenta = new JLabel("Crea tu cuenta");
		lblCreaTuCuenta.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblCreaTuCuenta.setForeground(new Color(0, 0, 0));
		lblCreaTuCuenta.setBounds(47, 50, 169, 33);
		panel.add(lblCreaTuCuenta);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		lblNombre.setBounds(104, 110, 169, 33);
		panel.add(lblNombre);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setForeground(new Color(160, 160, 160));
		separator.setBounds(104, 176, 300, 5);
		panel.add(separator);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setBackground(Color.GRAY);
		lblNombreDeUsuario.setForeground(Color.DARK_GRAY);
		lblNombreDeUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		lblNombreDeUsuario.setBounds(103, 201, 187, 33);
		panel.add(lblNombreDeUsuario);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.controlShadow);
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(104, 263, 300, 5);
		panel.add(separator_1);

		JLabel lblClave = new JLabel("Clave");
		lblClave.setForeground(Color.DARK_GRAY);
		lblClave.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		lblClave.setBounds(104, 279, 214, 33);
		panel.add(lblClave);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(SystemColor.controlShadow);
		separator_2.setBackground(Color.LIGHT_GRAY);
		separator_2.setBounds(104, 337, 300, 5);
		panel.add(separator_2);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.DARK_GRAY);
		lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		lblCorreo.setBounds(104, 353, 214, 33);
		panel.add(lblCorreo);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(SystemColor.controlShadow);
		separator_3.setBackground(Color.LIGHT_GRAY);
		separator_3.setBounds(104, 412, 300, 5);
		panel.add(separator_3);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setForeground(Color.DARK_GRAY);
		lblFechaDeNacimiento.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		lblFechaDeNacimiento.setBounds(433, 110, 214, 33);
		panel.add(lblFechaDeNacimiento);

		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				VentanaSubirFotoPerfil miVFotoPerfil = new VentanaSubirFotoPerfil();

				miVFotoPerfil.setVisible(true);

			}
		});




		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(505, 483, 142, 47);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblContinuar = new JLabel("Continuar");
		lblContinuar.setBounds(22, 11, 91, 29);
		lblContinuar.setForeground(Color.WHITE);
		lblContinuar.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		panel_1.add(lblContinuar);

		JCheckBox chckbxAceptoLosTerminos = new JCheckBox("Acepto los terminos y condiciones");
		chckbxAceptoLosTerminos.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		chckbxAceptoLosTerminos.setBounds(190, 507, 214, 23);
		panel.add(chckbxAceptoLosTerminos);

		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textField.setBounds(104, 151, 292, 23);
		textField.setBorder(null);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(104, 235, 292, 23);
		panel.add(textField_1);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setBounds(104, 312, 292, 20);
		passwordField.setBorder(null);
		panel.add(passwordField);

		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBounds(104, 385, 292, 23);
		panel.add(textField_2);

		RSDateChooser dateChooser = new RSDateChooser();
		dateChooser.setColorDiaActual(Color.BLACK);
		dateChooser.setColorButtonHover(Color.BLACK);
		dateChooser.setColorForeground(Color.DARK_GRAY);
		dateChooser.setColorBackground(Color.GRAY);
		dateChooser.setBounds(433, 157, 240, 24);
		panel.add(dateChooser);

		JLabel lblLogoIcon = new JLabel("New label");
		lblLogoIcon.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/imagenes/Logo1Reducido.png")));
		lblLogoIcon.setBounds(297, 11, 50, 61);
		panel.add(lblLogoIcon);

	}


	
	public static void main(String[] args) {
		new VentanaRegistro().setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {


	}
}
