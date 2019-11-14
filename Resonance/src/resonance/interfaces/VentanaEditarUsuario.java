package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import resonance.Resonance;
import resonance.archivos.AdministradorDeArchivos;
import resonance.usuario.Usuario;

public class VentanaEditarUsuario extends JFrame {
	private Resonance resonance;
	private VentanaEditarUsuario instance;
	private JTextField textFieldNombre;
	private JTextField textFieldEdad;
	private JTextField textFieldCorreo;
	private JTextField textFieldDireccion;
	private JTextField textFieldLimite;

	public VentanaEditarUsuario(Usuario usuario) {
		this.resonance = ControladoraPrincipal.getI().getResonance();
		instance = this;
		this.setExtendedState(MAXIMIZED_BOTH);
		Dimension tamano = new Dimension(823, 550);
		setSize(tamano);
		getContentPane().setLayout(null);
		getContentPane().setSize(new Dimension(900, 768));
		getContentPane().setBackground(Color.decode("#5B5151"));

		JPanel panelEstado = new JPanel();
		panelEstado.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEstado.setBackground(SystemColor.controlDkShadow);
		panelEstado.setBounds(0, 0, 818, 739);
		getContentPane().add(panelEstado);
		panelEstado.setLayout(null);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 823, 76);
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.setBackground(SystemColor.controlDkShadow);
		panelEstado.add(panelTitulo);
		panelTitulo.setLayout(null);

		JLabel lblNewLabel = new JLabel("EDITOR DE USUARIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 751, 54);
		panelTitulo.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(10, 87, 798, 400);
		panelEstado.add(panel);
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

		JLabel lblLimiteDeAmigos = new JLabel("Limite de amigos:");
		lblLimiteDeAmigos.setBounds(41, 256, 130, 14);
		panel.add(lblLimiteDeAmigos);

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

		textFieldLimite = new JTextField();
		textFieldLimite.setText(usuario.getLimiteAmigos() + "");
		textFieldLimite.setBounds(146, 253, 86, 20);
		panel.add(textFieldLimite);
		textFieldLimite.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre = textFieldNombre.getText();
				String edad = textFieldNombre.getText();
				String correo = textFieldCorreo.getText();
				String direccion = textFieldDireccion.getText();
				int limite = Integer.parseInt(textFieldLimite.getText());

				ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios().obtenerUsuario(usuario.getID())
						.setLimiteAmigos(limite);
				ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios().obtenerUsuario(usuario.getID())
						.setCorreo(correo);
				ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios().obtenerUsuario(usuario.getID())
						.setNombre(nombre);
				ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios().obtenerUsuario(usuario.getID())
						.setDireccion(direccion);

				AdministradorDeArchivos
						.serializarGrafo(ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios());

				instance.setVisible(false);
				instance.dispose();

				VentanaAdministrarUsuarios v = new VentanaAdministrarUsuarios();
				v.setVisible(true);

			}
		});
		btnSalvar.setForeground(SystemColor.controlShadow);
		btnSalvar.setBounds(327, 353, 89, 23);
		panel.add(btnSalvar);

		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);
	}
}
