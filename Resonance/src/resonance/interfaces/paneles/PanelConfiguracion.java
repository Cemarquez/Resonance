package resonance.interfaces.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import resonance.archivos.AdministradorDeArchivos;
import resonance.interfaces.ControladoraPrincipal;
import resonance.interfaces.VentanaRaiz;
import resonance.usuario.Usuario;

public class PanelConfiguracion extends JPanel implements ActionListener {
	private JMenuItem mntmCuenta;
	private JPanel panelCuenta;
	private JMenuItem mntmPerfil;
	private JMenuItem mntmInicio;
	private JMenuItem mntmChat;
	private JMenuItem mntmConfiguracion;
	private JMenuItem mntmCerrarSesion;

	private JTextField textFieldNombre;
	private JTextField textFieldEdad;
	private JTextField textFieldCorreo;
	private JTextField textFieldDireccion;
	private Usuario usuario;
	private PanelConfiguracion instance;

	/**
	 * Create the panel.
	 */
	public PanelConfiguracion() {
		instance = this;
		setBackground(Color.WHITE);
		setSize(1095, 717);
		setLayout(null);
		this.usuario = ControladoraPrincipal.getI().getUserLogin();
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

		JPanel paneMenu = new JPanel();
		paneMenu.setBackground(SystemColor.controlDkShadow);
		panel2.add(paneMenu);

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

		panelCuenta = new JPanel();
		panelCuenta.setBounds(292, 0, 803, 717);
		add(panelCuenta);
		panelCuenta.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCuenta.setBackground(SystemColor.controlDkShadow);
		panelCuenta.setLayout(null);
		JPanel panel = new JPanel();

		panel.setBounds(10, 87, 770, 400);
		panelCuenta.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(41, 41, 46, 14);
		panel.add(lblNombre);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(41, 85, 46, 14);
		panel.add(lblEdad);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(41, 132, 46, 14);
		panel.add(lblCorreo);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(41, 187, 69, 14);
		panel.add(lblDireccion);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(146, 41, 86, 20);
		textFieldNombre.setText(usuario.getPerfil().getNombre());
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldEdad = new JTextField();
		textFieldEdad.setBounds(146, 85, 86, 20);

		panel.add(textFieldEdad);
		textFieldEdad.setColumns(10);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(146, 132, 86, 20);
		textFieldCorreo.setText(usuario.getPerfil().getCorreo());
		panel.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);

		textFieldDireccion = new JTextField();
		textFieldDireccion.setText(usuario.getPerfil().getDireccion());
		textFieldDireccion.setBounds(146, 187, 86, 20);
		panel.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre = textFieldNombre.getText();
				String edad = textFieldNombre.getText();
				String correo = textFieldCorreo.getText();
				String direccion = textFieldDireccion.getText();

				ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios().obtenerUsuario(usuario.getID())
						.setCorreo(correo);
				ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios().obtenerUsuario(usuario.getID())
						.setNombre(nombre);
				ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios().obtenerUsuario(usuario.getID())
						.setDireccion(direccion);

				AdministradorDeArchivos
						.serializarGrafo(ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios());

				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(instance);
				frame.dispose();

				VentanaRaiz v = new VentanaRaiz();
				v.setVisible(true);

			}
		});
		btnSalvar.setForeground(SystemColor.controlShadow);
		btnSalvar.setBounds(327, 353, 89, 23);
		panel.add(btnSalvar);

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
		}

	}

}
