package resonance.interfaces.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import resonance.archivos.AdministradorDeArchivos;
import resonance.estructura.ListaPublicaciones;
import resonance.interfaces.ControladoraPrincipal;
import resonance.interfaces.VentantaLogIN;
import resonance.interfaces.misc.ImagePanel;
import resonance.texto.Publicacion;
import resonance.usuario.Usuario;

public class PanelPerfil extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private PanelPerfil instance;
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
	private JTextArea textAreaPublicacion;
	private JPanel panel_1;
	private JButton btnPublicar;

	/**
	 * Create the panel.
	 */
	public PanelPerfil() {
		this.instance = this;
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

		Image img = new ImageIcon(Panel.class.getResource("/imagenes/segunda.jpg")).getImage();

		Image img2 = new ImageIcon(Panel.class.getResource("/imagenes/tercera.jpg")).getImage();


		try {
			img2 = ImageIO.read(userLogin.getPerfil().getFotoPerfil());

			Image fotoPerfilEscalada = img2.getScaledInstance(120, 120, Image.SCALE_SMOOTH);


			paneFotoPerfil = new ImagePanel(fotoPerfilEscalada, 120, 120);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.Y_AXIS));


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
		panelCambiarFotoPerfil.addMouseListener(this);

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
		paneCambiarFotoPortada.addMouseListener(this);
		panelPublicaciones.add(scroll);

		panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBusqueda.setBackground(SystemColor.controlDkShadow);
		panelBusqueda.setForeground(Color.BLACK);
		panelBusqueda.setBounds(640, 0, 445, 717);
		add(panelBusqueda);

		crearPublicacionPanel();
		generarPublicaciones();
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
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen jpg, png, gif", "jpg",
					"png", "gif", "jpeg");

			JFileChooser file = new JFileChooser();
			file.setFileFilter(filter);
			file.showOpenDialog(panelCambiarFotoPerfil);

			File fileFoto = file.getSelectedFile();
			Image img = null;

			if (fileFoto != null) {

				try {
					img = ImageIO.read(fileFoto);

					AdministradorDeArchivos.cambiarFotoPerfil(fileFoto, userLogin.getID());



				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		}
		refresh();

	}

	public void crearPublicacionPanel() {
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(1300, 141));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 640, 141);
		panelScroll.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 640, 29);
		panel.add(panel_1);

		JLabel lblCrearPublicacin = new JLabel("Crear publicaci\u00F3n.");
		lblCrearPublicacin.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblCrearPublicacin);
		lblCrearPublicacin.setBackground(Color.LIGHT_GRAY);

		textAreaPublicacion = new JTextArea();
		textAreaPublicacion.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textAreaPublicacion.setBounds(0, 29, 640, 86);
		panel.add(textAreaPublicacion);

		JButton btnFotoPubli = new JButton("");
		btnFotoPubli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFotoPubli.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnFotoPubli.setIcon(new ImageIcon(PanelInicio.class.getResource("/imagenes/iconFotoPub.png")));
		btnFotoPubli.setContentAreaFilled(false);
		btnFotoPubli.setBorderPainted(false);
		btnFotoPubli.setBounds(58, 118, 27, 23);
		panel.add(btnFotoPubli);

		JLabel lblFoto_1 = new JLabel("Foto");
		lblFoto_1.setBounds(84, 118, 46, 22);
		panel.add(lblFoto_1);

		btnPublicar = new JButton("Publicar");
		btnPublicar.setBackground(Color.YELLOW);
		btnPublicar.setBounds(443, 118, 89, 23);
		panel.add(btnPublicar);



	}

	public void generarPublicaciones() {
		int y = 0;
		ListaPublicaciones listaP = userLogin.obtenerPublicacionesInicio();
		listaP.irAlPrimero();
		Publicacion publicacion;

		if (numPublics == 0) {
		}
		for (int i = 0; i < numPublics; i++) {
			int tamano = 150;

			publicacion = listaP.getActual();
			JPanel panelP = new JPanel();
			panelP.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelP.setBackground(SystemColor.controlDkShadow);
			panelP.setLayout(new BorderLayout(0, 0));

			JLabel lblF = new JLabel("");
			lblF.setVerticalAlignment(SwingConstants.TOP);
			lblF.setSize(36, 36);
			try {
				Image ima = ImageIO.read(publicacion.getUsuario().getPerfil().getFotoPerfil());
//				ImageIcon icon = new ImageIcon(
//						publicacion.getUsuario().getPerfil().getFotoPerfil().toPath().toUri().toURL());
				ImageIcon icon = new ImageIcon(
						ima.getScaledInstance(lblF.getWidth(), lblF.getHeight(), Image.SCALE_SMOOTH));

				lblF.setIcon(icon);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panelP.add(lblF, BorderLayout.WEST);

			JPanel panelC = new JPanel();
			panelC.setBackground(SystemColor.controlDkShadow);
			panelP.add(panelC, BorderLayout.CENTER);
			panelC.setLayout(null);

			JLabel lblNombre = new JLabel("   " + publicacion.getUsuario().getID());
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNombre.setForeground(Color.BLACK);
			lblNombre.setBounds(0, 0, 558, 43);
			panelC.add(lblNombre);

			JTextPane txtPublicacion = new JTextPane();
			txtPublicacion.setEditable(false);
			txtPublicacion.setText(publicacion.getMensaje());
			txtPublicacion.setForeground(Color.BLACK);
			txtPublicacion.setBackground(SystemColor.controlDkShadow);
			txtPublicacion.setBounds(10, 40, 534, 53);
			panelC.add(txtPublicacion);

			if (publicacion.getImagen() != null) {
				JLabel lblImage = new JLabel("");
				lblImage.setIcon((Icon) publicacion.getImagen());
				lblImage.setBounds(0, 86, 558, 177);
				panelC.add(lblImage);

				tamano = 320;
			}

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

			// panelP.setBounds(0, y, 640, tamano);
			panelP.setMaximumSize(new Dimension(1300, tamano));
			panelScroll.add(panelP);
			y += tamano;
			listaP.irSiguiente();
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
			img2 = ImageIO.read(userLogin.getPerfil().getFotoPerfil());

			Image fotoPerfilEscalada = img2.getScaledInstance(120, 120, Image.SCALE_SMOOTH);

			paneFotoPerfil = new ImagePanel(fotoPerfilEscalada, 120, 120);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panelEditarPerfil = new JPanel();
		panelEditarPerfil.setMaximumSize(new Dimension(1250, 310));
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
		panelCambiarFotoPerfil.addMouseListener(this);

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
		paneCambiarFotoPortada.addMouseListener(this);
		panelPublicaciones.add(scroll);

		panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBusqueda.setBackground(SystemColor.controlDkShadow);
		panelBusqueda.setForeground(Color.BLACK);
		panelBusqueda.setBounds(640, 0, 445, 717);
		add(panelBusqueda);

		crearPublicacionPanel();
		generarPublicaciones();
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
