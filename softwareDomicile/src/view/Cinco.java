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
	private JButton buttonBack;
	private JButton back;
	private JLabel priceTotal;
	private double pricet = 0;

	public Cinco(Controller controller) {
		setTitle("Fast & Luscious");
		setIconImage(new ImageIcon("src/image/logoIcon.png").getImage());
		setSize(ConstantsUI.SIZE_WINDOW);

		JPanel start = new JPanel();
		start.setLayout(new BorderLayout());
		toolbar = new JToolBar();
		toolbar.setFloatable(false);
		toolbar.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);

		back = new JButton();
		back.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		back.setBorder(null);
		back.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		back.setForeground(Color.white);
		toolbar.add(back);

		start.add(toolbar, BorderLayout.PAGE_START);
		JPanel count = new JPanel();
		count.setLayout(new GridLayout(1, 2));
		count.setBackground(ConstantsUI.BACKGROUND_COLOR_BUTTON_GENERATE_ORDER);

		buttonBack = new JButton(new ImageIcon("src/image/Buttons/back-alt-129.png"));
		
		buttonBack.setBorder(null);
		buttonBack.setBackground(ConstantsUI.BACKGROUND_COLOR_BUTTON_GENERATE_ORDER);
		buttonBack.setForeground(Color.WHITE);
		buttonBack.setFont(new Font("Arial", Font.PLAIN, 20));
		buttonBack.addActionListener(controller);
		buttonBack.setActionCommand(Actions.BACK_SIX.toString());
		count.add(buttonBack);

		priceTotal = new JLabel("total: $ 0.0", JLabel.RIGHT);
		priceTotal.setBackground(ConstantsUI.BACKGROUND_COLOR_BUTTON_GENERATE_ORDER);
		priceTotal.setForeground(Color.WHITE);
		priceTotal.setFont(new Font("Arial", Font.PLAIN, 20));
		count.add(priceTotal);
		start.add(count, BorderLayout.CENTER);
		add(start, BorderLayout.PAGE_START);
		panelCenter = new JPanel();
		panelCenter.setBackground(Color.WHITE);
		add(new JScrollPane(panelCenter), BorderLayout.CENTER);
	}

	public void fillCenter(ArrayList<Product> listProductOfStore, Controller controller) {
		panelCenter.removeAll();
		panelCenter.setLayout(new GridLayout((listProductOfStore.size() + 1) / 2, 2, 10, 10));
		for (Product product : listProductOfStore) {
			header(controller, product);
			revalidate();
		}
	}

	private JPanel header(Controller controller, Product product) {

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BorderLayout());

		JButton image = new JButton();
		image.setIcon(new ImageIcon(new ImageIcon("" + product.getImg()).getImage().getScaledInstance(180, 230, 100)));

		image.setBackground(Color.white);
		image.setHorizontalAlignment(JButton.CENTER);
		image.setActionCommand(Actions.PRODUCT_ADD_MY_CAR.toString());
		image.addActionListener(controller);
		image.setName("" + product.getId());
		image.setToolTipText("Add My Count");
		image.setBorder(null);
		panel.add(image, BorderLayout.CENTER);
		JPanel end = new JPanel();
		end.setBackground(Color.WHITE);
		JLabel nameProduct = new JLabel(product.getName(), JLabel.CENTER);
		panel.add(nameProduct, BorderLayout.PAGE_START);

		JLabel price = new JLabel("" + product.getPrice());
		price.setHorizontalAlignment(JLabel.CENTER);

		end.add(price, BorderLayout.PAGE_END);
		panel.add(end, BorderLayout.PAGE_END);
		panelCenter.add(panel);
		return panel;
	}

	public void counttotal(double price) {
		pricet += price;
		priceTotal.setText("$" + pricet);
	}

	public void changeNameOwner(String name) {
		back.setText(name);
	}
}