package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import model.entity.*;
import controller.*;

public class Cinco extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel panelCenter;
	private JToolBar toolbar;
	private JButton generateOrder;
	private JLabel priceTotal;
	private double pricet=0;

	public Cinco(Controller controller) {
		setTitle("");
		setSize(ConstantsUI.SIZE_WINDOW);

		JPanel start = new JPanel();
		start.setLayout(new BorderLayout());
		toolbar = new JToolBar();
		toolbar.setFloatable(false);
		toolbar.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		JButton back = new JButton("name restaurant");
		back.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		back.setBorder(null);
		back.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		back.setForeground(Color.white);
		toolbar.add(back);
		start.add(toolbar, BorderLayout.PAGE_START);
		JPanel count = new JPanel();
		count.setLayout(new GridLayout(1, 2));
		count.setBackground(ConstantsUI.BACKGROUND_COLOR_BUTTON_GENERATE_ORDER);
		
		generateOrder = new JButton("generate");
		generateOrder.setBorder(null);
		generateOrder.setBackground(ConstantsUI.BACKGROUND_COLOR_BUTTON_GENERATE_ORDER);
		generateOrder.setForeground(Color.WHITE);
		generateOrder.setFont(new Font("Arial", Font.PLAIN, 20));
		generateOrder.addActionListener(controller);
		generateOrder.setActionCommand(Actions.GENERATE_ORDER.toString());
		count.add(generateOrder);
		
		priceTotal = new JLabel("total: $ 0.0",JLabel.RIGHT);
		priceTotal.setBackground(ConstantsUI.BACKGROUND_COLOR_BUTTON_GENERATE_ORDER);
		priceTotal.setForeground(Color.WHITE);
		priceTotal.setFont(new Font("Arial", Font.PLAIN, 20));
		count.add(priceTotal);
		start.add(count, BorderLayout.CENTER);
		add(start, BorderLayout.PAGE_START);
		panelCenter = new JPanel();
		panelCenter.setBackground(Color.decode("#4b4b4b"));
		add(new JScrollPane(panelCenter), BorderLayout.CENTER);
	}

	public void fillCenter(ArrayList<Product> listProductOfStore, Controller controller) {
		panelCenter.removeAll();
		panelCenter.setLayout(new GridLayout((listProductOfStore.size() + 1) / 2, 2, 10,10));
		for (Product product : listProductOfStore) {
			header(controller, product);
			revalidate();
		}
	}

	private JPanel header(Controller controller, Product product) {

		JPanel panel = new JPanel();
		panel.setBackground(ConstantsUI.BACKGROUND_COLOR_SHOW_PRODUCT_LIST);
		panel.setLayout(new BorderLayout());
		
		JButton image = new JButton();
		image.setIcon(new ImageIcon(new ImageIcon("" + product.getImg()).getImage().getScaledInstance(180, 230, 100)));
		
		image.setBackground(ConstantsUI.BACKGROUND_COLOR_SHOW_PRODUCT_LIST);
		image.setHorizontalAlignment(JButton.CENTER);
		image.setActionCommand(Actions.PRODUCT_ADD_MY_CAR.toString());
		image.addActionListener(controller);
		image.setName("" + product.getId());
		image.setToolTipText("Add My Count");
		image.setBorder(null);
		panel.add(image, BorderLayout.CENTER);
		JPanel end = new JPanel();
		end.setBackground(ConstantsUI.BACKGROUND_COLOR_SHOW_PRODUCT_LIST);
		JLabel nameProduct = new JLabel( product.getName(), JLabel.CENTER);
		panel.add(nameProduct, BorderLayout.PAGE_START);
		
		JLabel quantity = new JLabel(" ");

		JLabel price = new JLabel("" + product.getPrice());
		price.setHorizontalAlignment(JLabel.CENTER);
		
		end.add(price, BorderLayout.PAGE_END);
		panel.add(end, BorderLayout.PAGE_END);
		panelCenter.add(panel);
		return panel;
	}

	public void counttotal(double price) {
		pricet+=price;
		priceTotal.setText("$"+pricet);
	}

}