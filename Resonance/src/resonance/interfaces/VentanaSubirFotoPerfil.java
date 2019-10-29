package resonance.interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaSubirFotoPerfil extends JFrame {

	private JPanel contentPane;
	private JFileChooser file;
	private ImageIcon fotoPerfil;
	private JLabel iconoSubirFotoPerfil;
	private BufferedImage img;
	private BufferedImage imgBoton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSubirFotoPerfil frame = new VentanaSubirFotoPerfil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaSubirFotoPerfil() {
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
						"png", "gif",
						"jpeg");

				file = new JFileChooser();
				file.setFileFilter(filter);
				file.showOpenDialog(panelBtnSubirFoto);

				File archivo = file.getSelectedFile();



				if (archivo != null) {

					try {
						img = ImageIO.read(archivo);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}



					Image img2 = img.getScaledInstance(iconoSubirFotoPerfil.getHeight(),
							iconoSubirFotoPerfil.getWidth(), Image.SCALE_SMOOTH);
					String origen = archivo.getPath();

					fotoPerfil = new ImageIcon(img2);
					iconoSubirFotoPerfil.setIcon(fotoPerfil);

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

		this.setExtendedState(MAXIMIZED_BOTH);

	}
}
