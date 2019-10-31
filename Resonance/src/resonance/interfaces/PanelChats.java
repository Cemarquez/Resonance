package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class PanelChats extends JPanel {
	private JTextField textField;
	private JScrollPane scroll;
	private JPanel panelScroll;
	private JPanel panelMensajes;
	private JPanel panelCrearMensaje;


	/**
	 * Create the panel.
	 */
	public PanelChats() {
		setBackground(Color.WHITE);
		setSize(1095, 717);
		setLayout(new GridLayout(0, 2, 0, 0));

		panelMensajes = new JPanel();
		panelMensajes.setBackground(Color.WHITE);
		add(panelMensajes);
		panelMensajes.setLayout(null);

		JLabel lblTituloMensajes = new JLabel("Mensajes");
		lblTituloMensajes.setBounds(10, 0, 100, 32);
		panelMensajes.add(lblTituloMensajes);
		lblTituloMensajes.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		
		

		panelCrearMensaje = new JPanel();
		panelCrearMensaje.setBackground(Color.WHITE);
		add(panelCrearMensaje);
		panelCrearMensaje.setLayout(new BoxLayout(panelCrearMensaje, BoxLayout.X_AXIS));

		JPanel panelChat = new JPanel();
		panelCrearMensaje.add(panelChat);

		JPanel panelContactos = new JPanel();
		panelCrearMensaje.add(panelContactos);
		panelContactos.setLayout(new BoxLayout(panelContactos, BoxLayout.Y_AXIS));
		
		panelScroll = new JPanel();
		panelScroll.setPreferredSize(new Dimension(537, 10000));
		scroll = new JScrollPane(panelScroll, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		scroll.setLocation(6, 40);
		scroll.setSize(537, 669);
		panelMensajes.add(scroll);
		panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.Y_AXIS));

		JPanel panelBuscar = new JPanel();
		panelBuscar.setPreferredSize(new Dimension(1040, 60));
		panelBuscar.setMaximumSize(new Dimension(1040, 50));
		panelScroll.add(panelBuscar);
		panelBuscar.setLayout(null);

		JLabel labelBuscar = new JLabel("Buscar");
		labelBuscar.setBounds(0, -14, 110, 76);
		panelBuscar.add(labelBuscar);
		labelBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		textField = new JTextField();
		textField.setBounds(61, 15, 152, 26);
		panelBuscar.add(textField);
		textField.setColumns(10);

		crearPanelEjemplo();
		crearPanelesMensajes();
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
		panelMensajeEjemplo.setBackground(Color.WHITE);
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


		for (int i = 0; i <= 13; i++) {




			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
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

}
