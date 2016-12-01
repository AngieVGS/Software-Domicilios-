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
			JButton image = new JButton(new ImageIcon("" + product.getImg()));
			image.setHorizontalAlignment(JLabel.CENTER);
			image.setActionCommand(Actions.PRODUCT_ADD_MY_CAR.toString());
			image.addActionListener(controller);
			image.setHorizontalAlignment(JCheckBox.CENTER);
			image.setName("" + product.getId());
			image.setBackground(null);
			image.setToolTipText("Add My Count");
			image.setBorder(null);
			panel.add(image, BorderLayout.CENTER);

			JLabel price = new JLabel("" + product.getPrice());
			price.setHorizontalAlignment(JLabel.CENTER);
			panel.add(price, BorderLayout.PAGE_END);
			panelCenter.add(panel);
			revalidate();
		}
	}
}