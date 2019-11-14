package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import resonance.archivos.AdministradorDeArchivos;

public class VentanaSubirFotoPerfil extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JFileChooser file;
	private ImageIcon fotoPerfil;
	private JLabel iconoSubirFotoPerfil;
	private BufferedImage img;
	private BufferedImage imgBoton;
	private VentantaLogIN vLogin;
	private JLabel labelContinuar;
	private JPanel panelBtnContinuar;
	private JLabel lblQuitarFoto;
	private JPanel panelBtnRegresar;
	private JLabel lblRegresar;
	private File fileFoto;
	private VentanaSubirFotoPerfil instance = this;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public VentanaSubirFotoPerfil() {
		this.vLogin = ControladoraPrincipal.getI();
		setSize(1366, 768);
		getContentPane().setSize(new Dimension(1366, 768));
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);

		JPanel panelSubirFoto = new JPanel();
		panelSubirFoto.setBackground(Color.WHITE);
		panelSubirFoto.setForeground(Color.LIGHT_GRAY);
		panelSubirFoto.setBorder(new LineBorder(new Color(255, 255, 255), 58, true));
		panelSubirFoto.setBounds(114, 78, 1151, 568);
		getContentPane().add(panelSubirFoto);
		panelSubirFoto.setLayout(null);

		iconoSubirFotoPerfil = new JLabel("New label");
		iconoSubirFotoPerfil
				.setIcon(new ImageIcon(VentanaSubirFotoPerfil.class.getResource("/imagenes/fotoperfil_icono.png")));
		iconoSubirFotoPerfil.setBounds(473, 101, 259, 256);
		panelSubirFoto.add(iconoSubirFotoPerfil);

		JPanel panelBtnSubirFoto = new JPanel();
		panelBtnSubirFoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen jpg, png, gif", "jpg",
						"png", "gif", "jpeg");

				file = new JFileChooser();
				file.setFileFilter(filter);
				file.showOpenDialog(panelBtnSubirFoto);

				fileFoto = file.getSelectedFile();

				if (fileFoto != null) {

					try {
						img = ImageIO.read(fileFoto);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Image img2 = img.getScaledInstance(iconoSubirFotoPerfil.getHeight(),
							iconoSubirFotoPerfil.getWidth(), Image.SCALE_SMOOTH);
					String origen = fileFoto.getPath();

					fotoPerfil = new ImageIcon(img2);
					iconoSubirFotoPerfil.setIcon(fotoPerfil);

					panelBtnContinuar.setVisible(true);

					lblQuitarFoto.setVisible(true);

				}

			}
		});
		panelBtnSubirFoto.setBorder(new LineBorder(new Color(0, 0, 0), 42, true));
		panelBtnSubirFoto.setForeground(Color.WHITE);
		panelBtnSubirFoto.setBackground(Color.WHITE);
		panelBtnSubirFoto.setBounds(486, 380, 228, 50);
		panelSubirFoto.add(panelBtnSubirFoto);
		panelBtnSubirFoto.setLayout(null);

		JLabel lblSubirFoto = new JLabel("Subir foto");
		lblSubirFoto.setBounds(70, 11, 112, 28);
		lblSubirFoto.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblSubirFoto.setForeground(Color.WHITE);
		panelBtnSubirFoto.add(lblSubirFoto);

		JLabel labelTituloSubirFoto = new JLabel("Sube tu foto de perfil");
		labelTituloSubirFoto.setForeground(Color.BLACK);
		labelTituloSubirFoto.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		labelTituloSubirFoto.setBounds(495, 25, 246, 28);
		panelSubirFoto.add(labelTituloSubirFoto);

		panelBtnContinuar = new JPanel();
		panelBtnContinuar.setLayout(null);
		panelBtnContinuar.setForeground(Color.WHITE);
		panelBtnContinuar.setBorder(new LineBorder(new Color(0, 0, 0), 42, true));
		panelBtnContinuar.setBackground(Color.WHITE);
		panelBtnContinuar.setBounds(875, 473, 228, 50);
		panelBtnContinuar.setVisible(false);
		panelSubirFoto.add(panelBtnContinuar);

		labelContinuar = new JLabel("Continuar");
		labelContinuar.setForeground(Color.WHITE);
		labelContinuar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		labelContinuar.setBounds(70, 11, 112, 28);
		panelBtnContinuar.add(labelContinuar);



		lblQuitarFoto = new JLabel("Quitar foto\r\n");
		lblQuitarFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuitarFoto.setForeground(Color.BLACK);
		lblQuitarFoto.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Font fuenteQuitarFoto = lblQuitarFoto.getFont();
		Map atributos = fuenteQuitarFoto.getAttributes();
		atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblQuitarFoto.setFont(fuenteQuitarFoto.deriveFont(atributos));
		lblQuitarFoto.setBounds(473, 441, 246, 28);
		lblQuitarFoto.setVisible(false);
		lblQuitarFoto.addMouseListener(this);
		panelSubirFoto.add(lblQuitarFoto);

		panelBtnRegresar = new JPanel();
		panelBtnRegresar.setLayout(null);
		panelBtnRegresar.setForeground(Color.WHITE);
		panelBtnRegresar.setBorder(new LineBorder(new Color(0, 0, 0), 42, true));
		panelBtnRegresar.setBackground(Color.WHITE);
		panelBtnRegresar.setBounds(46, 473, 228, 50);
		panelSubirFoto.add(panelBtnRegresar);

		lblRegresar = new JLabel("Regresar");
		lblRegresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegresar.setForeground(Color.WHITE);
		lblRegresar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblRegresar.setBounds(59, 11, 91, 28);
		panelBtnRegresar.add(lblRegresar);

		panelBtnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				AdministradorDeArchivos.cambiarFotoPerfil(fileFoto, vLogin.getUserLogin().getID());

				VentanaRaiz vRaiz = new VentanaRaiz();
				vRaiz.setVisible(true);
				instance.dispose();

			}
		});

		this.setExtendedState(MAXIMIZED_BOTH);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getSource() == lblQuitarFoto) {
			iconoSubirFotoPerfil
					.setIcon(new ImageIcon(VentanaSubirFotoPerfil.class.getResource("/imagenes/fotoperfil_icono.png")));

			fotoPerfil = (ImageIcon) iconoSubirFotoPerfil.getIcon();

			lblQuitarFoto.setVisible(false);

			panelBtnContinuar.setVisible(false);

		}



		if (e.getSource() == panelBtnRegresar) {

			// Se devuelve al registro

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
