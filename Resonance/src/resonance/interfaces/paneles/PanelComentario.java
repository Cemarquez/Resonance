package resonance.interfaces.paneles;

import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import resonance.texto.Comentario;

public class PanelComentario extends JPanel {

	public PanelComentario(Comentario c) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblNombre = new JLabel(c.getIdUser());
		panel.add(lblNombre);

		JLabel label = new JLabel("                                                   ");
		panel.add(label);

		JLabel lblFecha = new JLabel(toStringFecha(c.getFecha()));
		panel.add(lblFecha);

		JTextPane textPane = new JTextPane();
		add(textPane);
		textPane.setEditable(false);
		textPane.setText(c.getMensaje());

		JSeparator separator = new JSeparator();
		add(separator);

	}

	public String toStringFecha(Date fecha) {
		String f = "";
		int d = fecha.getDay();
		int m = fecha.getMonth();
		int a = fecha.getYear();

		f = d + "/" + m + "/" + a + "/" + " " + fecha.getHours() + ":" + fecha.getMinutes();
		return f;
	}
}
