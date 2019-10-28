package resonance.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;

public class VentanaPerfil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPerfil frame = new VentanaPerfil();
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
	public VentanaPerfil() {
		getContentPane().setBackground(Color.DARK_GRAY);

		this.setExtendedState(MAXIMIZED_BOTH);
		Dimension tamano = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(tamano);
		getContentPane().setSize(tamano);
		getContentPane().setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBounds(0, 0, 1599, 59);
	    getContentPane().add(panel);
	    panel.setLayout(null);
	    
	    JLabel imgInicio = new JLabel("New label");
	    imgInicio.setIcon(new ImageIcon(VentanaPerfil.class.getResource("/imagenes/Logo1Reducido.png")));
	    imgInicio.setBounds(10, 11, 53, 48);
	    panel.add(imgInicio);
	    
	    JLabel lblInicio = new JLabel("Inicio");
	    lblInicio.setFont(new Font("Segoe UI", Font.BOLD, 20));
	    lblInicio.setBounds(73, 15, 52, 31);
	    panel.add(lblInicio);
		
	

	    
	  //  getContentPane().add(scrollPane); 
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setPreferredSize(new Dimension(1564,754));
	    JScrollPane scroll = new JScrollPane (panel_1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scroll.setLocation(20, 70);
	    scroll.setSize(1564,754);
	    getContentPane().add(scroll);
	    
	    //;(10, 70, 1564, 745);
	    
	}
}
