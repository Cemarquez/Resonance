package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.Action;
import javax.swing.DebugGraphics;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.GridLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;

public class VentanaConfiguracion extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private JMenuItem mntmCuenta;
	private JMenuItem mntmPrivacidad;
	private JMenuItem mntmNotificaciones;
	private JPanel panelCuenta;
	private JPanel panelPrivacidad;
	private JPanel panelNotifiaciones;
	
	public VentanaConfiguracion() 
	{

		this.setExtendedState(MAXIMIZED_BOTH);
		Dimension tamano = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(tamano);
		getContentPane().setLayout(null);
		getContentPane().setSize(tamano);
		getContentPane().setBackground(Color.decode("#5B5151"));
		
		JPanel panelConfiguracion = new JPanel();
		panelConfiguracion.setBorder(null);
		panelConfiguracion.setBackground(UIManager.getColor("Button.darkShadow"));
		panelConfiguracion.setBounds(257, 11, 292, 717);
		getContentPane().add(panelConfiguracion);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.darkShadow"));
		panel2.add(panel_1);
		
		panelPrivacidad = new JPanel();
		panelPrivacidad.setVisible(false);
		panelPrivacidad.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPrivacidad.setBackground(UIManager.getColor("Button.darkShadow"));
		panelPrivacidad.setBounds(547, 11, 803, 717);
		getContentPane().add(panelPrivacidad);
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
		panelCuenta.setBounds(547, 11, 803, 717);
		getContentPane().add(panelCuenta);
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
		
		panelNotifiaciones = new JPanel();
		panelNotifiaciones.setVisible(false);
		panelNotifiaciones.setLayout(null);
		panelNotifiaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNotifiaciones.setBackground(UIManager.getColor("Button.darkShadow"));
		panelNotifiaciones.setBounds(547, 11, 803, 717);
		getContentPane().add(panelNotifiaciones);
		
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

		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);




	}

	public static void main(String[] args) {
		new VentanaConfiguracion().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getSource() == mntmCuenta)
		{
			panelCuenta.setVisible(true);
			panelPrivacidad.setVisible(false);
			panelNotifiaciones.setVisible(false);
		}
		
		if(arg0.getSource() == mntmPrivacidad)
		{
			panelPrivacidad.setVisible(true);
			panelCuenta.setVisible(false);
			panelNotifiaciones.setVisible(false);
		}
		
		if(arg0.getSource() == mntmNotificaciones)
		{
			panelNotifiaciones.setVisible(true);
			panelCuenta.setVisible(false);
			panelPrivacidad.setVisible(false);
		}
	}

}