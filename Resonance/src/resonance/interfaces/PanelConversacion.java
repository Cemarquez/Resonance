package resonance.interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelConversacion extends JPanel implements ActionListener {

	private JLabel lblSubirFoto;
	private JTextField textMensaje;
	private JPanel panelMensajes;
	private JScrollPane scrollMensajes;

	/**
	 * Create the panel.
	 */
	public PanelConversacion() {
		setBackground(Color.LIGHT_GRAY);
		setSize(new Dimension(455, 717));
		setLayout(null);

		JLabel labelNombre = new JLabel("Pepito");
		labelNombre.setFont(new Font("Segoe UI", Font.BOLD, 18));
		labelNombre.setBounds(10, 0, 86, 30);
		add(labelNombre);

		JLabel labelUsuario = new JLabel("@Pepito");
		labelUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		labelUsuario.setBounds(10, 21, 57, 30);
		add(labelUsuario);


		JPanel panelEscribirMensaje = new JPanel();
		panelEscribirMensaje.setBounds(0, 668, 455, 49);
		add(panelEscribirMensaje);
		panelEscribirMensaje.setLayout(null);

		lblSubirFoto = new JLabel("");
		lblSubirFoto.setIcon(new ImageIcon(PanelConversacion.class.getResource("/imagenes/icono_foto_chat.png")));
		lblSubirFoto.setBounds(10, 11, 32, 25);
		panelEscribirMensaje.add(lblSubirFoto);

		JTextField textFieldMensaje = new RoundJTextField(15);
		textFieldMensaje.setBounds(52, 11, 357, 25);


		textMensaje = new JTextField();
		// textMensaje.setBounds(64, 23, 357, 25);



		panelEscribirMensaje.add(textFieldMensaje);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PanelConversacion.class.getResource("/imagenes/icono_enviar_chat.png")));
		label.setBounds(418, 11, 37, 25);
		panelEscribirMensaje.add(label);

		panelMensajes = new JPanel();
		panelMensajes.setBackground(Color.GRAY);
		panelMensajes.setBounds(0, 52, 455, 609);
		panelMensajes.setPreferredSize(new Dimension(455, 630));

		scrollMensajes = new JScrollPane(panelMensajes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollMensajes.setSize(455, 630);
		scrollMensajes.setBounds(0, 52, 455, 617);
		add(scrollMensajes);



		textMensaje.setColumns(10);

		cargarMensajesEjemplo();

	}



		
	public void cargarMensajesEjemplo() {

		// Mensaje del contacto

		JPanel mensaje = new JPanel();
		mensaje.setBounds(0, 0, 200, 39);
		mensaje.setAlignmentX(Component.LEFT_ALIGNMENT);
		mensaje.setMaximumSize(new Dimension(200, 39));
		mensaje.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
//		msj.setText("Esto es un ejemplo de un mensaje muy largo para probar como se comportaria en el panel del chat por favor no hacer caso de ninguna manera"
//			+ "gracias");
		JLabel msj = new JLabel("Mensaje", SwingConstants.LEFT);
		msj.setPreferredSize(new Dimension(200, 30));
		mensaje.add(msj);

		panelMensajes.setLayout(null);
		panelMensajes.add(mensaje);

		// Mensaje propio

		JPanel mensajePropio = new JPanel();
		mensajePropio.setBounds(232, 65, 200, 39);
		mensajePropio.setAlignmentX(Component.RIGHT_ALIGNMENT);
		FlowLayout flowLayout = (FlowLayout) mensajePropio.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		mensajePropio.setMaximumSize(new Dimension(200, 39));

		JLabel msj2 = new JLabel("Mensaje2", SwingConstants.LEFT);
		msj2.setPreferredSize(new Dimension(200, 30));

		mensajePropio.add(msj2);
		panelMensajes.add(mensajePropio);

		JPanel mensajePropio2 = new JPanel();
		mensajePropio2.setBounds(232, 600, 200, 39);
		mensajePropio2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		FlowLayout flowLayout2 = (FlowLayout) mensajePropio2.getLayout();
		flowLayout2.setAlignment(FlowLayout.RIGHT);
		mensajePropio2.setMaximumSize(new Dimension(200, 39));

		JLabel msj3 = new JLabel("Mensaje2", SwingConstants.LEFT);
		msj3.setPreferredSize(new Dimension(200, 30));

		mensajePropio2.add(msj3);
		panelMensajes.add(mensajePropio2);

		JPanel msj5 = generarPanelMensaje("Colombia tierra querida himno de fe y armonia\r\n"
				+ "Cantemos, cantemos todos grito de paz y alegria\r\n"
				+ "Vivemos siempre vivemos a nuestra patria querida\r\n"
				+ "Tu suelo es una oracion y es un canto de la vida\r\n"
				+ "Cantando, cantando yo viviré Colombia tierra querida\r\n"
				+ "Cantando, cantando yo viviré Colombia tierra querida"
		);
		int ancho = msj5.getWidth();
		int alto = msj5.getHeight();

		


		// msj5.setBounds(232, 180, 400, 400);

		panelMensajes.add(msj5);

	}

	public JPanel generarPanelMensaje(String mensaje) {

		JLabel lblMsj = new JLabel(mensaje);
		JPanel panelMensajeCreado = new JPanel();
		System.out.println(mensaje.length());

		if (mensaje.length() > panelMensajes.getWidth()) {

			panelMensajeCreado.setBounds(232, 180, 200, 200);
			panelMensajeCreado.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			panelMensajeCreado.setPreferredSize(new Dimension(200, 200));
			JLabel mensajePanel = new JLabel();
			mensajePanel.setPreferredSize(new Dimension(200, 200));
			mensajePanel.setText(mensaje);
			panelMensajeCreado.add(mensajePanel);

		}

		if ((mensaje.length() > 150) && (mensaje.length() < panelMensajes.getWidth())) {


			panelMensajeCreado.setBounds(232, 180, 200, 320);
				panelMensajeCreado.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			panelMensajeCreado.setPreferredSize(new Dimension(180, 600));
				JLabel mensajePanel = new JLabel();
			mensajePanel.setBounds(0, 0, 150, 320);
				mensajePanel.setText(mensaje);
				panelMensajeCreado.add(mensajePanel);

		} else {



				panelMensajeCreado.setBounds(232, 180, 200, 40);
				panelMensajeCreado.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				JLabel mensajePanel = new JLabel();
				mensajePanel.setMaximumSize(new Dimension(200, 40));
				mensajePanel.setText(mensaje);
				panelMensajeCreado.add(mensajePanel);



			}



		return panelMensajeCreado;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
