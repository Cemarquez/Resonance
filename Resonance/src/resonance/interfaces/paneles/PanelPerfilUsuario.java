package resonance.interfaces.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import resonance.archivos.AdministradorDeArchivos;
import resonance.estructura.ListaPublicaciones;
import resonance.excepciones.ExistException;
import resonance.excepciones.LimitException;
import resonance.interfaces.ControladoraPrincipal;
import resonance.interfaces.VentanaMeGusta;
import resonance.interfaces.VentantaLogIN;
import resonance.interfaces.misc.ImagePanel;
import resonance.texto.Publicacion;
import resonance.texto.Reaccion;
import resonance.texto.Reaccion.TipoReaccion;
import resonance.usuario.Relacion.TipoRelacion;
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
	private Publicacion publicacionSelected = null;

	/**
	 * Create the panel.
	 */
	public PanelPerfilUsuario(Usuario user, Usuario userLogin) {
		this.instance = this;
		this.user = user;
		this.userLogin = userLogin;

		this.numPublics = user.obtenerPublicacionesInicio().getLongitud();
		System.out.println(numPublics);
		setBackground(SystemColor.controlDkShadow);
		setSize(1095, 717);
		setLayout(null);

		panelPublicaciones = new JPanel();
		panelPublicaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPublicaciones.setBounds(0, 0, 640, 717);
		panelPublicaciones.setBackground(SystemColor.controlDkShadow);
		add(panelPublicaciones);
		panelPublicaciones.setLayout(null);

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
		panelEditarPerfil.setBounds(0, 0, 640, 310);
		panelPublicaciones.add(panelEditarPerfil);
		panelEditarPerfil.setMaximumSize(new Dimension(1300, 310));
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

		panelScroll = new JPanel();
		panelScroll.setBackground(SystemColor.controlDkShadow);
		panelScroll.setPreferredSize(new Dimension(640, 300 * numPublics));
		scroll = new JScrollPane(panelScroll, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(0, 315, 640, 394);
		panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.Y_AXIS));
		panelPublicaciones.add(scroll);

		panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBusqueda.setBackground(SystemColor.controlDkShadow);
		panelBusqueda.setForeground(Color.BLACK);
		panelBusqueda.setBounds(640, 0, 445, 717);
		add(panelBusqueda);

		JButton btnBloquear = new JButton("Bloquear");
		btnBloquear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ControladoraPrincipal.getI().getResonance().conectar(userLogin.getID(), user.getID(),
							TipoRelacion.BLOQUEADO);

					AdministradorDeArchivos
							.serializarGrafo(ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios());
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(instance);
					frame.dispose();
				} catch (ExistException | LimitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelBusqueda.add(btnBloquear);
		generarPublicaciones();

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

	public void generarPublicaciones() {
		int y = 200;
		ListaPublicaciones listaP = user.obtenerPublicacionesInicio();
		listaP.irAlPrimero();

		if (numPublics == 0) {
			JLabel jbl = new JLabel("No hay nada para mostrar");
			jbl.setBounds(40, 300, 600, 70);
			panelScroll.add(jbl);
		}
		for (int i = 0; i < numPublics; i++) {
			int tamano = 200;

			final Publicacion publicacion = listaP.getActual();
			JPanel panelP = new JPanel();
			panelP.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelP.setBackground(SystemColor.controlDkShadow);
			panelP.setLayout(new BorderLayout(0, 0));

			JLabel lblF = new JLabel("");
			lblF.setVerticalAlignment(SwingConstants.TOP);
			lblF.setSize(36, 36);
			try {
				Image ima = ImageIO.read(publicacion.getFotoPerfilUsuario());
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

			JLabel lblNombre = new JLabel(
					"   " + publicacion.getIdUser() + "                    " + toStringFecha(publicacion.getFecha()));
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
			if (publicacion.yaReacciono(userLogin.getID())) {

				mntmMeGusta.setForeground(Color.BLUE);
			} else {

				mntmMeGusta.setForeground(Color.BLACK);
			}

			mntmMeGusta.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					publicacion.agregarReaccion(new Reaccion(userLogin.getID(), TipoReaccion.MEGUSTA));
					VentanaMeGusta ventana = new VentanaMeGusta(publicacion);
					ventana.setVisible(true);

				}
			});
			panelMeGusta.add(mntmMeGusta);

			JPanel panelComentar = new JPanel();
			panelComentar.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelComentar.setForeground(Color.BLACK);
			panelComentar.setBackground(SystemColor.controlDkShadow);
			panel.add(panelComentar);
			panelComentar.setLayout(new BoxLayout(panelComentar, BoxLayout.X_AXIS));

			JMenuItem mntmComentar = new JMenuItem("Comentar");
			mntmComentar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					publicacionSelected = publicacion;

				}
			});
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
			mntmCompartir.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String mensaje = "Compartido de: " + publicacion.getIdUser() + " Publicado en: "
							+ publicacion.getFecha() + "\n" + publicacion.getMensaje();
					Publicacion p = new Publicacion(mensaje, new Date(), userLogin.getID());
					userLogin.agregarPublicacion(p);

					AdministradorDeArchivos
							.serializarGrafo(ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios());

				}
			});
			panelCompartir.add(mntmCompartir);

			panelP.setBounds(0, y, 640, tamano);
			panelScroll.add(panelP);
			y += tamano;
			listaP.irSiguiente();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public String toStringFecha(Date fecha) {
		String f = "";
		int d = fecha.getDay();
		int m = fecha.getMonth();
		int a = fecha.getYear();

		f = d + "/" + m + "/" + a + "/" + " " + fecha.getHours() + ":" + fecha.getMinutes();
		return f;
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
