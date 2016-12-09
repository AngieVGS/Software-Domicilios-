package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.Actions;
import controller.Controller;
import model.entity.Product;

public class PanelAddProducts extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelAddProducts(Product product, Controller controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.ORANGE));

		JLabel lblName = new JLabel(product.getName());
		lblName.setAlignmentX(CENTER_ALIGNMENT);
		add(lblName);

		JLabel lblImageProduct = new JLabel();
		lblImageProduct.setIcon(new ImageIcon(product.getImg()));
		lblImageProduct.setAlignmentX(CENTER_ALIGNMENT);
		add(lblImageProduct);

		JLabel lblPrice = new JLabel("$" + product.getPrice());
		lblPrice.setAlignmentX(CENTER_ALIGNMENT);
		add(lblPrice);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(controller);
		btnEdit.setActionCommand(Actions.EDIT_PRODUCT_BYOWNER.toString());
		btnEdit.setBackground(Color.decode("#575757"));
		btnEdit.setAlignmentX(CENTER_ALIGNMENT);
		btnEdit.setToolTipText("Reserve element");
		btnEdit.setName(String.valueOf(product.getId()));
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFocusable(false);
		add(btnEdit);
	}
}