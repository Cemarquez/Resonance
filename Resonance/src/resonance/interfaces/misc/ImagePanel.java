package resonance.interfaces.misc;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private Image img;

	public ImagePanel(String img, int width, int height) {
		this(new ImageIcon(img).getImage(), width, height);
	}

	public ImagePanel(Image img, int width, int height) {
		this.img = img;
		Dimension size = new Dimension(width, height);
		// setPreferredSize(size);
		// setMinimumSize(size);
		// setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
