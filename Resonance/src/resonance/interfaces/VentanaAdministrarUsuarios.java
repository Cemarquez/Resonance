package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import resonance.Resonance;
import resonance.archivos.AdministradorDeArchivos;
import resonance.estructura.RedDeUsuarios;
import resonance.usuario.Usuario;

public class VentanaAdministrarUsuarios extends JFrame {

	private Resonance resonance;
	private VentanaAdministrarUsuarios instance;
	private JPanel panelUsuarios;
	private JTextField textField;

	public VentanaAdministrarUsuarios() {
		this.resonance = ControladoraPrincipal.getI().getResonance();
		instance = this;
		this.setExtendedState(MAXIMIZED_BOTH);
		Dimension tamano = new Dimension(1160, 768);
		setSize(tamano);
		getContentPane().setLayout(null);
		getContentPane().setSize(tamano);
		getContentPane().setBackground(Color.decode("#5B5151"));

		JPanel panelEstado = new JPanel();
		panelEstado.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEstado.setBackground(SystemColor.controlDkShadow);
		panelEstado.setBounds(0, 0, 1174, 739);
		getContentPane().add(panelEstado);
		panelEstado.setLayout(null);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 823, 76);
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.setBackground(SystemColor.controlDkShadow);
		panelEstado.add(panelTitulo);
		panelTitulo.setLayout(null);

		JLabel lblNewLabel = new JLabel("ADMINISTRADOR DE USUARIOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 751, 54);
		panelTitulo.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(822, 81, 309, 647);
		panelEstado.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblLmiteGeneral = new JLabel("L\u00EDmite general: ");
		lblLmiteGeneral.setBounds(10, 63, 116, 14);
		panel_1.add(lblLmiteGeneral);

		textField = new JTextField();
		textField.setText(resonance.getAdministradorDeUsuarios().getLimiteAmigos() + "");
		textField.setBounds(108, 60, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		JLabel lblNoSePuede = new JLabel("No se puede cambiar el limite pues, hay ");
		lblNoSePuede.setForeground(Color.RED);
		lblNoSePuede.setBounds(41, 155, 206, 40);
		lblNoSePuede.setVisible(false);
		panel_1.add(lblNoSePuede);

		JLabel lvlNose = new JLabel("un usuario que posee m\u00E1s amigos del limite nuevo");
		lvlNose.setForeground(Color.RED);
		lvlNose.setBounds(24, 193, 285, 14);
		lvlNose.setVisible(false);
		panel_1.add(lvlNose);
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int lim = Integer.parseInt(textField.getText());
				if (lim < resonance.getAdministradorDeUsuarios().getMayorNumAmigos()) {

					resonance.getAdministradorDeUsuarios().setLimiteAmigos(lim);
					AdministradorDeArchivos.serializarGrafo(resonance.getAdministradorDeUsuarios());

					lblNoSePuede.setVisible(false);
					lvlNose.setVisible(false);

				} else {
					lblNoSePuede.setVisible(true);
					lvlNose.setVisible(true);
				}
			}
		});
		btnSalvar.setBackground(SystemColor.controlShadow);
		btnSalvar.setBounds(108, 218, 89, 23);
		panel_1.add(btnSalvar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 802, 647);
		panelEstado.add(scrollPane);

		panelUsuarios = new JPanel();
		scrollPane.setViewportView(panelUsuarios);
		panelUsuarios.setBackground(SystemColor.control);
		panelUsuarios.setLayout(null);
		generarUsuarios();
		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);
	}

	public void generarUsuarios() {
		int y = 0, tamano = 65;
		RedDeUsuarios red = resonance.getAdministradorDeUsuarios();
		HashMap<String, Usuario> grafo = red.getGrafo();

		Iterator<String> ite = grafo.keySet().iterator();
		while (ite.hasNext()) {
			Object obj = ite.next();
			Usuario a = grafo.get(obj);
			JPanel panelUsuario = new JPanel();
			panelUsuario.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					instance.setVisible(false);
					instance.dispose();
					VentanaEditarUsuario v = new VentanaEditarUsuario(a);
					v.setVisible(true);
				}
			});
			panelUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelUsuario.setBackground(SystemColor.controlDkShadow);
			panelUsuario.setBounds(0, y, 802, tamano);
			panelUsuarios.add(panelUsuario);
			panelUsuario.setLayout(null);

			JLabel lblFoto = new JLabel("");
			lblFoto.setSize(48, 48);
			try {
				Image ima = ImageIO.read(a.getPerfil().getFotoPerfil());
				ImageIcon icon = new ImageIcon(
						ima.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));

				lblFoto.setIcon(icon);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lblFoto.setBounds(14, 0, 50, 65);
			panelUsuario.add(lblFoto);

			JLabel lblNombre = new JLabel(a.getID());
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNombre.setBounds(74, 0, 299, 65);
			panelUsuario.add(lblNombre);
			panelUsuario.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					VentanaEditarUsuario v = new VentanaEditarUsuario(a);
					v.setVisible(true);
					instance.setVisible(false);
					instance.dispose();
				}
			});

			y += tamano;
		}

	}
}
