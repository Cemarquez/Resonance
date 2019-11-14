package resonance.interfaces.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import resonance.archivos.AdministradorDeArchivos;
import resonance.estructura.ListaMensajes;
import resonance.interfaces.ControladoraPrincipal;
import resonance.interfaces.misc.RoundJTextArea;
import resonance.interfaces.misc.RoundJTextPane;
import resonance.texto.Mensaje;
import resonance.usuario.Usuario;

public class PanelConversacionUsuario extends JPanel implements ActionListener, MouseListener {

	private PanelConversacionUsuario instance;
	private JTextField textMensaje;
	private JPanel panelMensajes;
	private JScrollPane scrollMensajes;
	private JLabel btnEnviar;
	private ArrayList<RoundJTextPane> historialChat;
	private RoundJTextArea textArea;
	private Usuario userLogin, user;

	/**
	 * Create the panel.
	 */
	public PanelConversacionUsuario(Usuario userLogin, Usuario user) {
		this.user = user;
		this.userLogin = userLogin;
		instance = this;
		historialChat = new ArrayList<>();
		setBackground(Color.LIGHT_GRAY);
		setSize(new Dimension(455, 717));
		setLayout(null);

		JPanel panelNombreUsuario = new JPanel();
		panelNombreUsuario.setBounds(0, 0, 455, 72);
		add(panelNombreUsuario);
		panelNombreUsuario.setLayout(null);

		JLabel labelNombre = new JLabel(user.getPerfil().getNombre());
		labelNombre.setBounds(10, 0, 86, 30);
		panelNombreUsuario.add(labelNombre);
		labelNombre.setFont(new Font("Segoe UI", Font.BOLD, 18));

		JLabel labelUsuario = new JLabel("@" + user.getID());
		labelUsuario.setBounds(10, 21, 57, 30);
		panelNombreUsuario.add(labelUsuario);
		labelUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		textMensaje = new JTextField();

		panelMensajes = new JPanel();
		panelMensajes.setBackground(Color.GRAY);
		panelMensajes.setBounds(0, 52, 455, 609);
		panelMensajes.setSize(new Dimension(455, 630));

		scrollMensajes = new JScrollPane(panelMensajes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// Manda el chat a lo ultimo

		scrollMensajes.getVerticalScrollBar().setValue(scrollMensajes.getVerticalScrollBar().getMaximum());
		scrollMensajes.setSize(455, 630);
		scrollMensajes.setBounds(0, 72, 455, 587);
		add(scrollMensajes);

		JPanel panelEscribirMensaje = new JPanel();
		panelEscribirMensaje.setBounds(0, 660, 455, 49);
		add(panelEscribirMensaje);
		panelEscribirMensaje.setLayout(new BorderLayout(0, 0));

		textArea = new RoundJTextArea();
		JScrollPane jp = new JScrollPane(textArea);
		panelEscribirMensaje.add(jp, BorderLayout.CENTER);

		btnEnviar = new JLabel("");
		btnEnviar.addMouseListener(this);
		btnEnviar.setIcon(new ImageIcon(PanelConversacionUsuario.class.getResource("/imagenes/icono_enviar_chat.png")));
		panelEscribirMensaje.add(btnEnviar, BorderLayout.EAST);

		textMensaje.setColumns(10);

		try {
			cargarMensajesEjemplo();
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cargarMensajesEjemplo() throws BadLocationException {
		panelMensajes.setLayout(new BoxLayout(panelMensajes, BoxLayout.Y_AXIS));

		if (userLogin.getChat(user.getID()) == null) {
			userLogin.crearChat(user);
			user.crearChat(userLogin);
		}

		ListaMensajes mensajes = userLogin.getChat(user.getID()).getMensajes();

		mensajes.irAlPrimero();

		for (int i = 0; i < mensajes.getLongitud(); i++) {

			Mensaje actual = mensajes.getActual();

			if (actual.getIdUser().equals(userLogin.getID())) {
				RoundJTextPane mensaje = generarPanelMensaje(actual.getMensaje(), "propio", userLogin.getID(),
						actual.getFecha());
				panelMensajes.add(mensaje);
				historialChat.add(mensaje);
			} else {
				RoundJTextPane mensaje = generarPanelMensaje(actual.getMensaje(), "otro", user.getID(),
						actual.getFecha());
				panelMensajes.add(mensaje);
				historialChat.add(mensaje);
			}

			mensajes.irSiguiente();

		}

		// panelMensajes.add(mensaje);

		// historialChat.add(mensaje);

	}

	public RoundJTextPane generarPanelMensaje(String mensaje, String tipo, String user, Date fecha) {

		String salida = "";

		salida += "@" + user + "  " + toStringFecha(fecha) + "\n";
		salida += mensaje;
		RoundJTextPane panelMensajeCreado = new RoundJTextPane();
		if (tipo.equals("propio")) {
			panelMensajeCreado.setBackground(Color.LIGHT_GRAY);
		}

		panelMensajeCreado.setEditable(false);
		// panelMensajeCreado.setEnabled(false);
		setJTextPaneFont(panelMensajeCreado, new Font("Segoe UI", Font.PLAIN, 14), Color.BLACK);

		if (mensaje.length() > 33) {
			panelMensajeCreado.setMaximumSize(new Dimension(200, 50 + ((mensaje.length() / 33) + 1) * 20));
			panelMensajeCreado.setText(salida);
		} else {
			panelMensajeCreado.setMaximumSize(new Dimension(200, 100));
			panelMensajeCreado.setText(salida);
		}

		// }

		return panelMensajeCreado;

	}

	public String toStringFecha(Date fecha) {
		String f = "";
		int d = fecha.getDay();
		int m = fecha.getMonth();
		int a = fecha.getYear();

		f = d + "/" + m + "/" + a + "/" + " " + fecha.getHours() + ":" + fecha.getMinutes();
		return f;
	}

	public static void setJTextPaneFont(JTextPane jtp, Font font, Color c) {
		// Start with the current input attributes for the JTextPane. This
		// should ensure that we do not wipe out any existing attributes
		// (such as alignment or other paragraph attributes) currently
		// set on the text area.
		MutableAttributeSet attrs = jtp.getInputAttributes();

		// Set the font family, size, and style, based on properties of
		// the Font object. Note that JTextPane supports a number of
		// character attributes beyond those supported by the Font class.
		// For example, underline, strike-through, super- and sub-script.
		StyleConstants.setFontFamily(attrs, font.getFamily());
		StyleConstants.setFontSize(attrs, font.getSize());
		StyleConstants.setItalic(attrs, (font.getStyle() & Font.ITALIC) != 0);
		StyleConstants.setBold(attrs, (font.getStyle() & Font.BOLD) != 0);

		// Set the font color
		StyleConstants.setForeground(attrs, c);

		// Retrieve the pane's document object
		StyledDocument doc = jtp.getStyledDocument();

		// Replace the style for the entire document. We exceed the length
		// of the document by 1 so that text entered at the end of the
		// document uses the attributes.
		doc.setCharacterAttributes(0, doc.getLength() + 1, attrs, false);
	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getSource() == btnEnviar) {

			String mensaje = textArea.getText();

			if (!mensaje.equals("")) {

				Date date = new Date();

				RoundJTextPane mensajeCreado = generarPanelMensaje(mensaje, "propio", userLogin.getID(), date);

				// RoundJTextPane ultimoMensaje = historialChat.get(historialChat.size() - 1);

				userLogin.getChat(user.getID()).anadirMensaje(new Mensaje(mensaje, date, userLogin.getID()));
				user.getChat(userLogin.getID()).anadirMensaje(new Mensaje(mensaje, date, userLogin.getID()));

				int a = userLogin.getChat(user.getID()).getMensajes().getLongitud();
				System.out.println("tamano mensaje " + a);
				AdministradorDeArchivos
						.serializarGrafo(ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios());

				instance.repaint();
				instance.revalidate();

				panelMensajes.add(mensajeCreado);
				historialChat.add(mensajeCreado);
				scrollMensajes.getVerticalScrollBar().setValue(scrollMensajes.getVerticalScrollBar().getMaximum());
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

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
