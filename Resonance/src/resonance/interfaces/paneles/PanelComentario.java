package resonance.interfaces.paneles;

import javax.swing.JPanel;

import resonance.texto.Comentario;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class PanelComentario extends JPanel {

	public PanelComentario(Comentario c)
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblNombre = new JLabel(c.getIdUser());
		panel.add(lblNombre);
		
		JLabel label = new JLabel("                                                   ");
		panel.add(label);
		
		JLabel lblFecha = new JLabel(c.getFecha().toString());
		panel.add(lblFecha);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(c.getMensaje());
		panel_1.add(textPane);
		
	}
}
