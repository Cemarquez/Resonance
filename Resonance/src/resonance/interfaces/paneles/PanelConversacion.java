package resonance.interfaces.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
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

		btnSubirFoto = new JLabel("");
		btnSubirFoto.setIcon(new ImageIcon(PanelConversacion.class.getResource("/imagenes/icono_foto_chat.png")));
		panelEscribirMensaje.add(btnSubirFoto, BorderLayout.WEST);
		btnSubirFoto.addMouseListener(this);

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
		panelMensajes.setLayout(new BoxLayout(panelMensajes, BoxLayout.Y_AXIS));

		// Mensaje del contacto

		RoundJTextPane mensaje = generarPanelMensaje("Colombia tierra querida himno de fe y armonia\r\n"
				+ "Cantemos, cantemos todos grito de paz y alegria\r\n"
				+ "Vivemos siempre vivemos a nuestra patria querida\r\n"
				+ "Tu suelo es una oracion y es un canto de la vida\r\n"
				+ "Cantando, cantando yo viviré Colombia tierra querida\r\n \n \n"
				+ "Cantando, cantando yo viviré Colombia tierra querida ", "");






		panelMensajes.add(mensaje);
		
		historialChat.add(mensaje);
		
	




	}

	public RoundJTextPane generarPanelMensaje(String mensaje, String tipo) {

		String salida = "";

		salida += "@Pepito" + " 20/1/2020" + "\n";
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
			panelMensajeCreado.setMaximumSize(new Dimension(200, 50));
			panelMensajeCreado.setText(salida);
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

				RoundJTextPane mensajeCreado = generarPanelMensaje(mensaje, "propio");

				// RoundJTextPane ultimoMensaje = historialChat.get(historialChat.size() - 1);


				instance.repaint();
				instance.revalidate();

				panelMensajes.add(mensajeCreado);
				historialChat.add(mensajeCreado);
				scrollMensajes.getVerticalScrollBar().setValue(scrollMensajes.getVerticalScrollBar().getMaximum());
			}
		}
		
		
		if (e.getSource()==btnSubirFoto) {
			
			JFileChooser file = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen jpg, png, gif", "jpg",
					"png", "gif", "jpeg");
			
			File fileFoto;
			file = new JFileChooser();
			file.setFileFilter(filter);
			file.showOpenDialog(instance);

			fileFoto = file.getSelectedFile();
			BufferedImage img;
			Image img2;
			if (fileFoto != null) {


				try {
					img = ImageIO.read(fileFoto);

					img2 = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

					JLabel lblImg = new JLabel();

					lblImg.setIcon(new ImageIcon(img2));

					lblImg.setMaximumSize(new Dimension(200, 200));
					lblImg.setAlignmentX(CENTER_ALIGNMENT);
					panelMensajes.add(lblImg);

					JLabel usuario = new JLabel("@Pepito" + " 20/2/20");
					panelMensajes.add(usuario);

					instance.repaint();
					instance.revalidate();

				} catch (IOException es) {
					// TODO Auto-generated catch block
					es.printStackTrace();
				}
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
