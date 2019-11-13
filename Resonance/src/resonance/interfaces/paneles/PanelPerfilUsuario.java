package resonance.interfaces.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import resonance.interfaces.VentantaLogIN;
import resonance.interfaces.misc.ImagePanel;
import resonance.usuario.Usuario;

public class PanelPerfilUsuario extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private PanelPerfilUsuario instance;
	private JScrollPane scroll;
	private JPanel panelScroll;
	private JPanel panelPublicaciones;
	private int numPublics;
	private JPanel panelBusqueda;
	private VentantaLogIN vLogin;
	private Usuario user;
	private Usuario userLogin;
	private JPanel panelEditarPerfil;
	private ImagePanel paneFotoPerfil;
	private JPanel panelAmistad;
	private JLabel lblAmistad;

	/**
	 * Create the panel.
	 */
	public PanelPerfilUsuario(Usuario user, Usuario userLogin) {
		this.instance = this;
		this.user = user;
		this.userLogin = userLogin;

		this.numPublics = user.obtenerPublicacionesInicio().getLongitud();
		setBackground(SystemColor.controlDkShadow);
		setSize(1095, 717);
		setLayout(null);

		panelPublicaciones = new JPanel();
		panelPublicaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPublicaciones.setBounds(0, 0, 640, 717);
		panelPublicaciones.setBackground(SystemColor.controlDkShadow);
		add(panelPublicaciones);
		panelPublicaciones.setLayout(null);

		panelScroll = new JPanel();
		panelScroll.setBackground(SystemColor.controlDkShadow);
		panelScroll.setPreferredSize(new Dimension(640, 300 * numPublics));
		scroll = new JScrollPane(panelScroll, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(0, 0, 640, 709);
		panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.Y_AXIS));

		Image img = new ImageIcon(Panel.class.getResource("/imagenes/segunda.jpg")).getImage();

		Image img2 = new ImageIcon(Panel.class.getResource("/imagenes/tercera.jpg")).getImage();


		try {
			img2 = ImageIO.read(user.getPerfil().getFotoPerfil());

			Image fotoPerfilEscalada = img2.getScaledInstance(120, 120, Image.SCALE_SMOOTH);


			paneFotoPerfil = new ImagePanel(fotoPerfilEscalada, 120, 120);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		panelEditarPerfil = new JPanel();
		panelEditarPerfil.setMaximumSize(new Dimension(1300, 310));
		panelScroll.add(panelEditarPerfil);
		panelEditarPerfil.setLayout(null);

		paneFotoPerfil.setBackground(Color.BLACK);
		paneFotoPerfil.setBounds(10, 152, 120, 120);
		panelEditarPerfil.add(paneFotoPerfil);

		// Aqui se pondria la foto por defecto o la del usuario pero aun sigue el error
		// del file no encontrado
		ImagePanel panelPerfil = new ImagePanel(img, 1300, 70);
		panelEditarPerfil.add(panelPerfil);

		panelPerfil.setBounds(0, 0, 640, 239);
		panelPerfil.setMaximumSize(new Dimension(1300, 70));
		panelPerfil.setLayout(null);

		JLabel lblNombreUsuario = new JLabel();
		lblNombreUsuario.setText(user.getPerfil().getNombre());
		lblNombreUsuario.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNombreUsuario.setBounds(10, 273, 110, 14);
		panelEditarPerfil.add(lblNombreUsuario);

		JLabel lblUsuario = new JLabel();
		lblUsuario.setText("@" + user.getPerfil().getUsuario());
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblUsuario.setBounds(10, 285, 89, 14);
		panelEditarPerfil.add(lblUsuario);

		panelAmistad = new JPanel();
		panelAmistad.setLayout(null);
		panelAmistad.setForeground(Color.WHITE);
		panelAmistad.setBorder(new LineBorder(new Color(0, 0, 0), 42, true));
		panelAmistad.setBackground(UIManager.getColor("Button.background"));
		panelAmistad.setBounds(415, 247, 192, 25);
		panelEditarPerfil.add(panelAmistad);

		lblAmistad = new JLabel("Enviar solicitud");
		lblAmistad.setForeground(Color.WHITE);
		lblAmistad.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblAmistad.setBounds(39, 0, 110, 28);
		panelAmistad.add(lblAmistad);
		panelAmistad.addMouseListener(this);
		panelPublicaciones.add(scroll);

		panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBusqueda.setBackground(SystemColor.controlDkShadow);
		panelBusqueda.setForeground(Color.BLACK);
		panelBusqueda.setBounds(640, 0, 445, 717);
		add(panelBusqueda);


	}


	@Override
	public void mousePressed(MouseEvent arg0) {

		if (arg0.getSource() == panelAmistad) {
			
			lblAmistad.setText("Solicitud enviada");

		}
	}

	public void refresh() {



		instance.removeAll();
		panelPublicaciones = new JPanel();
		panelPublicaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPublicaciones.setBounds(0, 0, 640, 717);
		panelPublicaciones.setBackground(SystemColor.controlDkShadow);
		add(panelPublicaciones);
		panelPublicaciones.setLayout(null);

		panelScroll = new JPanel();
		panelScroll.setBackground(SystemColor.controlDkShadow);
		panelScroll.setPreferredSize(new Dimension(640, 300 * numPublics));
		scroll = new JScrollPane(panelScroll, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(0, 0, 640, 709);
		panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.Y_AXIS));

		Image img = new ImageIcon(Panel.class.getResource("/imagenes/segunda.jpg")).getImage();

		Image img2 = new ImageIcon(Panel.class.getResource("/imagenes/tercera.jpg")).getImage();

		try {
			img2 = ImageIO.read(user.getPerfil().getFotoPerfil());

			Image fotoPerfilEscalada = img2.getScaledInstance(120, 120, Image.SCALE_SMOOTH);

			paneFotoPerfil = new ImagePanel(fotoPerfilEscalada, 120, 120);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panelEditarPerfil = new JPanel();
		panelEditarPerfil.setMaximumSize(new Dimension(1300, 310));
		panelScroll.add(panelEditarPerfil);
		panelEditarPerfil.setLayout(null);

		paneFotoPerfil.setBackground(Color.BLACK);
		paneFotoPerfil.setBounds(10, 152, 120, 120);
		panelEditarPerfil.add(paneFotoPerfil);

		// Aqui se pondria la foto por defecto o la del usuario pero aun sigue el error
		// del file no encontrado
		ImagePanel panelPerfil = new ImagePanel(img, 1300, 70);
		panelEditarPerfil.add(panelPerfil);

		panelPerfil.setBounds(0, 0, 640, 239);
		panelPerfil.setMaximumSize(new Dimension(1300, 70));
		panelPerfil.setLayout(null);

		JLabel lblNombreUsuario = new JLabel();
		lblNombreUsuario.setText(user.getPerfil().getNombre());
		lblNombreUsuario.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNombreUsuario.setBounds(10, 273, 110, 14);
		panelEditarPerfil.add(lblNombreUsuario);

		JLabel lblUsuario = new JLabel();
		lblUsuario.setText("@" + user.getPerfil().getUsuario());
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblUsuario.setBounds(10, 285, 89, 14);
		panelEditarPerfil.add(lblUsuario);

		panelAmistad = new JPanel();
		panelAmistad.setLayout(null);
		panelAmistad.setForeground(Color.WHITE);
		panelAmistad.setBorder(new LineBorder(new Color(0, 0, 0), 42, true));
		panelAmistad.setBackground(UIManager.getColor("Button.background"));
		panelAmistad.setBounds(415, 247, 192, 25);
		panelEditarPerfil.add(panelAmistad);

		lblAmistad = new JLabel("Cambiar foto perfil");
		lblAmistad.setForeground(Color.WHITE);
		lblAmistad.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblAmistad.setBounds(27, 0, 155, 28);
		panelAmistad.add(lblAmistad);
		panelAmistad.addMouseListener(this);



		panelPublicaciones.add(scroll);

		panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBusqueda.setBackground(SystemColor.controlDkShadow);
		panelBusqueda.setForeground(Color.BLACK);
		panelBusqueda.setBounds(640, 0, 445, 717);
		add(panelBusqueda);

		repaint();
		revalidate();
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
