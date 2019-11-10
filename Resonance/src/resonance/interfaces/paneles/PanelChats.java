package resonance.interfaces.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

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


	/**
	 * Create the panel.
	 */
	public PanelChats() {
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




		crearPanelEjemplo();
		crearPanelesMensajes();
		crearListaContactosEjemplo();
	}

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					PanelChats frame = new PanelChats();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public void crearPanelEjemplo() {
		JPanel panelMensajeEjemplo = new JPanel();
		panelMensajeEjemplo.setAlignmentY(1.0f);
		panelMensajeEjemplo.setBackground(SystemColor.controlDkShadow);
		panelScroll.add(panelMensajeEjemplo);
		panelMensajeEjemplo.setLayout(null);
		panelMensajeEjemplo.setMaximumSize(new Dimension(1040, 65));

		JLabel lblFoto = new JLabel("");
		lblFoto.setBounds(2, 5, 50, 50);
		lblFoto.setIcon(new ImageIcon(PanelChats.class.getResource("/imagenes/Logo1Reducido.png")));
		panelMensajeEjemplo.add(lblFoto);

		JLabel lblNombre = new JLabel("Pepito");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(65, 5, 50, 22);
		lblNombre.setVerticalAlignment(SwingConstants.TOP);
		panelMensajeEjemplo.add(lblNombre);

		JLabel lblUsuario = new JLabel("@Pepito");
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblUsuario.setBounds(121, 11, 62, 14);
		panelMensajeEjemplo.add(lblUsuario);

		JLabel lblFecha = new JLabel("2 de Junio del 2020");
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblFecha.setBounds(416, 5, 101, 14);
		panelMensajeEjemplo.add(lblFecha);

		JLabel lblMensajeQueEscribe = new JLabel("Mensaje de Pepito");
		lblMensajeQueEscribe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMensajeQueEscribe.setBounds(75, 30, 379, 22);
		panelMensajeEjemplo.add(lblMensajeQueEscribe);

		JSeparator separator = new JSeparator();
		separator.setBounds(2, 63, 514, 2);
		panelMensajeEjemplo.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(2, 2, 514, 2);
		panelMensajeEjemplo.add(separator_1);


	}

	public void crearPanelesMensajes() {


		for (int i = 0; i <= numChats; i++) {




			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlDkShadow);
			// panel.setBounds(0, y, 527, 65);
			panelScroll.add(panel);
			panel.setLayout(null);

			JLabel lblFoto = new JLabel("");
			lblFoto.setBounds(5, 5, 50, 50);
			lblFoto.setIcon(new ImageIcon(PanelChats.class.getResource("/imagenes/Logo1Reducido.png")));
			panel.add(lblFoto);

			JLabel lblNombre = new JLabel("Pepito");
			lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblNombre.setBounds(65, 5, 50, 22);
			lblNombre.setVerticalAlignment(SwingConstants.TOP);
			panel.add(lblNombre);

			JLabel lblUsuario = new JLabel("@Pepito");
			lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			lblUsuario.setBounds(121, 11, 62, 14);
			panel.add(lblUsuario);

			JLabel lblFecha = new JLabel("2 de Junio del 2020");
			lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 11));
			lblFecha.setBounds(416, 5, 101, 14);
			panel.add(lblFecha);

			JLabel lblMensajeQueEscribe = new JLabel("Mensaje que escribe la persona");
			lblMensajeQueEscribe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblMensajeQueEscribe.setBounds(75, 30, 379, 22);
			panel.add(lblMensajeQueEscribe);

			JSeparator separator = new JSeparator();
			separator.setBounds(2, 63, 514, 2);
			panel.add(separator);

			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(2, 2, 514, 2);
			panel.add(separator_1);

			panel.setMaximumSize(new Dimension(1040, 65));

			int altura = scroll.getHeight();
			int ancho = scroll.getWidth();


		}

	}

	public void crearListaContactosEjemplo() {

		for (int i = 0; i <= 20; i++) {

			JPanel panelContacto = new JPanel();
			panelContacto.setMaximumSize(new Dimension(153, 77));
			panelContactos.add(panelContacto);
			panelContacto.setLayout(null);

			JLabel lblFotoContacto = new JLabel("");
			lblFotoContacto.setIcon(new ImageIcon(PanelChats.class.getResource("/imagenes/Logo1Reducido.png")));
			lblFotoContacto.setBounds(10, 0, 57, 49);
			panelContacto.add(lblFotoContacto);

			JLabel lblNombreContacto = new JLabel("Pepito");
			lblNombreContacto.setFont(new Font("Segoe UI", Font.BOLD, 11));
			lblNombreContacto.setBounds(20, 46, 46, 14);
			panelContacto.add(lblNombreContacto);

			JLabel lblUsuarioContacto = new JLabel("@Pepito");
			lblUsuarioContacto.setFont(new Font("Segoe UI", Font.PLAIN, 11));
			lblUsuarioContacto.setBounds(10, 60, 67, 14);
			panelContacto.add(lblUsuarioContacto);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == panelBtnIniciarChat) {

			PanelConversacion chat = new PanelConversacion();
			panelChat.setVisible(false);
			panelCrearMensaje.add(chat);

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
