package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import resonance.interfaces.paneles.PanelChats;
import resonance.interfaces.paneles.PanelConfiguracion;
import resonance.interfaces.paneles.PanelInicio;
import resonance.interfaces.paneles.PanelPerfil;

public class VentanaRaiz extends JFrame implements ActionListener {

	private PanelChats panelChats;
	private PanelConfiguracion panelConfiguracion;
	private PanelInicio panelInicio;
	private PanelPerfil panelPerfil;
	private static final long serialVersionUID = 1L;
	private JMenuItem mntmPerfil;
	private JMenuItem mntmInicio;
	private JMenuItem mntmChat;
	private JMenuItem mntmConfiguracion;
	private JMenuItem mntmCerrarSesion;
	private VentantaLogIN vLogin;


	public VentanaRaiz() {
		this.vLogin = ControladoraPrincipal.getI();
		this.setExtendedState(MAXIMIZED_BOTH);
		Dimension tamano = new Dimension(1366, 768);
		setSize(tamano);
		getContentPane().setLayout(null);
		getContentPane().setSize(tamano);
		getContentPane().setBackground(Color.decode("#5B5151"));

		JPanel panelMenu = new JPanel();
		panelMenu.setLayout(null);
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBackground(SystemColor.controlDkShadow);
		panelMenu.setBounds(10, 11, 248, 717);
		getContentPane().add(panelMenu);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(Color.BLACK));
		panel_6.setBackground(SystemColor.textInactiveText);
		panel_6.setBounds(0, 0, 248, 71);
		panelMenu.add(panel_6);

		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon(VentanaRaiz.class.getResource("/imagenes/Logo1Reducido.png")));
		labelLogo.setForeground(Color.WHITE);
		labelLogo.setFont(new Font("Arial", Font.PLAIN, 40));
		labelLogo.setBackground(Color.WHITE);
		labelLogo.setBounds(94, 11, 50, 43);
		panel_6.add(labelLogo);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBackground(SystemColor.controlDkShadow);
		panel_7.setBounds(0, 71, 248, 646);
		panelMenu.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));

		mntmPerfil = new JMenuItem(" Perfil");
		mntmPerfil.setIcon(new ImageIcon(VentanaRaiz.class.getResource("/imagenes/perfil.png")));
		mntmPerfil.setForeground(Color.BLACK);
		mntmPerfil.setFont(new Font("Arial", Font.PLAIN, 22));
		mntmPerfil.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		mntmPerfil.setBackground(SystemColor.controlDkShadow);
		mntmPerfil.addActionListener(this);
		panel_7.add(mntmPerfil);

		mntmInicio = new JMenuItem(" Inicio");
		mntmInicio.setIcon(new ImageIcon(VentanaRaiz.class.getResource("/imagenes/inicio.png")));
		mntmInicio.setForeground(Color.BLACK);
		mntmInicio.setFont(new Font("Arial", Font.PLAIN, 22));
		mntmInicio.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmInicio.setBackground(SystemColor.controlDkShadow);
		mntmInicio.addActionListener(this);
		panel_7.add(mntmInicio);

		mntmChat = new JMenuItem(" Chat");
		mntmChat.setIcon(new ImageIcon(VentanaRaiz.class.getResource("/imagenes/chat.png")));
		mntmChat.setForeground(Color.BLACK);
		mntmChat.setFont(new Font("Arial", Font.PLAIN, 22));
		mntmChat.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmChat.setBackground(SystemColor.controlDkShadow);
		mntmChat.addActionListener(this);
		panel_7.add(mntmChat);

		mntmConfiguracion = new JMenuItem(" Configuracion");
		mntmConfiguracion.setIcon(new ImageIcon(VentanaRaiz.class.getResource("/imagenes/configuracion.png")));
		mntmConfiguracion.setForeground(Color.BLACK);
		mntmConfiguracion.setFont(new Font("Arial", Font.PLAIN, 22));
		mntmConfiguracion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmConfiguracion.setBackground(SystemColor.controlDkShadow);
		mntmConfiguracion.addActionListener(this);
		panel_7.add(mntmConfiguracion);

		mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.setForeground(Color.BLACK);
		mntmCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 22));
		mntmCerrarSesion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmCerrarSesion.setBackground(SystemColor.controlDkShadow);
		mntmCerrarSesion.addActionListener(this);
		panel_7.add(mntmCerrarSesion);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.controlDkShadow);
		panel_7.add(panel_4);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.controlDkShadow);
		panel_7.add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(SystemColor.controlDkShadow);
		panel_7.add(panel_9);

		JPanel panelContenedor = new JPanel();
		panelContenedor.setBackground(Color.BLACK);
		panelContenedor.setBounds(0, 0, 1366, 768);
		getContentPane().add(panelContenedor);
		panelContenedor.setLayout(null);

		panelChats = new PanelChats();
		panelChats.setBounds(258, 11, 1095, 717);

		panelConfiguracion = new PanelConfiguracion();
		panelConfiguracion.setBounds(258, 11, 1095, 717);

		panelInicio = new PanelInicio();
		panelInicio.setBounds(258, 11, 1095, 717);

		panelPerfil = new PanelPerfil();
		panelPerfil.setBounds(258, 11, 1095, 717);

		panelContenedor.add(panelConfiguracion);
		panelContenedor.add(panelChats);
		panelContenedor.add(panelInicio);
		panelContenedor.add(panelPerfil);

		panelChats.setVisible(false);
		panelConfiguracion.setVisible(false);
		panelPerfil.setVisible(false);
		panelInicio.setVisible(true);

		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == mntmInicio) {
			panelChats.setVisible(false);
			panelConfiguracion.setVisible(false);
			panelPerfil.setVisible(false);
			panelInicio.setVisible(true);
		}

		if (arg0.getSource() == mntmChat) {
			panelInicio.setVisible(false);
			panelConfiguracion.setVisible(false);
			panelPerfil.setVisible(false);
			panelChats.setVisible(true);
		}

		if (arg0.getSource() == mntmConfiguracion) {
			panelInicio.setVisible(false);
			panelChats.setVisible(false);
			panelPerfil.setVisible(false);
			panelConfiguracion.setVisible(true);
		}

		if (arg0.getSource() == mntmPerfil) {
			panelInicio.setVisible(false);
			panelChats.setVisible(false);
			panelConfiguracion.setVisible(false);
			panelPerfil.refresh();
			panelPerfil.setVisible(true);

		}

		if (arg0.getSource() == mntmCerrarSesion) {
			JOptionPane.showMessageDialog(null, "Cerrando sesion");
		}
	}
}