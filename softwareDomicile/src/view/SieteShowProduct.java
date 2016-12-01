package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import model.entity.AssignProductToOrder;
import model.entity.AssignProductToOwner;
import model.entity.Owner;
import model.entity.Product;
import model.entity.State;

public class SieteShowProduct extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridSystem gridSystem;
	private JCheckBox checkBox;
	private JLabel lbImage;
	
	public  SieteShowProduct(AssignProductToOwner product) {
		setLayout(new GridLayout(1, 3,10,10));
		setBackground(Color.WHITE);
		checkBox = new JCheckBox();
		checkBox.setOpaque(false);
		add(checkBox);
		
		lbImage = new JLabel(product.getProduct().getImg());
		add(lbImage);
		
		JPanel panelInfo = new JPanel(new GridLayout(3, 1));
		panelInfo.setOpaque(false);
		JLabel lbNameProduct = new JLabel(product.getProduct().getName());
		lbNameProduct.setFont(new Font("Arial", Font.PLAIN, 20));
		lbNameProduct.setForeground(ConstantsUI.FOREGROUND_NAME_PRODUCT_SHOW_PRODUCT);
		panelInfo.add(lbNameProduct);
		
		JLabel lbNameOwner = new JLabel(product.getOwner().getName());
		lbNameOwner.setFont(new Font("Arial", Font.PLAIN, 20));
		lbNameOwner.setForeground(ConstantsUI.FOREGROUND_NAME_OWNER_SHOW_PRODUCT);
		panelInfo.add(lbNameOwner);
		
		JLabel lbPriceProduct = new JLabel("$"+product.getProduct().getPrice());
		lbPriceProduct.setFont(new Font("Arial", Font.PLAIN, 20));
		lbPriceProduct.setForeground(ConstantsUI.FOREGROUND_PRICE_SHOW_PRODUCT);
		panelInfo.add(lbPriceProduct);
		
		add(panelInfo);
	
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new GridLayout(10, 1));
		JScrollPane jScrollPane = new JScrollPane(panel);
		for (int i = 0; i < 10; i++) {
			panel.add(new SieteShowProduct(new AssignProductToOwner(new Product("sdfghjklñ", "sdfghjkl", 124, State.RECEIVED, "src/image/Buttons/LetsDoItButton.png"), new Owner(01, "ya", "123"))));
		}
		frame.add(jScrollPane);
		frame.setVisible(true);
	}
}