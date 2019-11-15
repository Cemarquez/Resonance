package resonance.interfaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import resonance.archivos.AdministradorDeArchivos;
import resonance.interfaces.misc.RoundJTextArea;
import resonance.interfaces.paneles.PanelComentario;
import resonance.texto.Comentario;
import resonance.texto.Publicacion;
import resonance.usuario.Usuario;

public class VentanaComentarios extends JFrame {

	private Publicacion p;
	private Usuario userLogin;
	private JPanel contentPanel;
	private JButton btnEnviarComentario;
	private JPanel panelScrollComentarios;

	public VentanaComentarios(Publicacion p) {
		this.p = p;
		this.userLogin = ControladoraPrincipal.getI().getUserLogin();
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		JPanel panelComentarios = new JPanel();
		panelComentarios.setBounds(10, 5, 414, 32);
		panelComentarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.add(panelComentarios);
		panelComentarios.setLayout(null);

		JLabel lblComentarios = new JLabel(
				"Comentarios                                                               ");
		lblComentarios.setBounds(19, 6, 342, 20);
		lblComentarios.setFont(new Font("Teen Light", Font.BOLD, 15));
		panelComentarios.add(lblComentarios);

		JScrollPane scrollPaneComentarios = new JScrollPane();
		scrollPaneComentarios.setBounds(10, 48, 414, 194);
		contentPanel.add(scrollPaneComentarios);

		panelScrollComentarios = new JPanel();
		scrollPaneComentarios.setViewportView(panelScrollComentarios);
		panelScrollComentarios.setLayout(new BoxLayout(panelScrollComentarios, BoxLayout.Y_AXIS));
		JPanel panelEscribirMensaje = new JPanel();
		panelEscribirMensaje.setBackground(Color.WHITE);
		panelEscribirMensaje.setBounds(10, 253, 414, 52);
		panelEscribirMensaje.setLayout(null);

		RoundJTextArea textArea = new RoundJTextArea();
		JScrollPane jp = new JScrollPane(textArea);
		jp.setBounds(0, 0, 365, 50);
		jp.setBorder(null);
		panelEscribirMensaje.add(jp);
		contentPanel.add(panelEscribirMensaje);
		cargarComentarios();
		btnEnviarComentario = new JButton("");
		btnEnviarComentario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Comentario c = new Comentario(userLogin.getID(), textArea.getText(), new Date());
				p.agregarComentario(c);
				addComentario(c);
				textArea.setText("");
				AdministradorDeArchivos
						.serializarGrafo(ControladoraPrincipal.getI().getResonance().getAdministradorDeUsuarios());
			}
		});
		btnEnviarComentario
				.setIcon(new ImageIcon(VentanaComentarios.class.getResource("/imagenes/icono_enviar_chat.png")));
		btnEnviarComentario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviarComentario.setContentAreaFilled(false);
		btnEnviarComentario.setBorderPainted(false);
		btnEnviarComentario.setBounds(368, 11, 36, 23);
		panelEscribirMensaje.add(btnEnviarComentario);
		setSize(450, 360);
		panelComentarios.updateUI();
	}

	public void cargarComentarios() {
		ArrayList<Comentario> comentarios = p.getComentarios();
		for (Comentario c : comentarios) {
			PanelComentario p = new PanelComentario(c);
			panelScrollComentarios.add(p);
		}
	}

	public void addComentario(Comentario c) {
		PanelComentario pC = new PanelComentario(c);
		panelScrollComentarios.add(pC);
		panelScrollComentarios.updateUI();
	}
}
