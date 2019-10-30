package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
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

public class VentanaTotal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JMenuItem mntmCuenta;
	private JMenuItem mntmPrivacidad;
	private JMenuItem mntmNotificaciones;
	private JPanel panelCuenta;
	private JPanel panelPrivacidad;
	private JPanel panelNotifiaciones;
	private JMenuItem mntmPerfil;
	private JMenuItem mntmInicio;
	private JMenuItem mntmChat;
	private JMenuItem mntmConfiguracion;
	private JMenuItem mntmCerrarSesion;
	private VentantaLogIN vLogin;

	public VentanaTotal(VentantaLogIN vLogin) {
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
		labelLogo.setIcon(new ImageIcon(VentanaTotal.class.getResource("/imagenes/Logo1Reducido.png")));
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
		mntmPerfil.setIcon(new ImageIcon(VentanaTotal.class.getResource("/imagenes/perfil.png")));
		mntmPerfil.setForeground(Color.BLACK);
		mntmPerfil.setFont(new Font("Arial", Font.PLAIN, 22));
		mntmPerfil.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		mntmPerfil.setBackground(SystemColor.controlDkShadow);
		panel_7.add(mntmPerfil);

		mntmInicio = new JMenuItem(" Inicio");
		mntmInicio.setIcon(new ImageIcon(VentanaTotal.class.getResource("/imagenes/inicio.png")));
		mntmInicio.setForeground(Color.BLACK);
		mntmInicio.setFont(new Font("Arial", Font.PLAIN, 22));
		mntmInicio.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmInicio.setBackground(SystemColor.controlDkShadow);
		panel_7.add(mntmInicio);

		mntmChat = new JMenuItem(" Chat");
		mntmChat.setIcon(new ImageIcon(VentanaTotal.class.getResource("/imagenes/chat.png")));
		mntmChat.setForeground(Color.BLACK);
		mntmChat.setFont(new Font("Arial", Font.PLAIN, 22));
		mntmChat.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmChat.setBackground(SystemColor.controlDkShadow);
		panel_7.add(mntmChat);

		mntmConfiguracion = new JMenuItem(" Configuracion");
		mntmConfiguracion.setIcon(new ImageIcon(VentanaTotal.class.getResource("/imagenes/configuracion.png")));
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

		JPanel panelConfiguracion = new JPanel();
		panelConfiguracion.setBounds(258, 11, 292, 717);
		PConfiguraciones.add(panelConfiguracion);
		panelConfiguracion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelConfiguracion.setBackground(UIManager.getColor("Button.darkShadow"));
		panelConfiguracion.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(Color.BLACK));
		panel1.setBackground(UIManager.getColor("Button.disabledForeground"));
		panel1.setBounds(0, 0, 292, 71);
		panelConfiguracion.add(panel1);
		panel1.setLayout(null);

		JLabel lblTitulo = new JLabel("Configuracion");
		lblTitulo.setBounds(10, 11, 272, 43);
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 40));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBackground(Color.WHITE);
		panel1.add(lblTitulo);

		JPanel panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2.setBackground(UIManager.getColor("Button.darkShadow"));
		panel2.setBounds(0, 71, 292, 646);
		panelConfiguracion.add(panel2);
		panel2.setLayout(new GridLayout(0, 1, 0, 0));

		mntmCuenta = new JMenuItem("Cuenta");
		mntmCuenta.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		mntmCuenta.setForeground(Color.BLACK);
		mntmCuenta.setBackground(UIManager.getColor("Button.darkShadow"));
		mntmCuenta.setFont(new Font("Arial", Font.PLAIN, 24));
		mntmCuenta.addActionListener(this);
		panel2.add(mntmCuenta);

		mntmPrivacidad = new JMenuItem("Privacidad y Seguridad");
		mntmPrivacidad.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmPrivacidad.setForeground(Color.BLACK);
		mntmPrivacidad.setBackground(UIManager.getColor("Button.darkShadow"));
		mntmPrivacidad.setFont(new Font("Arial", Font.PLAIN, 24));
		mntmPrivacidad.addActionListener(this);
		panel2.add(mntmPrivacidad);

		mntmNotificaciones = new JMenuItem("Notificaciones");
		mntmNotificaciones.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmNotificaciones.setForeground(Color.BLACK);
		mntmNotificaciones.setBackground(UIManager.getColor("Button.darkShadow"));
		mntmNotificaciones.setFont(new Font("Arial", Font.PLAIN, 24));
		mntmNotificaciones.addActionListener(this);
		panel2.add(mntmNotificaciones);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.darkShadow"));
		panel2.add(panel);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(UIManager.getColor("Button.darkShadow"));
		panel2.add(panel_10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.darkShadow"));
		panel2.add(panel_1);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(UIManager.getColor("Button.darkShadow"));
		panel2.add(panel_12);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(UIManager.getColor("Button.darkShadow"));
		panel2.add(panel_11);

		panelNotifiaciones = new JPanel();
		panelNotifiaciones.setBounds(550, 11, 803, 717);
		PConfiguraciones.add(panelNotifiaciones);
		panelNotifiaciones.setVisible(false);
		panelNotifiaciones.setLayout(null);
		panelNotifiaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNotifiaciones.setBackground(UIManager.getColor("Button.darkShadow"));

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(Color.BLACK));
		panel_5.setBackground(UIManager.getColor("Button.darkShadow"));
		panel_5.setBounds(0, 0, 803, 71);
		panelNotifiaciones.add(panel_5);

		JLabel lblNotificaciones = new JLabel("Notificaciones");
		lblNotificaciones.setForeground(Color.WHITE);
		lblNotificaciones.setFont(new Font("Arial", Font.PLAIN, 40));
		lblNotificaciones.setBackground(Color.WHITE);
		lblNotificaciones.setBounds(10, 11, 272, 43);
		panel_5.add(lblNotificaciones);

		panelPrivacidad = new JPanel();
		panelPrivacidad.setBounds(550, 11, 803, 717);
		PConfiguraciones.add(panelPrivacidad);
		panelPrivacidad.setVisible(false);
		panelPrivacidad.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPrivacidad.setBackground(UIManager.getColor("Button.darkShadow"));
		panelPrivacidad.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 803, 71);
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(Color.BLACK));
		panel_3.setBackground(UIManager.getColor("Button.darkShadow"));
		panelPrivacidad.add(panel_3);

		JLabel lblPrivacidad = new JLabel("Privacidad y Seguridad");
		lblPrivacidad.setBounds(10, 11, 473, 43);
		panel_3.add(lblPrivacidad);
		lblPrivacidad.setForeground(Color.WHITE);
		lblPrivacidad.setFont(new Font("Arial", Font.PLAIN, 40));
		lblPrivacidad.setBackground(Color.WHITE);

		panelCuenta = new JPanel();
		panelCuenta.setBounds(550, 11, 803, 717);
		PConfiguraciones.add(panelCuenta);
		panelCuenta.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCuenta.setBackground(UIManager.getColor("Button.darkShadow"));
		panelCuenta.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.BLACK));
		panel_2.setBackground(UIManager.getColor("Button.darkShadow"));
		panel_2.setBounds(0, 0, 803, 71);
		panelCuenta.add(panel_2);

		JLabel lblCuenta = new JLabel("Cuenta");
		lblCuenta.setForeground(Color.WHITE);
		lblCuenta.setFont(new Font("Arial", Font.PLAIN, 40));
		lblCuenta.setBackground(Color.WHITE);
		lblCuenta.setBounds(10, 11, 272, 43);
		panel_2.add(lblCuenta);

		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmCuenta) {
			panelCuenta.setVisible(true);
			panelPrivacidad.setVisible(false);
			panelNotifiaciones.setVisible(false);
		}

		if (arg0.getSource() == mntmPrivacidad) {
			panelPrivacidad.setVisible(true);
			panelCuenta.setVisible(false);
			panelNotifiaciones.setVisible(false);
		}

		if (arg0.getSource() == mntmNotificaciones) {
			panelNotifiaciones.setVisible(true);
			panelCuenta.setVisible(false);
			panelPrivacidad.setVisible(false);
		}
	}
}