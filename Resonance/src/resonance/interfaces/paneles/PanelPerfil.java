package resonance.interfaces.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import resonance.interfaces.ControladoraPrincipal;
import resonance.interfaces.VentantaLogIN;
import resonance.interfaces.misc.ImagePanel;
import resonance.usuario.Usuario;

public class PanelPerfil extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private JScrollPane scroll;
	private JPanel panelScroll;
	private JPanel panelPublicaciones;
	private int numPublics;
	private JPanel panelBusqueda;
	private VentantaLogIN vLogin;
	private Usuario userLogin;
	private JPanel panelEditarPerfil;
	private ImagePanel paneFotoPerfil;
	private JPanel panelCambiarFotoPerfil;
	private JLabel lblCambiarFotoPerfil;
	private JPanel paneCambiarFotoPortada;
	private JLabel lblCambiarFotoPortada;

	/**
	 * Create the panel.
	 */
	public PanelPerfil() {
		vLogin = ControladoraPrincipal.getI();
		userLogin = vLogin.getUserLogin();
		this.numPublics = userLogin.obtenerPublicacionesInicio().getLongitud();
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

		Image img2 = new ImageIcon(Panel.class.getResource("/imagenes/tercera.jpg")).getImage();;
		
/*
		try {
			img2 = ImageIO.read(userLogin.getPerfil().getFotoPerfil());

			Image fotoPerfilEscalada = img2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			paneFotoPerfil = new ImagePanel(fotoPerfilEscalada, 200, 200);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		paneFotoPerfil = new ImagePanel(img2, 200, 200);
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
		lblNombreUsuario.setText(userLogin.getPerfil().getNombre());
		lblNombreUsuario.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNombreUsuario.setBounds(10, 273, 110, 14);
		panelEditarPerfil.add(lblNombreUsuario);

		JLabel lblUsuario = new JLabel();
		lblUsuario.setText("@" + userLogin.getPerfil().getUsuario());
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblUsuario.setBounds(10, 285, 89, 14);
		panelEditarPerfil.add(lblUsuario);

		panelCambiarFotoPerfil = new JPanel();
		panelCambiarFotoPerfil.setLayout(null);
		panelCambiarFotoPerfil.setForeground(Color.WHITE);
		panelCambiarFotoPerfil.setBorder(new LineBorder(new Color(0, 0, 0), 42, true));
		panelCambiarFotoPerfil.setBackground(UIManager.getColor("Button.background"));
		panelCambiarFotoPerfil.setBounds(415, 247, 192, 25);
		panelEditarPerfil.add(panelCambiarFotoPerfil);

		lblCambiarFotoPerfil = new JLabel("Cambiar foto perfil");
		lblCambiarFotoPerfil.setForeground(Color.WHITE);
		lblCambiarFotoPerfil.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCambiarFotoPerfil.setBounds(27, 0, 155, 28);
		panelCambiarFotoPerfil.add(lblCambiarFotoPerfil);

		paneCambiarFotoPortada = new JPanel();
		paneCambiarFotoPortada.setLayout(null);
		paneCambiarFotoPortada.setForeground(Color.WHITE);
		paneCambiarFotoPortada.setBorder(new LineBorder(new Color(0, 0, 0), 42, true));
		paneCambiarFotoPortada.setBackground(UIManager.getColor("Button.background"));
		paneCambiarFotoPortada.setBounds(415, 274, 192, 25);
		panelEditarPerfil.add(paneCambiarFotoPortada);

		lblCambiarFotoPortada = new JLabel("Cambiar foto portada");
		lblCambiarFotoPortada.setForeground(Color.WHITE);
		lblCambiarFotoPortada.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCambiarFotoPortada.setBounds(27, 0, 155, 28);
		paneCambiarFotoPortada.add(lblCambiarFotoPortada);
		panelPublicaciones.add(scroll);

		panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBusqueda.setBackground(SystemColor.controlDkShadow);
		panelBusqueda.setForeground(Color.BLACK);
		panelBusqueda.setBounds(640, 0, 445, 717);
		add(panelBusqueda);

		crearPanelesMensajes();
	}

	public void crearPanelesMensajes() {

		for (int i = 1; i <= numPublics; i++) {

			JPanel panelP = new JPanel();
			panelP.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelP.setBackground(SystemColor.controlDkShadow);
			panelScroll.add(panelP);
			panelP.setLayout(new BorderLayout(0, 0));

			JLabel lblF = new JLabel("");
			lblF.setVerticalAlignment(SwingConstants.TOP);
			lblF.setIcon(new ImageIcon(PanelPerfil.class.getResource("/imagenes/Logo1Reducido.png")));
			panelP.add(lblF, BorderLayout.WEST);

			JPanel panelC = new JPanel();
			panelC.setBackground(SystemColor.controlDkShadow);
			panelP.add(panelC, BorderLayout.CENTER);
			panelC.setLayout(null);

			JLabel lblNombre = new JLabel(userLogin.getID());
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNombre.setForeground(Color.BLACK);
			lblNombre.setBounds(0, 0, 558, 43);
			panelC.add(lblNombre);

			JLabel lblAquiVaEl = new JLabel(
					"Aqui va el texto de dicha publicacion, hay que mirar como hacer el salto de pagina");
			lblAquiVaEl.setForeground(Color.BLACK);
			lblAquiVaEl.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAquiVaEl.setBounds(0, 43, 558, 43);
			panelC.add(lblAquiVaEl);

			JLabel lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(PanelPerfil.class.getResource("/imagenes/Imagen.jpg")));
			lblImage.setBounds(0, 86, 558, 177);
			panelC.add(lblImage);

			JPanel panelAcciones = new JPanel();
			panelAcciones.setBackground(SystemColor.controlDkShadow);
			panelP.add(panelAcciones, BorderLayout.SOUTH);
			panelAcciones.setLayout(new GridLayout(0, 1, 0, 0));

			Panel panel = new Panel();
			panelAcciones.add(panel);
			panel.setLayout(new GridLayout(0, 3, 0, 0));

			JPanel panelMeGusta = new JPanel();
			panelMeGusta.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelMeGusta.setForeground(Color.BLACK);
			panelMeGusta.setBackground(SystemColor.controlDkShadow);
			panel.add(panelMeGusta);
			panelMeGusta.setLayout(new BoxLayout(panelMeGusta, BoxLayout.X_AXIS));

			JMenuItem mntmMeGusta = new JMenuItem("Me gusta");
			mntmMeGusta.setBackground(SystemColor.controlDkShadow);
			mntmMeGusta.setForeground(Color.BLACK);
			panelMeGusta.add(mntmMeGusta);

			JPanel panelComentar = new JPanel();
			panelComentar.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelComentar.setForeground(Color.BLACK);
			panelComentar.setBackground(SystemColor.controlDkShadow);
			panel.add(panelComentar);
			panelComentar.setLayout(new BoxLayout(panelComentar, BoxLayout.X_AXIS));

			JMenuItem mntmComentar = new JMenuItem("Comentar");
			mntmComentar.setBackground(SystemColor.controlDkShadow);
			mntmComentar.setForeground(Color.BLACK);
			panelComentar.add(mntmComentar);

			JPanel panelCompartir = new JPanel();
			panelCompartir.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelCompartir.setBackground(SystemColor.controlDkShadow);
			panelCompartir.setForeground(Color.BLACK);
			panel.add(panelCompartir);
			panelCompartir.setLayout(new BoxLayout(panelCompartir, BoxLayout.X_AXIS));

			JMenuItem mntmCompartir = new JMenuItem("Compartir");
			mntmCompartir.setBackground(SystemColor.controlDkShadow);
			mntmCompartir.setForeground(Color.BLACK);
			panelCompartir.add(mntmCompartir);
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

		if (arg0.getSource() == panelCambiarFotoPerfil) {

		}

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
