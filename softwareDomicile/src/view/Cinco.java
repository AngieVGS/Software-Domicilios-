package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.entity.*;
import controller.*;

public class Cinco extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel panelCenter;

	public Cinco() {
		setTitle("");
		setSize(800, 400);

		panelCenter = new JPanel();
		add(new JScrollPane(panelCenter), BorderLayout.CENTER);
		setVisible(true);
	}

	public void fillCenter(ArrayList<Product> listProductOfStore, Controller controller) {
		panelCenter.setLayout(new GridLayout((listProductOfStore.size() + 1) / 2, 2));
		for (Product product : listProductOfStore) {
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			JLabel image = new JLabel(new ImageIcon(""+product.getImg()));
			image.setHorizontalAlignment(JLabel.CENTER);
			panel.add(image, BorderLayout.CENTER);

			JPanel end = new JPanel();
			end.setLayout(new GridLayout(1, 2));
			JLabel price = new JLabel("" + product.getPrice());
			price.setHorizontalAlignment(JLabel.CENTER);
			end.add(price);

			JButton addProduct = new JButton("ADD");
			addProduct.setActionCommand(Actions.PRODUCT_ADD_MY_CAR.toString());
			addProduct.addActionListener(controller);
			addProduct.setHorizontalAlignment(JCheckBox.CENTER);
			addProduct.setName("" + product.getId());
			addProduct.setBackground(null);
			addProduct.setToolTipText("Add My Count");
			addProduct.setBorder(null);

			end.add(addProduct);
			panel.setBorder(BorderFactory.createSoftBevelBorder(JPanel.WIDTH, Color.BLUE, Color.yellow));
			panel.add(end, BorderLayout.PAGE_END);
			panelCenter.add(panel);
			revalidate();
		}
	}

	private JPanel header() {

		return null;
	}

}
