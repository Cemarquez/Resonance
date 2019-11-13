package resonance.interfaces.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import resonance.interfaces.ControladoraPrincipal;
import resonance.interfaces.VentantaLogIN;
import resonance.texto.Publicacion;
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
		btnPublicar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mensaje = textAreaPublicacion.getText();
				Date date = new Date();
				Publicacion p = new Publicacion(mensaje, date, vLogin.getUserLogin());
				vLogin.getUserLogin().agregarPublicacion(p);
				AdministradorDeArchivos.serializarGrafo(vLogin.getResonance().getAdministradorDeUsuarios());
				generarPublicaciones();
				System.out.println(vLogin.getUserLogin().obtenerPublicacionesInicio().getLongitud());
			}
		});
		btnPublicar.setBackground(Color.YELLOW);
		btnPublicar.setBounds(443, 118, 89, 23);
		panel.add(btnPublicar);

		panelPublicaciones.add(scroll);
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
		scrollBuscara.setBounds(0, 48, 445, 669);
		panelBusqueda.add(scrollBuscara);

		panelResultados = new JPanel();
		panelResultados.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelResultados.setBackground(SystemColor.controlDkShadow);
		panelResultados.setPreferredSize(new Dimension(440, 65 * 4));
		scrollBuscara.setViewportView(panelResultados);
		panelResultados.setLayout(null);

		// Solucionar problema de deserializar para activar y desativar los paneles de
		// prueba

		generarPublicaciones();
		generarUsuarios();

	}

	public void generarUsuarios() {
		int y = 0, tamano = 65;
		RedDeUsuarios red = resonance.getAdministradorDeUsuarios();
		HashMap<String, Usuario> grafo = red.getGrafo();

		Iterator<String> ite = grafo.keySet().iterator();
		while (ite.hasNext()) {
			Object obj = ite.next();
			Usuario a = grafo.get(obj);

			if (!(userLogin.getID().equals(a.getID()))) {
				JPanel panelUsuario = new JPanel();
				panelUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
				panelUsuario.setBackground(SystemColor.controlDkShadow);
				panelUsuario.setBounds(0, y, 443, tamano);
				panelResultados.add(panelUsuario);
				panelUsuario.setLayout(null);

				JLabel lblFoto = new JLabel("");
				lblFoto.setIcon((Icon) a.getPerfil().getFotoPerfil());
				lblFoto.setBounds(14, 0, 50, 65);
				panelUsuario.add(lblFoto);

				JLabel lblNombre = new JLabel(a.getID());
				lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNombre.setBounds(74, 0, 299, 65);
				panelUsuario.add(lblNombre);

				JPanel panelAnadir = new JPanel();
				panelAnadir.setBackground(new Color(0, 128, 0));
				panelAnadir.setBounds(315, 11, 118, 43);
				panelUsuario.add(panelAnadir);
				panelAnadir.setLayout(null);

				JLabel lblAnadir = new JLabel("Enviar Solicitud");
				lblAnadir.setBounds(10, 11, 101, 20);
				lblAnadir.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
				panelAnadir.add(lblAnadir);

				y += tamano;
			}

		}
	}

	public void generarPublicaciones() {
		int y = 0;
		ListaPublicaciones listaP = userLogin.obtenerPublicacionesInicio();
		listaP.irAlPrimero();
		Publicacion publicacion;

		if (numPublics == 0) {
		}
		for (int i = 0; i < numPublics; i++) {
			int tamano = 130;

			publicacion = listaP.getActual();
			JPanel panelP = new JPanel();
			panelP.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelP.setBackground(SystemColor.controlDkShadow);
			panelP.setLayout(new BorderLayout(0, 0));

			JLabel lblF = new JLabel("");
			lblF.setVerticalAlignment(SwingConstants.TOP);
			try {
				ImageIcon icon = new ImageIcon(
						publicacion.getUsuario().getPerfil().getFotoPerfil().toPath().toUri().toURL());

				lblF.setIcon(icon);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panelP.add(lblF, BorderLayout.WEST);

			JPanel panelC = new JPanel();
			panelC.setBackground(SystemColor.controlDkShadow);
			panelP.add(panelC, BorderLayout.CENTER);
			panelC.setLayout(null);

			JLabel lblNombre = new JLabel(publicacion.getUsuario().getID());
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

			panelP.setBounds(0, y, 640, tamano);
			panelScroll.add(panelP);
			y += tamano;
			listaP.irSiguiente();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
