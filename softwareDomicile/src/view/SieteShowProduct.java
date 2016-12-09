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
	public void fillPanelCenter(ArrayList<Product> listProductSelected) {
		center.setLayout(new GridLayout(listProductSelected.size(), 1, 10, 10));
		for (Product product : listProductSelected) {
			JPanel productDetail = new JPanel();
			productDetail.setLayout(new GridLayout(1, 2));
			JLabel imageP = new JLabel(new ImageIcon(product.getImg()), JLabel.CENTER);
			productDetail.add(imageP);
			JTextArea detailProduct = new JTextArea(
					product.getName() + "\n" + product.getPrice() + "\n" + product.getDescription());
			detailProduct.setEditable(false);
			detailProduct.setAlignmentX(JTextArea.CENTER_ALIGNMENT);

			detailProduct.setFont(new Font("Arial", Font.PLAIN, 20));
			detailProduct.setForeground(ConstantsUI.FOREGROUND_NAME_OWNER_SHOW_PRODUCT);
			productDetail.add(detailProduct);
			center.add(productDetail);
			revalidate();
		}
	}
}