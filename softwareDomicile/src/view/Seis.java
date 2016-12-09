package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.Controller;
import model.entity.Owner;
import model.entity.Product;

public class Seis extends JDialog {

	private static final long serialVersionUID = 1L;
	private SeisToolbar seisToolbar;
	private JPanel panelContainer;
	private Controller controller;

	public Seis(Controller controller) {
		this.controller = controller;
		setTitle("Fast & Luscious");
		setIconImage(new ImageIcon("src/image/logoIcon.png").getImage());
		setSize(ConstantsUI.SIZE_WINDOW);
		setUndecorated(true);
		setLayout(new BorderLayout());
		
		seisToolbar = new SeisToolbar(controller);
		add(seisToolbar, BorderLayout.NORTH);

		panelContainer = new JPanel(new GridLayout(0, 1));
		panelContainer.setAlignmentX(CENTER_ALIGNMENT);

		JScrollPane scrollProducts = new JScrollPane(panelContainer);
		scrollProducts.setBackground(Color.WHITE);
		add(scrollProducts, BorderLayout.CENTER);
	}

	public void addPanelsToDialogForProducts(ArrayList<Owner> owners) {
		panelContainer.removeAll();
		
		for (Owner owner : owners) {
			panelContainer.add(new PanelAddRestaurants(owner, controller));
			panelContainer.updateUI();
		}
	}
	public void fillPanelCenter(ArrayList<Product> listProductSelected) {
		panelContainer.setLayout(new GridLayout(listProductSelected.size(), 1, 10, 10));
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
			panelContainer.add(productDetail);
			revalidate();
		}
	}
	
	public String getWordOnSpace() {
		return seisToolbar.getWordOnSpace();
	}
	
	public void clear(){
		seisToolbar.clear();
	}
}