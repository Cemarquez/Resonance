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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import resonance.Resonance;
import resonance.archivos.AdministradorDeArchivos;
import resonance.estructura.ListaPublicaciones;
import resonance.estructura.RedDeUsuarios;
import resonance.excepciones.ExistException;
import resonance.excepciones.LimitException;
import resonance.interfaces.ControladoraPrincipal;
import resonance.interfaces.VentanaMeGusta;
import resonance.interfaces.VentantaLogIN;
import resonance.interfaces.misc.RoundJTextArea;
import resonance.texto.Comentario;
import resonance.texto.Publicacion;
import resonance.texto.Reaccion;
import resonance.texto.Reaccion.TipoReaccion;
import resonance.usuario.Relacion.TipoRelacion;
import resonance.usuario.Usuario;

public class PanelInicio extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JScrollPane scroll;
	private JPanel panelScroll;
	private JPanel panelPublicaciones;
	private int numPublics;
	private JPanel panelBusqueda;
	private JPanel panelResultados;
	private VentantaLogIN vLogin;
	private Usuario userLogin;
	private JTextField txtBuscar;
	private Resonance resonance;
	private JPanel panel_1;
	private JTextArea textAreaPublicacion;
	private JButton btnPublicar;
	private JPanel panelScrollComentarios;
	private Publicacion publicacionSelected = null;

	/**
	 * Create the panel.
	 */
	public PanelInicio() {
		vLogin = ControladoraPrincipal.getI();
		this.resonance = vLogin.getResonance();
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
		scroll.setBounds(0, 0, 640, 812);
		panelScroll.setLayout(null);
		crearPanelHacerPublicacion();

		panelPublicaciones.add(scroll);
		crearPanelBusquedas();
		generarPublicaciones();
		generarUsuarios();

	}

	public void crearPanelBusquedas() {
		panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBusqueda.setBackground(SystemColor.controlDkShadow);
		panelBusqueda.setForeground(Color.BLACK);
		panelBusqueda.setBounds(640, 0, 445, 717);
		add(panelBusqueda);
		panelBusqueda.setLayout(null);

		JPanel panelBuscar = new JPanel();
		panelBuscar.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBuscar.setLayout(null);
		panelBuscar.setPreferredSize(new Dimension(1040, 60));
		panelBuscar.setMaximumSize(new Dimension(1040, 50));
		panelBuscar.setBackground(SystemColor.controlDkShadow);
		panelBuscar.setBounds(0, 0, 445, 50);
		panelBusqueda.add(panelBuscar);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setForeground(Color.BLACK);
		lblBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblBuscar.setBounds(10, -1, 110, 50);
		panelBuscar.add(lblBuscar);

		txtBuscar = new JTextField();
		txtBuscar.setForeground(Color.BLACK);
		txtBuscar.setColumns(10);
		txtBuscar.setBackground(SystemColor.windowBorder);
		txtBuscar.setBounds(73, 15, 362, 26);
		panelBuscar.add(txtBuscar);

		JScrollPane scrollBuscara = new JScrollPane();
		scrollBuscara.setBounds(0, 48, 445, 331);
		panelBusqueda.add(scrollBuscara);

		panelResultados = new JPanel();
		panelResultados.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelResultados.setBackground(SystemColor.controlDkShadow);
		panelResultados.setPreferredSize(new Dimension(440, 65 * 4));
		scrollBuscara.setViewportView(panelResultados);
		panelResultados.setLayout(null);

		JPanel panelComentarios = new JPanel();
		panelComentarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelComentarios.setBounds(0, 381, 445, 44);
		panelBusqueda.add(panelComentarios);

		JLabel lblComentarios = new JLabel(
				"Comentarios                                                               ");
		lblComentarios.setFont(new Font("Teen Light", Font.BOLD, 15));
		panelComentarios.add(lblComentarios);

		JScrollPane scrollPaneComentarios = new JScrollPane();
		scrollPaneComentarios.setBounds(0, 422, 445, 239);
		panelBusqueda.add(scrollPaneComentarios);

		panelScrollComentarios = new JPanel();
		scrollPaneComentarios.setViewportView(panelScrollComentarios);
		panelScrollComentarios.setLayout(new BoxLayout(panelScrollComentarios, BoxLayout.Y_AXIS));
		JPanel panelEscribirMensaje = new JPanel();
		panelEscribirMensaje.setBounds(0, 660, 455, 49);

		panelEscribirMensaje.setLayout(new BorderLayout(0, 0));

		RoundJTextArea textArea = new RoundJTextArea();
		JScrollPane jp = new JScrollPane(textArea);
		jp.setBorder(null);
		panelEscribirMensaje.add(jp, BorderLayout.CENTER);

		JLabel btnEnviar = new JLabel("");
		btnEnviar.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				String mensaje = textArea.getText();
				Date fecha = new Date();
				String idUser = userLogin.getID();
				Comentario c = new Comentario(idUser, mensaje, fecha);
				if (publicacionSelected != null) {
					publicacionSelected.agregarComentario(c);

					AdministradorDeArchivos
							.serializarGrafo(ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios());
					refreshComentarios(publicacionSelected);
				}
			}

		});
		btnEnviar.setIcon(new ImageIcon(PanelConversacion.class.getResource("/imagenes/icono_enviar_chat.png")));
		panelEscribirMensaje.add(btnEnviar, BorderLayout.EAST);

		panelBusqueda.add(panelEscribirMensaje);
	}

	public void cargarComentarios(Publicacion p) {

		panelScrollComentarios.removeAll();
		refreshPublicaciones();
		ArrayList<Comentario> comentarios = p.getComentarios();

		for (Comentario c : comentarios) {

			panelScrollComentarios.add(new PanelComentario(c));
		}
	}

	public void refreshComentarios(Publicacion p) {

		panelScrollComentarios.removeAll();
		cargarComentarios(p);
	}

	public void refreshPublicaciones() {
		this.removeAll();
		vLogin = ControladoraPrincipal.getI();
		this.resonance = vLogin.getResonance();
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
		scroll.setBounds(0, 0, 640, 812);
		panelScroll.setLayout(null);
		crearPanelHacerPublicacion();

		panelPublicaciones.add(scroll);
		crearPanelBusquedas();
		generarPublicaciones();
		generarUsuarios();

	}

	public void crearPanelHacerPublicacion() {
		JPanel panel = new JPanel();
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
		btnPublicar.addActionListener(this);
		btnPublicar.setBackground(Color.YELLOW);
		btnPublicar.setBounds(443, 118, 89, 23);
		panel.add(btnPublicar);

	}

	public void generarUsuarios() {
		int y = 0, tamano = 65;
		RedDeUsuarios red = resonance.getAdministradorDeUsuarios();
		HashMap<String, Usuario> grafo = red.getGrafo();

		Iterator<String> ite = grafo.keySet().iterator();
		while (ite.hasNext()) {
			Object obj = ite.next();
			Usuario a = grafo.get(obj);

			if (!(userLogin.getID().equals(a.getID()) && !(a.isBloqueado(userLogin.getID())))) {
				JPanel panelUsuario = new JPanel();
				panelUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
				panelUsuario.setBackground(SystemColor.controlDkShadow);
				panelUsuario.setBounds(0, y, 443, tamano);
				panelResultados.add(panelUsuario);
				panelUsuario.setLayout(null);

				JLabel lblFoto = new JLabel("");
				lblFoto.setSize(48, 48);
				try {
					Image ima = ImageIO.read(a.getPerfil().getFotoPerfil());
					ImageIcon icon = new ImageIcon(
							ima.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));

					lblFoto.setIcon(icon);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lblFoto.setBounds(14, 0, 50, 65);
				panelUsuario.add(lblFoto);

				JLabel lblNombre = new JLabel(a.getID());
				lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNombre.setBounds(74, 0, 299, 65);
				panelUsuario.add(lblNombre);

				if (!a.estaRelacionado(userLogin.getID())) {

					JPanel panelAnadir = new JPanel();
					panelAnadir.setBackground(new Color(0, 128, 0));
					panelAnadir.setBounds(315, 11, 118, 43);
					panelUsuario.add(panelAnadir);
					panelAnadir.setLayout(null);

					JLabel lblAnadir = new JLabel("Enviar Solicitud");
					lblAnadir.setBounds(10, 11, 101, 20);
					lblAnadir.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
					panelAnadir.add(lblAnadir);
					panelAnadir.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent arg0) {

							try {
								ControladoraPrincipal.getI().getResonance().conectar(userLogin.getID(), a.getID(),
										TipoRelacion.PENDIENTE);
								AdministradorDeArchivos.serializarGrafo(
										ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios());
								lblAnadir.setText("Enviada");
								panelAnadir.setBackground(Color.CYAN);

							} catch (LimitException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ExistException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							refreshPanelBusqueda();
						}
					});
				}

				else {
					JPanel panelAnadir = new JPanel();
					panelAnadir.setBackground(Color.CYAN);
					panelAnadir.setBounds(315, 11, 118, 43);
					panelUsuario.add(panelAnadir);
					panelAnadir.setLayout(null);
					JLabel lblAnadir = new JLabel("Enviada");
					lblAnadir.setBounds(10, 11, 101, 20);
					lblAnadir.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
					panelAnadir.add(lblAnadir);

				}

//				 Metodo que abre perfil seleccionado en nueva ventana
				panelUsuario.addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent arg0) {

						PanelPerfilUsuario perfilUsuario = new PanelPerfilUsuario(a, userLogin);

						JFrame frame = new JFrame();

						frame.setBounds(0, 0, perfilUsuario.getWidth(), perfilUsuario.getHeight());
						frame.add(perfilUsuario);
						frame.setVisible(true);
					}
				});

				y += tamano;
			}

		}
	}

	public void refreshPanelBusqueda() {

		panelResultados.removeAll();
		generarUsuarios();

	}

	public String toStringFecha(Date fecha) {
		String f = "";
		int d = fecha.getDay();
		int m = fecha.getMonth();
		int a = fecha.getYear();

		f = d + "/" + m + "/" + a + "/" + " " + fecha.getHours() + ":" + fecha.getMinutes();
		return f;
	}

	public void generarPublicaciones() {
		int y = 200;
		ListaPublicaciones listaP = userLogin.obtenerPublicacionesInicio();
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
					refreshPublicaciones();

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
					refreshComentarios(publicacion);

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
					refreshPublicaciones();

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
	public void actionPerformed(ActionEvent e) {
		String mensaje = textAreaPublicacion.getText();
		Date date = new Date();
		Publicacion p = new Publicacion(mensaje, date, vLogin.getUserLogin().getID());
		vLogin.getUserLogin().agregarPublicacion(p);
		AdministradorDeArchivos.serializarGrafo(vLogin.getResonance().getAdministradorDeUsuarios());

		AdministradorDeArchivos
				.serializarGrafo(ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios());
		refreshPublicaciones();
	}
}
