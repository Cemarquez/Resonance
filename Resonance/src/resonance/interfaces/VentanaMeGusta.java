package resonance.interfaces;

import javax.swing.JFrame;

import resonance.texto.Publicacion;
import resonance.texto.Reaccion;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Dimension;

public class VentanaMeGusta extends JFrame{

	public VentanaMeGusta(Publicacion p)
	{
		setSize(new Dimension(452, 322));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 44);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPersonasQueHan = new JLabel("Personas que han reaccionado a la publicaci\u00F3n");
		lblPersonasQueHan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPersonasQueHan.setBounds(0, 0, 356, 33);
		panel.add(lblPersonasQueHan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 44, 434, 218);
		getContentPane().add(scrollPane);
		
		JPanel panelScroll = new JPanel();
		scrollPane.setViewportView(panelScroll);
		panelScroll.setLayout(new BoxLayout(panelScroll, BoxLayout.Y_AXIS));
		
		int i=1;
		for(Reaccion r: p.getReacciones())
		{
			panelScroll.add(new JLabel(i+". " + r.getIdUser() +"\n"));
			
			i++;
		}
		
	}
}
