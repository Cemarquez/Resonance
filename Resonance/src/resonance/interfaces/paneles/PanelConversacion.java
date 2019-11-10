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

import resonance.interfaces.misc.RoundJTextArea;
import resonance.interfaces.misc.RoundJTextPane;

public class PanelConversacion extends JPanel implements ActionListener, MouseListener {

	private PanelConversacion instance;
	private JLabel btnSubirFoto;
	private JTextField textMensaje;
	private JPanel panelMensajes;
	private JScrollPane scrollMensajes;
	private JLabel btnEnviar;
	private ArrayList<RoundJTextPane> historialChat;
	private RoundJTextArea textArea;

	/**
	 * Create the panel.
	 */
	public PanelConversacion() {
		instance = this;
		historialChat = new ArrayList<>();
		setBackground(Color.LIGHT_GRAY);
		setSize(new Dimension(455, 717));
		setLayout(null);

		JPanel panelNombreUsuario = new JPanel();
		panelNombreUsuario.setBounds(0, 0, 455, 72);
		add(panelNombreUsuario);
		panelNombreUsuario.setLayout(null);

		JLabel labelNombre = new JLabel("Pepito");
		labelNombre.setBounds(10, 0, 86, 30);
		panelNombreUsuario.add(labelNombre);
		labelNombre.setFont(new Font("Segoe UI", Font.BOLD, 18));

		JLabel labelUsuario = new JLabel("@Pepito");
		labelUsuario.setBounds(10, 21, 57, 30);
		panelNombreUsuario.add(labelUsuario);
		labelUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));


		textMensaje = new JTextField();

		panelMensajes = new JPanel();
		panelMensajes.setBackground(Color.GRAY);
		panelMensajes.setBounds(0, 52, 455, 609);
		panelMensajes.setPreferredSize(new Dimension(455, 630));

		scrollMensajes = new JScrollPane(panelMensajes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// Manda el chat a lo ultimo

		// scrollMensajes.getVerticalScrollBar().setValue(scrollMensajes.getVerticalScrollBar().getMaximum());
		scrollMensajes.setSize(455, 630);
		scrollMensajes.setBounds(0, 72, 455, 587);
		add(scrollMensajes);

		JPanel panelEscribirMensaje = new JPanel();
		panelEscribirMensaje.setBounds(0, 660, 455, 49);
		add(panelEscribirMensaje);
		panelEscribirMensaje.setLayout(new BorderLayout(0, 0));

		btnSubirFoto = new JLabel("");
		btnSubirFoto.setIcon(new ImageIcon(PanelConversacion.class.getResource("/imagenes/icono_foto_chat.png")));
		panelEscribirMensaje.add(btnSubirFoto, BorderLayout.WEST);

		textArea = new RoundJTextArea();
		JScrollPane jp = new JScrollPane(textArea);
		panelEscribirMensaje.add(jp, BorderLayout.CENTER);

		btnEnviar = new JLabel("");
		btnEnviar.addMouseListener(this);
		btnEnviar.setIcon(new ImageIcon(PanelConversacion.class.getResource("/imagenes/icono_enviar_chat.png")));
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
		panelMensajes.setLayout(null);

		// Mensaje del contacto

		RoundJTextPane mensaje = generarPanelMensaje("Colombia tierra querida himno de fe y armonia\r\n"
				+ "Cantemos, cantemos todos grito de paz y alegria\r\n"
				+ "Vivemos siempre vivemos a nuestra patria querida\r\n"
				+ "Tu suelo es una oracion y es un canto de la vida\r\n"
				+ "Cantando, cantando yo viviré Colombia tierra querida\r\n \n \n"
				+ "Cantando, cantando yo viviré Colombia tierra querida ");

		RoundJTextPane mensaje2 = generarPanelMensaje(
				"Something in the way she moves "


		);




		panelMensajes.add(mensaje);
		
		historialChat.add(mensaje);

		// panelMensajes.add(mensaje2);

		// historialChat.add(mensaje2);

		JPanel panel = new JPanel();
		panel.setBounds(0, 619, 455, 10);
		panelMensajes.add(panel);
		
	




	}

	public RoundJTextPane generarPanelMensaje(String mensaje) {

		RoundJTextPane panelMensajeCreado = new RoundJTextPane();
		panelMensajeCreado.setBounds(0, 0, 455, 619);
		panelMensajeCreado.setEditable(false);
		// panelMensajeCreado.setEnabled(false);
		setJTextPaneFont(panelMensajeCreado, new Font("Segoe UI", Font.PLAIN, 14), Color.BLACK);

		/*
		 * if (mensaje.length() > panelMensajes.getWidth()) {
		 * 
		 * panelMensajeCreado.setSize(new Dimension(200, 320));
		 * panelMensajeCreado.setText(mensaje);
		 * 
		 * }
		 * 
		 * if ((mensaje.length() > 150) && (mensaje.length() <
		 * panelMensajes.getWidth())) {
		 * 
		 * panelMensajeCreado.setSize(new Dimension(200, 320));
		 * panelMensajeCreado.setText(mensaje);
		 * 
		 * } else {
		 */
			if (mensaje.length() > 33) {
			panelMensajeCreado.setSize(new Dimension(200, 50 + ((mensaje.length() / 33) + 1) * 20));
			panelMensajeCreado.setText(mensaje);
			} else {
			panelMensajeCreado.setSize(new Dimension(200, 50));
				panelMensajeCreado.setText(mensaje);
			}

		// }

		return panelMensajeCreado;

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

				RoundJTextPane mensajeCreado = generarPanelMensaje(mensaje);

				RoundJTextPane ultimoMensaje = historialChat.get(historialChat.size() - 1);


				if (ultimoMensaje.getX() == 0) {
					
					

					if (mensajeCreado.getWidth() == 150) {
						mensajeCreado.setLocation(285, (int) ultimoMensaje.getLocation().y + 40);
					
					} else if (mensajeCreado.getWidth() == 200) {
						mensajeCreado.setLocation(235,
								ultimoMensaje.getHeight());
					}
					panelMensajes.setPreferredSize(new Dimension(455, 630 + mensajeCreado.getHeight()));
					instance.repaint();
					instance.revalidate();
				} else {

					mensajeCreado.setLocation(ultimoMensaje.getX(), ultimoMensaje.getY() + 50);
					panelMensajes.setPreferredSize(new Dimension(455, 630 + mensajeCreado.getHeight()));
					instance.repaint();
					instance.revalidate();

				}
				panelMensajes.add(mensajeCreado);

				historialChat.add(mensajeCreado);
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
