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
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class VentanaRaiz extends JFrame implements ActionListener {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRaiz frame = new VentanaRaiz(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static final long serialVersionUID = 1L;
	private JPanel panelNotifiaciones;
	private JMenuItem mntmPerfil;
	private JMenuItem mntmInicio;
	private JMenuItem mntmChat;
	private JMenuItem mntmConfiguracion;
	private JMenuItem mntmCerrarSesion;
	private VentantaLogIN vLogin;

	public VentanaRaiz(VentantaLogIN vLogin) {
		this.vLogin = vLogin;
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
		panel_7.add(mntmPerfil);

		mntmInicio = new JMenuItem(" Inicio");
		mntmInicio.setIcon(new ImageIcon(VentanaRaiz.class.getResource("/imagenes/inicio.png")));
		mntmInicio.setForeground(Color.BLACK);
		mntmInicio.setFont(new Font("Arial", Font.PLAIN, 22));
		mntmInicio.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmInicio.setBackground(SystemColor.controlDkShadow);
		panel_7.add(mntmInicio);

		mntmChat = new JMenuItem(" Chat");
		mntmChat.setIcon(new ImageIcon(VentanaRaiz.class.getResource("/imagenes/chat.png")));
		mntmChat.setForeground(Color.BLACK);
		mntmChat.setFont(new Font("Arial", Font.PLAIN, 22));
		mntmChat.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmChat.setBackground(SystemColor.controlDkShadow);
		panel_7.add(mntmChat);

		mntmConfiguracion = new JMenuItem(" Configuracion");
		mntmConfiguracion.setIcon(new ImageIcon(VentanaRaiz.class.getResource("/imagenes/configuracion.png")));
		mntmConfiguracion.setForeground(Color.BLACK);
		mntmConfiguracion.setFont(new Font("Arial", Font.PLAIN, 22));
		mntmConfiguracion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmConfiguracion.setBackground(SystemColor.controlDkShadow);
		panel_7.add(mntmConfiguracion);

		mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.setForeground(Color.BLACK);
		mntmCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 22));
		mntmCerrarSesion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmCerrarSesion.setBackground(SystemColor.controlDkShadow);
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

		JPanel PConfiguraciones = new JPanel();
		PConfiguraciones.setBackground(Color.BLACK);
		PConfiguraciones.setBounds(0, 0, 1366, 768);
		getContentPane().add(PConfiguraciones);
		PConfiguraciones.setLayout(null);

		panelNotifiaciones = new JPanel();
		panelNotifiaciones.setBounds(258, 11, 1095, 717);
		PConfiguraciones.add(panelNotifiaciones);
		panelNotifiaciones.setVisible(false);
		panelNotifiaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNotifiaciones.setBackground(UIManager.getColor("Button.darkShadow"));
		panelNotifiaciones.setLayout(null);

		PanelChats panelChats = new PanelChats();

		panelChats.setBounds(258, 11, 1095, 717);

		PConfiguraciones.add(panelChats);
		panelNotifiaciones.setVisible(false);
		panelChats.setVisible(true);
		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
}