package resonance.interfaces.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import resonance.estructura.ListaPublicaciones;
import resonance.interfaces.ControladoraPrincipal;
import resonance.interfaces.VentantaLogIN;
import resonance.texto.Publicacion;
import resonance.usuario.Usuario;
import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JScrollBar;

public class PanelInicio extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JScrollPane scroll;
	private JPanel panelScroll;
	private JPanel panelPublicaciones;
	private int numPublics;
	private JPanel panelBusqueda;
	private VentantaLogIN vLogin;
	private Usuario userLogin;
	private JTextField txtBuscar;

	/**
	 * Create the panel.
	 */
	public PanelInicio()
	{
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
		scroll.setBounds(0, 0, 640, 812);
		panelScroll.setLayout(null);

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
		
		JPanel panelResultados = new JPanel();
		panelResultados.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelResultados.setBackground(SystemColor.controlDkShadow);
		scrollBuscara.setViewportView(panelResultados);
		
		// Esta es la publicacion de prueba
//		JPanel panelPublicacion = new JPanel();
//		panelPublicacion.setBounds(0, 0, 640, 320);
//		panelPublicacion.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panelPublicacion.setBackground(SystemColor.controlDkShadow);
//		panelScroll.add(panelPublicacion);
//		panelPublicacion.setLayout(new BorderLayout(0, 0));
//
//		JLabel lblFoto = new JLabel("");
//		lblFoto.setVerticalAlignment(SwingConstants.TOP);
//		lblFoto.setIcon(new ImageIcon(PanelInicio.class.getResource("/imagenes/Logo1Reducido.png")));
//		panelPublicacion.add(lblFoto, BorderLayout.WEST);
//
//		JPanel panelCentro = new JPanel();
//		panelCentro.setBackground(SystemColor.controlDkShadow);
//		panelPublicacion.add(panelCentro, BorderLayout.CENTER);
//		panelCentro.setLayout(null);
//
//		JLabel lblNombre = new JLabel("  Nombre del autor");
//		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
//		lblNombre.setForeground(Color.BLACK);
//		lblNombre.setBounds(0, 0, 558, 43);
//		panelCentro.add(lblNombre);
//
//		JLabel lblImage = new JLabel("");
//		lblImage.setIcon(new ImageIcon(PanelInicio.class.getResource("/imagenes/Imagen.jpg")));
//		lblImage.setBounds(0, 102, 558, 177);
//		panelCentro.add(lblImage);
//
//		JTextPane txtPublicacion = new JTextPane();
//		txtPublicacion.setEditable(false);
//		txtPublicacion.setText(
//				"Aqui va el mensaje a ponercon salto notese que no se si hace el salto de linea solo cuando llega al tope o que pinches putas hace esta mamada en la piche puta vida de mierda");
//		txtPublicacion.setForeground(Color.BLACK);
//		txtPublicacion.setBackground(SystemColor.controlDkShadow);
//		txtPublicacion.setBounds(10, 40, 530, 60);
//		panelCentro.add(txtPublicacion);
//
//		JPanel panelAcciones = new JPanel();
//		panelAcciones.setBackground(SystemColor.controlDkShadow);
//		panelPublicacion.add(panelAcciones, BorderLayout.SOUTH);
//		panelAcciones.setLayout(new GridLayout(0, 1, 0, 0));
//
//		Panel panel = new Panel();
//		panelAcciones.add(panel);
//		panel.setLayout(new GridLayout(0, 3, 0, 0));
//
//		JPanel panelMeGusta = new JPanel();
//		panelMeGusta.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panelMeGusta.setForeground(Color.BLACK);
//		panelMeGusta.setBackground(SystemColor.controlDkShadow);
//		panel.add(panelMeGusta);
//		panelMeGusta.setLayout(new BoxLayout(panelMeGusta, BoxLayout.X_AXIS));
//
//		JMenuItem mntmMeGusta = new JMenuItem("Me gusta");
//		mntmMeGusta.setBackground(SystemColor.controlDkShadow);
//		mntmMeGusta.setForeground(Color.BLACK);
//		panelMeGusta.add(mntmMeGusta);
//
//		JPanel panelComentar = new JPanel();
//		panelComentar.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panelComentar.setForeground(Color.BLACK);
//		panelComentar.setBackground(SystemColor.controlDkShadow);
//		panel.add(panelComentar);
//		panelComentar.setLayout(new BoxLayout(panelComentar, BoxLayout.X_AXIS));
//
//		JMenuItem mntmComentar = new JMenuItem("Comentar");
//		mntmComentar.setBackground(SystemColor.controlDkShadow);
//		mntmComentar.setForeground(Color.BLACK);
//		panelComentar.add(mntmComentar);
//
//		JPanel panelCompartir = new JPanel();
//		panelCompartir.setBorder(new LineBorder(new Color(0, 0, 0)));
//		panelCompartir.setBackground(SystemColor.controlDkShadow);
//		panelCompartir.setForeground(Color.BLACK);
//		panel.add(panelCompartir);
//		panelCompartir.setLayout(new BoxLayout(panelCompartir, BoxLayout.X_AXIS));
//
//		JMenuItem mntmCompartir = new JMenuItem("Compartir");
//		mntmCompartir.setBackground(SystemColor.controlDkShadow);
//		mntmCompartir.setForeground(Color.BLACK);
//		panelCompartir.add(mntmCompartir);
//		panelPublicaciones.add(scroll);

		generarPublicaciones();
	}

	public void generarPublicaciones()
	{
		int y = 0;
		ListaPublicaciones listaP = userLogin.obtenerPublicacionesInicio();
		listaP.irAlPrimero();
		Publicacion publicacion;
		
		for (int i = 0; i < numPublics ; i++)
		{
			int tamaño = 130;
			
			publicacion = listaP.getActual(); 
			JPanel panelP = new JPanel();
			panelP.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelP.setBackground(SystemColor.controlDkShadow);
			panelP.setLayout(new BorderLayout(0, 0));

			JLabel lblF = new JLabel("");
			lblF.setVerticalAlignment(SwingConstants.TOP);
			lblF.setIcon((Icon) publicacion.getUsuario().getPerfil().getFotoPerfil());
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

			if(publicacion.getImagen() != null)
			{
				JLabel lblImage = new JLabel("");
				lblImage.setIcon((Icon) publicacion.getImagen());
				lblImage.setBounds(0, 86, 558, 177);
				panelC.add(lblImage);
				
				tamaño = 320;
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

			panelP.setBounds(0, y, 640, tamaño);
			panelScroll.add(panelP);
			y += tamaño;
		}
	}
}
