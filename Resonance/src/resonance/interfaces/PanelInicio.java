package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import java.awt.Panel;

public class PanelInicio extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JScrollPane scroll;
	private JPanel panelScroll;
	private JPanel panelPublicaciones;
	private int numPublics;
	private JPanel panelBusqueda;
	private JPanel panelPublicacion;
	private JLabel lblFoto;
	private JPanel panelCentro;


	/**
	 * Create the panel.
	 */
	public PanelInicio() {
		this.numPublics = 12;
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
		
		panelPublicacion = new JPanel();
		panelPublicacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPublicacion.setBackground(SystemColor.controlDkShadow);
		panelScroll.add(panelPublicacion);
		panelPublicacion.setLayout(new BorderLayout(0, 0));
		
		lblFoto = new JLabel("");
		lblFoto.setVerticalAlignment(SwingConstants.TOP);
		lblFoto.setIcon(new ImageIcon(PanelInicio.class.getResource("/imagenes/Logo1Reducido.png")));
		panelPublicacion.add(lblFoto, BorderLayout.WEST);
		
		panelCentro = new JPanel();
		panelCentro.setBackground(SystemColor.controlDkShadow);
		panelPublicacion.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JLabel lblNombre = new JLabel("  Nombre del autor");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setBounds(0, 0, 558, 43);
		panelCentro.add(lblNombre);
		
		JLabel lblAquiVaEl = new JLabel("Aqui va el texto de dicha publicacion, hay que mirar como hacer el salto de pagina");
		lblAquiVaEl.setForeground(Color.BLACK);
		lblAquiVaEl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAquiVaEl.setBounds(0, 43, 558, 43);
		panelCentro.add(lblAquiVaEl);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(PanelInicio.class.getResource("/imagenes/Imagen.jpg")));
		lblImage.setBounds(0, 86, 558, 177);
		panelCentro.add(lblImage);
		
		JPanel panelAcciones = new JPanel();
		panelAcciones.setBackground(SystemColor.controlDkShadow);
		panelPublicacion.add(panelAcciones, BorderLayout.SOUTH);
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
		panelPublicaciones.add(scroll);
		
		panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBusqueda.setBackground(SystemColor.controlDkShadow);
		panelBusqueda.setForeground(Color.BLACK);
		panelBusqueda.setBounds(640, 0, 445, 717);
		add(panelBusqueda);

		crearPanelesMensajes();
	}

	public void crearPanelesMensajes() 
	{


		for (int i = 1; i <= numPublics; i++) 
		{

			JPanel panelP = new JPanel();
			panelP.setBorder(new LineBorder(new Color(0, 0, 0)));
//			panelP.setBounds(0, (300*i), 640, 300);
			panelP.setBackground(SystemColor.controlDkShadow);
			panelScroll.add(panelP);
			panelP.setLayout(new BorderLayout(0, 0));
			
			JLabel lblF = new JLabel("");
			lblF.setVerticalAlignment(SwingConstants.TOP);
			lblF.setIcon(new ImageIcon(PanelInicio.class.getResource("/imagenes/Logo1Reducido.png")));
			panelP.add(lblF, BorderLayout.WEST);
			
			JPanel panelC = new JPanel();
			panelC.setBackground(SystemColor.controlDkShadow);
			panelP.add(panelC, BorderLayout.CENTER);
			panelC.setLayout(null);
			
			JLabel lblNombre = new JLabel("  Nombre del autor");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNombre.setForeground(Color.BLACK);
			lblNombre.setBounds(0, 0, 558, 43);
			panelC.add(lblNombre);
			
			JLabel lblAquiVaEl = new JLabel("Aqui va el texto de dicha publicacion, hay que mirar como hacer el salto de pagina");
			lblAquiVaEl.setForeground(Color.BLACK);
			lblAquiVaEl.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAquiVaEl.setBounds(0, 43, 558, 43);
			panelC.add(lblAquiVaEl);
			
			JLabel lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(PanelInicio.class.getResource("/imagenes/Imagen.jpg")));
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
}
