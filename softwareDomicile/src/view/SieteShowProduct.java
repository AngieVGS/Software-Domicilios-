package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import controller.Controller;
import model.entity.Product;

public class SieteShowProduct extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel center;

	public SieteShowProduct(Controller controller) {
		setTitle("Fast & Luscious");
		setIconImage(new ImageIcon("src/image/logoIcon.png").getImage());
		setSize(ConstantsUI.SIZE_WINDOW);
		setUndecorated(true);
		getContentPane().setBackground(ConstantsUI.BACKGROUND_COLOR);

		center = new JPanel();
		add(new JScrollPane(center), BorderLayout.CENTER);
	}

	/*
	 * este metodo me muestra los productos seleccionados que deseo comprar
	 */
	
}