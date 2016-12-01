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
import javax.swing.JToolBar;
import javax.swing.Painter;
import javax.swing.SpringLayout.Constraints;

import model.entity.*;
import controller.*;

public class Cinco extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel panelCenter;
	private JToolBar toolbar;
	private JButton generateOrder;
	private JLabel priceTotal;

	public Cinco() {
		setTitle("");
		setSize(800, 400);
		JPanel start = new JPanel();
		start.setLayout(new BorderLayout());
		toolbar = new JToolBar();
		toolbar.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		JButton back = new JButton("name restaurant");
		toolbar.add(back);
		start.add(toolbar, BorderLayout.PAGE_START);
		JPanel count = new JPanel();
		count.setLayout(new GridLayout(1, 2));
		count.setBackground(Color.BLUE);
		generateOrder = new JButton("generate");
		priceTotal = new JLabel("total");
		count.add(generateOrder);
		count.add(priceTotal);
		start.add(count, BorderLayout.CENTER);
		add(start, BorderLayout.PAGE_START);
		panelCenter = new JPanel();
		add(new JScrollPane(panelCenter), BorderLayout.CENTER);
	}

	public void fillCenter(ArrayList<Product> listProductOfStore, Controller controller) {
		panelCenter.setLayout(new GridLayout((listProductOfStore.size() + 1) / 2, 2));
		for (Product product : listProductOfStore) {
			header(controller, product);
			revalidate();
		}
	}

	private JPanel header(Controller controller, Product product) {

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JButton image = new JButton(new ImageIcon("" + product.getImg()));
		image.setHorizontalAlignment(JButton.CENTER);
		image.setActionCommand(Actions.PRODUCT_ADD_MY_CAR.toString());
		image.addActionListener(controller);
		image.setName("" + product.getId());
		image.setBackground(Color.WHITE);
		image.setToolTipText("Add My Count");
		image.setBorder(null);
		panel.add(image, BorderLayout.CENTER);
		JPanel end = new JPanel();

		JLabel quantity = new JLabel("");

		JLabel price = new JLabel("" + product.getPrice());
		price.setHorizontalAlignment(JLabel.CENTER);
		end.add(price, BorderLayout.PAGE_END);
		panel.add(end, BorderLayout.PAGE_END);
		panelCenter.add(panel);
		return panel;
	}

}