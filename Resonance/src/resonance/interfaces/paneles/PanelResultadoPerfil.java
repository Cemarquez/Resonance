package resonance.interfaces.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import resonance.interfaces.ControladoraPrincipal;
import resonance.usuario.Usuario;

public class PanelResultadoPerfil extends JPanel {

	private Usuario userLogin;

	public PanelResultadoPerfil(Usuario user) {
		setSize(440, 48);
		setBackground(SystemColor.controlDkShadow);
		this.userLogin = ControladoraPrincipal.getI().getUserLogin();
		setLayout(null);
		JPanel panelUsuario = new JPanel();
		panelUsuario.setBounds(0, 0, 440, 49);
		panelUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuario.setBackground(SystemColor.controlDkShadow);
		add(panelUsuario);

		JLabel lblFoto = new JLabel("       ");
		lblFoto.setSize(48, 48);
		try {
			Image ima = ImageIO.read(user.getPerfil().getFotoPerfil());
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
		panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.X_AXIS));
		panelUsuario.add(lblFoto);

		JLabel lblNombre = new JLabel(user.getID());
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelUsuario.add(lblNombre);

//		 Metodo que abre perfil seleccionado en nueva ventana
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent arg0) {

				PanelPerfilUsuario perfilUsuario = new PanelPerfilUsuario(user, userLogin);

				JFrame frame = new JFrame();

				frame.setBounds(0, 0, perfilUsuario.getWidth(), perfilUsuario.getHeight());
				frame.getContentPane().add(perfilUsuario);
				frame.setVisible(true);
			}
		});
	}
}
