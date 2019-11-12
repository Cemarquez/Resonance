/**
 * 
 */
package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import resonance.archivos.AdministradorDeArchivos;
import resonance.usuario.Perfil;
import resonance.usuario.Usuario;
import rojeru_san.componentes.RSDateChooser;

/**
 * @author Esteban
 *
 */
public class VentanaRegistro extends JFrame implements ActionListener {
	private JTextField tfNombre;
	private JTextField tfUsername;
	private JPasswordField tfContrasena;
	private JTextField tfCorreo;
	private VentantaLogIN vLogin;
	private RSDateChooser dateChooser;
	private JCheckBox checkCondiciones;
	private VentanaRegistro instance;

	public VentanaRegistro() {
		instance = this;
		this.vLogin = ControladoraPrincipal.getI();
		this.setExtendedState(MAXIMIZED_BOTH);
		Dimension tamano = new Dimension(1366, 768);
		setSize(tamano);
		getContentPane().setLayout(null);
		getContentPane().setSize(tamano);
		getContentPane().setBackground(Color.decode("#5B5151"));

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

		JPanel panelContinuar = new JPanel();
		panelContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				String nombre = tfNombre.getText();
				String username = tfUsername.getText();
				String contrasena = tfContrasena.getText();
				String correo = tfCorreo.getText();
				Date fechaNacimiento = dateChooser.getDatoFecha();

				if (nombre.equals("") || username.equals("") || contrasena.equals("") || correo.equals("")) {
					// Mensaje de error de campo faltante
				} else {
					if (AdministradorDeArchivos.existUser(username)) {
						// Mensaje de error de usuario ya existente
					} else {
						Perfil perfil = new Perfil(nombre, username, correo, "", contrasena);
						Usuario userLogin = new Usuario(username, perfil);
						vLogin.anadirUsuario(username, userLogin);
						vLogin.setUserLogin(userLogin);
						AdministradorDeArchivos.crearCarpetaUsuario(username);
//						AdministradorDeArchivos.serializarGrafo(ControladoraPrincipal.getI().getResonance());

						VentanaSubirFotoPerfil miVFotoPerfil = new VentanaSubirFotoPerfil();
						miVFotoPerfil.setVisible(true);

						instance.dispose();

					}
				}

			}
		});

		panelContinuar.setBackground(Color.GRAY);
		panelContinuar.setBounds(505, 483, 142, 47);
		panel.add(panelContinuar);
		panelContinuar.setLayout(null);

		JLabel lblContinuar = new JLabel("Continuar");
		lblContinuar.setBounds(22, 11, 91, 29);
		lblContinuar.setForeground(Color.WHITE);
		lblContinuar.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		panelContinuar.add(lblContinuar);

		checkCondiciones = new JCheckBox("Acepto los terminos y condiciones");
		checkCondiciones.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		checkCondiciones.setBounds(190, 507, 214, 23);
		panel.add(checkCondiciones);

		tfNombre = new JTextField();
		tfNombre.setForeground(new Color(0, 0, 0));
		tfNombre.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tfNombre.setBounds(104, 151, 292, 23);
		tfNombre.setBorder(null);
		panel.add(tfNombre);
		tfNombre.setColumns(10);

		tfUsername = new JTextField();
		tfUsername.setForeground(Color.BLACK);
		tfUsername.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tfUsername.setColumns(10);
		tfUsername.setBorder(null);
		tfUsername.setBounds(104, 235, 292, 23);
		panel.add(tfUsername);

		tfContrasena = new JPasswordField();
		tfContrasena.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tfContrasena.setBackground(new Color(255, 255, 255));
		tfContrasena.setBounds(104, 312, 292, 20);
		tfContrasena.setBorder(null);
		panel.add(tfContrasena);

		tfCorreo = new JTextField();
		tfCorreo.setForeground(Color.BLACK);
		tfCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tfCorreo.setColumns(10);
		tfCorreo.setBorder(null);
		tfCorreo.setBounds(104, 385, 292, 23);
		panel.add(tfCorreo);

		dateChooser = new RSDateChooser();
		dateChooser.setColorDiaActual(Color.BLACK);
		dateChooser.setColorButtonHover(Color.BLACK);
		dateChooser.setColorForeground(Color.DARK_GRAY);
		dateChooser.setColorBackground(Color.GRAY);
		dateChooser.setBounds(433, 157, 240, 24);
		dateChooser.setDatoFecha(new Date());
		panel.add(dateChooser);

		JLabel lblLogoIcon = new JLabel("New label");
		lblLogoIcon.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/imagenes/Logo1Reducido.png")));
		lblLogoIcon.setBounds(297, 11, 50, 61);
		panel.add(lblLogoIcon);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
}
