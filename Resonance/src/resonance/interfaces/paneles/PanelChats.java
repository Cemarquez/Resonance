package resonance.interfaces.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import resonance.texto.Chat;
import resonance.texto.Mensaje;
import resonance.usuario.Usuario;

public class PanelChats extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JScrollPane scroll;
	private JPanel panelScroll;
	private JPanel panelMensajes;
	private JPanel panelCrearMensaje;
	private int numChats;
	private int numContactos;
	private JScrollPane scrollContactos;
	private JPanel panelContactos;
	private JPanel panelBtnIniciarChat;
	private JLabel labelSeleccionaChat;
	private JPanel panelChat;
	private Usuario userLogin;

	/**
	 * Create the panel.
	 */
	public PanelChats(Usuario userLogin) {
		this.userLogin = userLogin;
		this.numChats = 30;
		this.numContactos = 5;
		setBackground(SystemColor.controlDkShadow);
		setSize(1095, 717);
		setLayout(new GridLayout(0, 2, 0, 0));

		panelMensajes = new JPanel();
		panelMensajes.setBackground(SystemColor.controlDkShadow);
		add(panelMensajes);
		panelMensajes.setLayout(null);
		
		

		panelCrearMensaje = new JPanel();
		panelCrearMensaje.setBackground(SystemColor.controlDkShadow);
		add(panelCrearMensaje);
		panelCrearMensaje.setLayout(null);

		panelChat = new JPanel();
		panelChat.setBounds(0, 0, 455, 717);
		panelChat.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelChat.setBackground(SystemColor.controlDkShadow);

		panelCrearMensaje.add(panelChat);
		panelChat.setLayout(null);

		labelSeleccionaChat = new JLabel("Selecciona un mensaje o inicia un chat");
		labelSeleccionaChat.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		labelSeleccionaChat.setBounds(25, 221, 420, 32);
		panelChat.add(labelSeleccionaChat);

		panelBtnIniciarChat = new JPanel();
		panelBtnIniciarChat.setBorder(new LineBorder(new Color(0, 0, 0), 50, true));
		panelBtnIniciarChat.setBackground(SystemColor.controlDkShadow);
		panelBtnIniciarChat.setForeground(Color.BLACK);
		panelBtnIniciarChat.setBounds(143, 288, 168, 40);
		panelChat.add(panelBtnIniciarChat);
		panelBtnIniciarChat.setLayout(null);
		panelBtnIniciarChat.addMouseListener(this);

		JLabel lblIniciarChat = new JLabel("Iniciar chat");
		lblIniciarChat.setForeground(Color.WHITE);
		lblIniciarChat.setVerticalAlignment(SwingConstants.TOP);
		lblIniciarChat.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblIniciarChat.setBounds(36, 11, 85, 22);
		panelBtnIniciarChat.add(lblIniciarChat);
		
		panelContactos = new JPanel();
		panelContactos.setBackground(Color.WHITE);
		panelContactos.setBounds(454, 0, 93, 717);
		panelContactos.setPreferredSize(new Dimension(93, 717 * numContactos));
		panelContactos.setBorder(BorderFactory.createEmptyBorder());

		scrollContactos = new JScrollPane(panelContactos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollContactos.setViewportBorder(null);
		scrollContactos.setBounds(455, 0, 93, 728);
		scrollContactos.setSize(93, 717);
		scrollContactos.setViewportBorder(null);
		panelContactos.setLayout(new BoxLayout(panelContactos, BoxLayout.Y_AXIS));

		JPanel panelTituloContactos = new JPanel();
		panelTituloContactos.setBackground(Color.WHITE);
		panelTituloContactos.setMaximumSize(new Dimension(153, 40));
		panelContactos.add(panelTituloContactos);
		panelTituloContactos.setLayout(null);

		JLabel lblContactos = new JLabel("Contactos");
		lblContactos.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblContactos.setBounds(0, 11, 83, 14);
		panelTituloContactos.add(lblContactos);

		panelCrearMensaje.add(scrollContactos);

		panelScroll = new JPanel();
		panelScroll.setBackground(SystemColor.controlDkShadow);
		panelScroll.setPreferredSize(new Dimension(537, 65 * numChats));
		scroll = new JScrollPane(panelScroll, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		scroll.setLocation(6, 73);
		scroll.setSize(537, 636);
		panelMensajes.add(scroll);
		panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.Y_AXIS));

		JPanel panelBuscar = new JPanel();
		panelBuscar.setBackground(SystemColor.controlDkShadow);
		panelBuscar.setPreferredSize(new Dimension(1040, 60));
		panelBuscar.setMaximumSize(new Dimension(1040, 50));
		panelScroll.add(panelBuscar);
		panelBuscar.setLayout(null);

		JLabel labelBuscar = new JLabel("Buscar");
		labelBuscar.setForeground(Color.BLACK);
		labelBuscar.setBounds(0, 0, 110, 50);
		panelBuscar.add(labelBuscar);
		labelBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		textField = new JTextField();
		textField.setBackground(SystemColor.windowBorder);
		textField.setBounds(61, 15, 152, 26);
		panelBuscar.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.controlDkShadow);
		panel.setBounds(0, 0, 547, 71);
		panelMensajes.add(panel);
				panel.setLayout(null);
		
				JLabel lblTituloMensajes = new JLabel("Mensajes");
				lblTituloMensajes.setForeground(Color.WHITE);
				lblTituloMensajes.setBounds(10, 0, 184, 71);
				panel.add(lblTituloMensajes);
				lblTituloMensajes.setFont(new Font("Segoe UI", Font.PLAIN, 40));



		crearPanelesMensajesReal();
		crearListaContactos();

	}



	public void crearPanelesMensajesReal() {

		ArrayList<Chat> chats = userLogin.covertirArrayList(userLogin.getChats());

		for (int i = 0; i < chats.size(); i++) {

			if (chats.get(i).getMensajes().getUltimo() != null) {

				JPanel panelMensaje = crearPanelMensajeReal(chats.get(i).getUsuario(), chats.get(i));
				panelScroll.add(panelMensaje);

			}

		}

	}

	public JPanel crearPanelMensajeReal(Usuario user, Chat chat) {

		Mensaje mensaje = chat.getMensajes().getUltimo();

		String mensajeTexto = mensaje.getMensaje();
		String fecha = mensaje.getFecha().toString();

		JPanel panelMensaje = new JPanel();
		panelMensaje.setAlignmentY(1.0f);
		panelMensaje.setBackground(SystemColor.controlDkShadow);
		panelScroll.add(panelMensaje);
		panelMensaje.setLayout(null);
		panelMensaje.setMaximumSize(new Dimension(1040, 65));

		JLabel lblFoto = new JLabel("");
		lblFoto.setBounds(2, 5, 50, 50);
		lblFoto.setIcon(new ImageIcon(PanelChats.class.getResource("/imagenes/Logo1Reducido.png")));
		panelMensaje.add(lblFoto);

		JLabel lblNombre = new JLabel(user.getPerfil().getNombre());
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(65, 5, 50, 22);
		lblNombre.setVerticalAlignment(SwingConstants.TOP);
		panelMensaje.add(lblNombre);

		JLabel lblUsuario = new JLabel("@" + user.getID());
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblUsuario.setBounds(121, 11, 62, 14);
		panelMensaje.add(lblUsuario);

		JLabel lblFecha = new JLabel(fecha);
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblFecha.setBounds(416, 5, 101, 14);
		panelMensaje.add(lblFecha);

		JLabel lblMensajeQueEscribe = new JLabel(mensajeTexto);
		lblMensajeQueEscribe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMensajeQueEscribe.setBounds(75, 30, 379, 22);
		panelMensaje.add(lblMensajeQueEscribe);

		JSeparator separator = new JSeparator();
		separator.setBounds(2, 63, 514, 2);
		panelMensaje.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(2, 2, 514, 2);
		panelMensaje.add(separator_1);

		return panelMensaje;
	}




	public void crearListaContactos() {

		ArrayList<Usuario> amigos = userLogin.getAmigos();

		for (int i = 0; i < amigos.size(); i++) {
			JPanel panelContacto = new JPanel();
			panelContacto.setMaximumSize(new Dimension(153, 77));
			panelContactos.add(panelContacto);
			panelContacto.setLayout(null);

			JLabel lblFotoContacto = new JLabel("");
			lblFotoContacto.setIcon(new ImageIcon(PanelChats.class.getResource("/imagenes/Logo1Reducido.png")));
			lblFotoContacto.setBounds(10, 0, 57, 49);
			panelContacto.add(lblFotoContacto);

			JLabel lblNombreContacto = new JLabel(amigos.get(i).getPerfil().getNombre());
			lblNombreContacto.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lblNombreContacto.setBounds(20, 46, 46, 14);
			panelContacto.add(lblNombreContacto);

			JLabel lblUsuarioContacto = new JLabel("@" + amigos.get(i).getID());
			lblUsuarioContacto.setFont(new Font("Segoe UI", Font.PLAIN, 11));
			lblUsuarioContacto.setBounds(10, 60, 67, 14);
			panelContacto.add(lblUsuarioContacto);
			final Usuario amigo = amigos.get(i);

			panelContacto.addMouseListener(new MouseAdapter() {


				@Override
				public void mousePressed(MouseEvent e) {

					PanelConversacionUsuario conversacion = new PanelConversacionUsuario(userLogin, amigo);

					panelChat.setVisible(false);
					panelCrearMensaje.add(conversacion);
					conversacion.setBounds(0, 0, 455, 717);
					conversacion.setVisible(true);
				}

			});

		}
	}



	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == panelBtnIniciarChat) {

			JOptionPane.showMessageDialog(null, "Seleccione un contacto para iniciar chat");

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}