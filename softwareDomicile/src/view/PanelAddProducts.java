package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.entity.Product;

public class PanelAddProducts extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public PanelAddProducts(Product product) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		
		JLabel lblImageProduct = new JLabel();
		lblImageProduct.setIcon(new ImageIcon(product.getImg()));
		add(lblImageProduct);
		
		JLabel lblPrice = new JLabel("$"+product.getPrice());
		add(lblPrice);
		
		JLabel lblName = new JLabel(product.getName());
		add(lblName);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setToolTipText("Reserve element");
		btnEdit.setName(String.valueOf(product.getId()));
		add(btnEdit);
	}
}