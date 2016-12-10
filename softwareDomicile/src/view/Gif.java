package view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import controller.Controller;

public class Gif extends JFrame {

	private static final long serialVersionUID = 1L;
	private ImageIcon loading;

	public Gif(Controller controller) {
	    loading = new ImageIcon("src/image/gif.gif");
	    add(new JLabel(loading, JLabel.NORTH_EAST));
	    setBackground(Color.decode("#fbfbf6"));
	    getContentPane().setBackground(Color.WHITE);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(ConstantsUI.SIZE_WINDOW);
	    setIconImage(new ImageIcon("src/image/logoIcon.png").getImage());
	    setUndecorated(true);
	}

	public void showGif() {
		
		setVisible(true);
		try { 
	    	Thread.sleep(3000); 
	    	 setVisible(false);
	    	} catch (Exception ignored) {} 
	}
}