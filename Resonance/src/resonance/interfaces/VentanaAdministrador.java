package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import resonance.Resonance;
import resonance.archivos.AdministradorDeArchivos;
import resonance.excepciones.ExistException;
import resonance.excepciones.LimitException;
import resonance.texto.Publicacion;
import resonance.usuario.Usuario;

public class VentanaAdministrador extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private Resonance resonance;
	private VentanaAdministrador instance;
	private Usuario userLogin;
	private JTextPane textEstado;

	public VentanaAdministrador(Resonance resonance) {

		instance = this;
		this.resonance = resonance;
		this.setExtendedState(MAXIMIZED_BOTH);
		Dimension tamano = new Dimension(1366, 768);
		setSize(tamano);
		getContentPane().setLayout(null);
		getContentPane().setSize(tamano);
		getContentPane().setBackground(Color.decode("#5B5151"));

		JPanel panelEstado = new JPanel();
		panelEstado.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEstado.setBackground(SystemColor.controlDkShadow);
		panelEstado.setBounds(0, 0, 631, 739);
		getContentPane().add(panelEstado);
		panelEstado.setLayout(null);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 631, 76);
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.setBackground(SystemColor.controlDkShadow);
		panelEstado.add(panelTitulo);
		panelTitulo.setLayout(null);

		JLabel lblNewLabel = new JLabel("ESTADO DEL GRAFO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 611, 54);
		panelTitulo.add(lblNewLabel);

		textEstado = new JTextPane();
		textEstado.setBounds(10, 87, 611, 641);
		llenarPanelEstado();
		panelEstado.add(textEstado);

		JPanel panelEstadistadisticas = new JPanel();
		panelEstadistadisticas.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEstadistadisticas.setBackground(SystemColor.controlDkShadow);
		panelEstadistadisticas.setBounds(631, 0, 729, 739);
		getContentPane().add(panelEstadistadisticas);
		panelEstadistadisticas.setLayout(null);

		JPanel panelTituloE = new JPanel();
		panelTituloE.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTituloE.setBackground(SystemColor.controlDkShadow);
		panelTituloE.setBounds(0, 0, 729, 76);
		panelEstadistadisticas.add(panelTituloE);
		panelTituloE.setLayout(null);

		JLabel lblEstadisticas = new JLabel("ESTADISTICAS");
		lblEstadisticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadisticas.setForeground(Color.WHITE);
		lblEstadisticas.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblEstadisticas.setBounds(10, 11, 709, 54);
		panelTituloE.add(lblEstadisticas);

		JPanel panelBtnAdministrarUsuarios = new JPanel();
		panelBtnAdministrarUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				VentanaAdministrarUsuarios vA = new VentanaAdministrarUsuarios();
				vA.setVisible(true);
			}
		});
		panelBtnAdministrarUsuarios.setBackground(SystemColor.inactiveCaption);
		panelBtnAdministrarUsuarios.setBounds(303, 595, 208, 70);
		panelEstadistadisticas.add(panelBtnAdministrarUsuarios);
		panelBtnAdministrarUsuarios.setLayout(null);

		JLabel lblAdministrarUsuarios = new JLabel("Administrar");
		lblAdministrarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdministrarUsuarios.setBounds(65, 11, 79, 22);
		panelBtnAdministrarUsuarios.add(lblAdministrarUsuarios);

		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuarios.setBounds(75, 34, 69, 14);
		panelBtnAdministrarUsuarios.add(lblUsuarios);

		JPanel panelEs = new JPanel();
		panelEs.setBackground(Color.GRAY);
		panelEs.setBounds(10, 87, 709, 386);
		panelEstadistadisticas.add(panelEs);
		panelEs.setLayout(null);

		JLabel lblPromedioDeAmigos = new JLabel("Promedio de amigos por usuario:");
		lblPromedioDeAmigos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPromedioDeAmigos.setBounds(10, 42, 304, 14);
		panelEs.add(lblPromedioDeAmigos);

		JLabel lblPromedioDePublicaciones = new JLabel("Promedio de publicaciones por usuario:");
		lblPromedioDePublicaciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPromedioDePublicaciones.setBounds(10, 67, 304, 14);
		panelEs.add(lblPromedioDePublicaciones);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescripcin.setBounds(68, 11, 94, 14);
		panelEs.add(lblDescripcin);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblValor.setBounds(501, 11, 46, 14);
		panelEs.add(lblValor);

		JLabel lblPromedioDeChats = new JLabel("Promedio de chats por usuario:");
		lblPromedioDeChats.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPromedioDeChats.setBounds(10, 92, 304, 14);
		panelEs.add(lblPromedioDeChats);

		JLabel lblLblpromedioamigos = new JLabel(resonance.getAdministradorDeUsuarios().getPromedioDeAmigos() + "");
		lblLblpromedioamigos.setForeground(Color.RED);
		lblLblpromedioamigos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLblpromedioamigos.setBounds(501, 42, 46, 14);
		panelEs.add(lblLblpromedioamigos);

		JLabel lblLblpromediopublicaciones = new JLabel(
				resonance.getAdministradorDeUsuarios().getPromedioDePublicaciones() + "");
		lblLblpromediopublicaciones.setForeground(Color.RED);
		lblLblpromediopublicaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLblpromediopublicaciones.setBounds(501, 68, 46, 14);
		panelEs.add(lblLblpromediopublicaciones);

		JLabel lblLblpromediochats = new JLabel(resonance.getAdministradorDeUsuarios().getPromedioDeChats() + "");
		lblLblpromediochats.setForeground(Color.RED);
		lblLblpromediochats.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLblpromediochats.setBounds(501, 93, 46, 14);
		panelEs.add(lblLblpromediochats);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				instance.setVisible(false);
				instance.dispose();
				ControladoraPrincipal.getI().reiniciar();
				ControladoraPrincipal.getI().setVisible(true);
			}
		});
		btnVolver.setBounds(10, 705, 89, 23);
		panelEstadistadisticas.add(btnVolver);

		JButton btnEnviarMensajeGlobal = new JButton("Enviar mensaje global");
		btnEnviarMensajeGlobal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mensaje = "Este es un mensaje del administrador de la red:  \n";
				mensaje += JOptionPane.showInputDialog("Ingrese el mensaje para la red");

				Publicacion p = new Publicacion(mensaje, new Date(), "DIALOG ADMIN");
				resonance.getAdministradorDeUsuarios().enviarMensajeGlobal(p);

				AdministradorDeArchivos.serializarGrafo(resonance.getAdministradorDeUsuarios());
			}
		});
		btnEnviarMensajeGlobal.setBounds(313, 676, 198, 23);
		panelEstadistadisticas.add(btnEnviarMensajeGlobal);

		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);

	}

	public void llenarPanelEstado() {
		textEstado.setEditable(false);
		if (resonance.getAdministradorDeUsuarios().isEmpty()) {
			textEstado.setText("La red de usuarios esta vacia.");
		} else {

			textEstado.setText(resonance.getAdministradorDeUsuarios().toString());
		}
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

	public Resonance getResonance() {
		return resonance;
	}

	public boolean alreadyExist(String name) {
		return resonance.alreadyExist(name);
	}
}
