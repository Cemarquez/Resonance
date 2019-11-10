package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

import resonance.Resonance;
import resonance.archivos.AdministradorDeArchivos;
import resonance.excepciones.ExistException;
import resonance.excepciones.LimitException;
import resonance.usuario.Usuario;

public class VentantaLogIN extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPasswordField tfContrasena;
	private JTextField tfUsername;
	private JPanel panelBanner;
	private JCheckBox checkCondiciones;
	private JLabel btnIniciarSesion;
	private JLabel btnCrearCuenta;
	private Resonance resonance;
	private VentantaLogIN instance;
	private Usuario userLogin;

	public VentantaLogIN(Resonance resonance) {

		instance = this;
		this.resonance = resonance;
		this.setExtendedState(MAXIMIZED_BOTH);
		Dimension tamano = new Dimension(1366, 768);
		setSize(tamano);
		getContentPane().setLayout(null);
		getContentPane().setSize(tamano);
		getContentPane().setBackground(Color.decode("#5B5151"));
		panelBanner = new JPanel();
		panelBanner.setBackground(Color.decode("#557B83"));
		panelBanner.setBounds(0, 0, (int) tamano.getWidth() / 2, (int) tamano.getHeight());
		getContentPane().add(panelBanner);
		panelBanner.setLayout(null);

		JLabel lblResonance = new JLabel("");
		lblResonance.setIcon(new ImageIcon(VentantaLogIN.class.getResource("/imagenes/segunda.jpg")));
		lblResonance.setFont(new Font("Century Gothic", Font.PLAIN, 33));
		lblResonance.setForeground(Color.WHITE);
		lblResonance.setBackground(Color.WHITE);
		lblResonance.setBounds(0, 0, 683, 738);
		panelBanner.add(lblResonance);

		JPanel panelInicioSesion = new JPanel();
		panelInicioSesion.setBorder(null);
		panelInicioSesion.setBackground(Color.decode("#5B5151"));
		panelInicioSesion.setBounds(711, 0, (int) tamano.getWidth() / 2, (int) tamano.getHeight());
		getContentPane().add(panelInicioSesion);
		panelInicioSesion.setLayout(null);

		JLabel lblIniciaSesionO = new JLabel("Inicia sesion o registrate");
		lblIniciaSesionO.setForeground(Color.WHITE);
		lblIniciaSesionO.setFont(new Font("Century Gothic", Font.PLAIN, 33));
		lblIniciaSesionO.setBackground(Color.WHITE);
		lblIniciaSesionO.setBounds(panelInicioSesion.getWidth() / 4, 87, 439, panelInicioSesion.getHeight() / 10);
		panelInicioSesion.add(lblIniciaSesionO);

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(Color.LIGHT_GRAY);
		lblUsuario.setFont(new Font("Century Gothic", Font.BOLD, 33));
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setBounds(panelInicioSesion.getWidth() / 4, 224, 439, panelInicioSesion.getHeight() / 9);
		panelInicioSesion.add(lblUsuario);

		JLabel lblClave = new JLabel("CLAVE");
		lblClave.setForeground(Color.LIGHT_GRAY);
		lblClave.setFont(new Font("Century Gothic", Font.BOLD, 33));
		lblClave.setBackground(Color.WHITE);
		lblClave.setBounds(panelInicioSesion.getWidth() / 4, 338, 439, panelInicioSesion.getHeight() / 8);
		panelInicioSesion.add(lblClave);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(panelInicioSesion.getWidth() / 4, 326, 389, panelInicioSesion.getHeight() / 8);
		panelInicioSesion.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(panelInicioSesion.getWidth() / 4, 443, 389, 2);
		panelInicioSesion.add(separator_1);

		tfContrasena = new JPasswordField();
		tfContrasena.addKeyListener(this);
		tfContrasena.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfContrasena.setText("");
			}
		});
		tfContrasena.setBackground(Color.decode("#5B5151"));
		tfContrasena.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		tfContrasena.setForeground(Color.WHITE);
		tfContrasena.setText("password");

		tfContrasena.setBorder(null);
		tfContrasena.setBounds(panelInicioSesion.getWidth() / 4, 403, panelInicioSesion.getHeight() / 4, 37);
		panelInicioSesion.add(tfContrasena);

		tfUsername = new JTextField();
		tfUsername.addKeyListener(this);
		tfUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				tfUsername.setText("");
			}
		});
		tfUsername.setForeground(Color.WHITE);
		tfUsername.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		tfUsername.setText("Ingrese su nombre de usuario");
		tfUsername.setBorder(null);
		tfUsername.setBackground(Color.decode("#5B5151"));
		tfUsername.setBounds(panelInicioSesion.getWidth() / 4, 290, 389, 31);
		panelInicioSesion.add(tfUsername);
		tfUsername.setColumns(10);

		checkCondiciones = new JCheckBox("Acepto los terminos y condiciones");
		checkCondiciones.setSelected(true);
		checkCondiciones.setForeground(Color.WHITE);
		checkCondiciones.setBorder(null);
		checkCondiciones.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		checkCondiciones.setBackground(Color.decode("#5B5151"));
		checkCondiciones.setBounds(panelInicioSesion.getWidth() / 4, 516, 333, 23);
		panelInicioSesion.add(checkCondiciones);

		JPanel panelSesion = new JPanel();
		panelSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				String username = tfUsername.getText();
				String password = tfContrasena.getText();
				userLogin = null;
				if (resonance.alreadyExist(username)) {
					userLogin = resonance.obtenerUsuario(username);
				} else if (AdministradorDeArchivos.existUser(username)) {
					userLogin = AdministradorDeArchivos.deserializarUser(username);
					try {
						resonance.anadirUsuario(username, userLogin);
					} catch (LimitException | ExistException e) {

						e.printStackTrace();
					}

				}

				if (userLogin == null) {
					// Mensaje de error que no existe un usuario con ese nombre de usuario en la
					// base de datos.
					System.out.println("nonas");
				} else {
					if (password.equals(userLogin.getPerfil().getContrasena())) {
						VentanaRaiz vTotal = new VentanaRaiz();
						vTotal.setVisible(true);
						instance.dispose();
					}
				}

			}
		});
		panelSesion.setBounds(151, 595, 195, 47);
		panelSesion.setBackground(Color.decode("#557B83"));
		panelInicioSesion.add(panelSesion);
		panelSesion.setLayout(null);

		btnIniciarSesion = new JLabel("Iniciar sesion");
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		btnIniciarSesion.setBackground(Color.WHITE);
		btnIniciarSesion.setBounds(10, 11, 185, 29);
		panelSesion.add(btnIniciarSesion);

		JPanel registro = new JPanel();
		registro.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				VentanaRegistro miVRegistro = new VentanaRegistro();
				miVRegistro.setVisible(true);
				instance.dispose();

			}
		});
		registro.setLayout(null);
		registro.setBackground(new Color(85, 123, 131));
		registro.setBounds(430, 595, 189, 47);
		panelInicioSesion.add(registro);

		btnCrearCuenta = new JLabel("Crear cuenta");
		btnCrearCuenta.setForeground(Color.WHITE);
		btnCrearCuenta.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		btnCrearCuenta.setBackground(Color.WHITE);
		btnCrearCuenta.setBounds(0, 11, 185, 29);
		registro.add(btnCrearCuenta);

		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	/**
	 * Cerrar ventana con tecla escape ESC
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

			System.exit(0);

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public Usuario getUserLogin() {

		return userLogin;
	}

	public boolean isLogin() {
		if (userLogin != null)
			return true;

		return false;
	}

	public void setUserLogin(Usuario user) {
		this.userLogin = user;
	}

	public void anadirUsuario(String nombre, Usuario perfil) {
		try {
			resonance.anadirUsuario(nombre, perfil);
		} catch (LimitException | ExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean alreadyExist(String name) {
		return resonance.alreadyExist(name);
	}

}
