package resonance.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

public class PanelConfiguracion extends JPanel implements ActionListener {
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
	/**
	 * Create the panel.
	 */
	public PanelConfiguracion() {
		setBackground(Color.WHITE);
		setSize(1095, 717);
		setLayout(null);

		JPanel panelConfiguracion = new JPanel();
		panelConfiguracion.setBounds(0, 0, 292, 717);
		panelConfiguracion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelConfiguracion.setBackground(SystemColor.controlDkShadow);
		panelConfiguracion.setLayout(null);

		add(panelConfiguracion);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(Color.BLACK));
		panel1.setBackground(SystemColor.controlDkShadow);
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
		panel2.setBackground(SystemColor.controlDkShadow);
		panel2.setBounds(0, 71, 292, 646);
		panelConfiguracion.add(panel2);
		panel2.setLayout(new GridLayout(0, 1, 0, 0));

		mntmCuenta = new JMenuItem("Cuenta");
		mntmCuenta.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		mntmCuenta.setForeground(Color.BLACK);
		mntmCuenta.setBackground(SystemColor.controlDkShadow);
		mntmCuenta.setFont(new Font("Arial", Font.PLAIN, 24));
		mntmCuenta.addActionListener(this);
		panel2.add(mntmCuenta);

		mntmPrivacidad = new JMenuItem("Privacidad y Seguridad");
		mntmPrivacidad.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmPrivacidad.setForeground(Color.BLACK);
		mntmPrivacidad.setBackground(SystemColor.controlDkShadow);
		mntmPrivacidad.setFont(new Font("Arial", Font.PLAIN, 24));
		mntmPrivacidad.addActionListener(this);
		panel2.add(mntmPrivacidad);

		mntmNotificaciones = new JMenuItem("Notificaciones");
		mntmNotificaciones.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mntmNotificaciones.setForeground(Color.BLACK);
		mntmNotificaciones.setBackground(SystemColor.controlDkShadow);
		mntmNotificaciones.setFont(new Font("Arial", Font.PLAIN, 24));
		mntmNotificaciones.addActionListener(this);
		panel2.add(mntmNotificaciones);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlDkShadow);
		panel2.add(panel);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.controlDkShadow);
		panel2.add(panel_10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlDkShadow);
		panel2.add(panel_1);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(SystemColor.controlDkShadow);
		panel2.add(panel_12);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(SystemColor.controlDkShadow);
		panel2.add(panel_11);

		panelNotifiaciones = new JPanel();
		panelNotifiaciones.setBounds(292, 0, 803, 717);
		add(panelNotifiaciones);
		panelNotifiaciones.setVisible(false);
		panelNotifiaciones.setLayout(null);
		panelNotifiaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNotifiaciones.setBackground(SystemColor.controlDkShadow);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(Color.BLACK));
		panel_5.setBackground(SystemColor.controlDkShadow);
		panel_5.setBounds(0, 0, 803, 71);
		panelNotifiaciones.add(panel_5);

		JLabel lblNotificaciones = new JLabel("Notificaciones");
		lblNotificaciones.setForeground(Color.WHITE);
		lblNotificaciones.setFont(new Font("Arial", Font.PLAIN, 40));
		lblNotificaciones.setBackground(Color.WHITE);
		lblNotificaciones.setBounds(10, 11, 272, 43);
		panel_5.add(lblNotificaciones);

		panelPrivacidad = new JPanel();
		panelPrivacidad.setBounds(292, 0, 803, 717);
		add(panelPrivacidad);
		panelPrivacidad.setVisible(false);
		panelPrivacidad.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPrivacidad.setBackground(SystemColor.controlDkShadow);
		panelPrivacidad.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 803, 71);
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(Color.BLACK));
		panel_3.setBackground(SystemColor.controlDkShadow);
		panelPrivacidad.add(panel_3);

		JLabel lblPrivacidad = new JLabel("Privacidad y Seguridad");
		lblPrivacidad.setBounds(10, 11, 473, 43);
		panel_3.add(lblPrivacidad);
		lblPrivacidad.setForeground(Color.WHITE);
		lblPrivacidad.setFont(new Font("Arial", Font.PLAIN, 40));
		lblPrivacidad.setBackground(Color.WHITE);

		panelCuenta = new JPanel();
		panelCuenta.setBounds(292, 0, 803, 717);
		add(panelCuenta);
		panelCuenta.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCuenta.setBackground(SystemColor.controlDkShadow);
		panelCuenta.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.BLACK));
		panel_2.setBackground(SystemColor.controlDkShadow);
		panel_2.setBounds(0, 0, 803, 71);
		panelCuenta.add(panel_2);

		JLabel lblCuenta = new JLabel("Cuenta");
		lblCuenta.setForeground(Color.WHITE);
		lblCuenta.setFont(new Font("Arial", Font.PLAIN, 40));
		lblCuenta.setBackground(Color.WHITE);
		lblCuenta.setBounds(10, 11, 272, 43);
		panel_2.add(lblCuenta);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmCuenta) {
			panelCuenta.setVisible(true);
			panelPrivacidad.setVisible(false);
			panelNotifiaciones.setVisible(false);
		}

		if (e.getSource() == mntmPrivacidad) {
			panelPrivacidad.setVisible(true);
			panelCuenta.setVisible(false);
			panelNotifiaciones.setVisible(false);
		}

		if (e.getSource() == mntmNotificaciones) {
			panelNotifiaciones.setVisible(true);
			panelCuenta.setVisible(false);
			panelPrivacidad.setVisible(false);
		}

	}

}
