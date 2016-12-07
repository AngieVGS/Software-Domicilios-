package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import controller.Actions;
import controller.Controller;
import model.entity.Order;
import model.entity.Product;

public class Diez extends JDialog {

	private static final long serialVersionUID = 1L;
	private RestaurantToolbar restaurantToolbar;
	private JPanel panelContainer;
	private Once once;
	private Controller controller;

	public Diez(Controller controller) {
		this.controller = controller;
		setTitle("Fast & Luscious");
		setIconImage(new ImageIcon("src/image/logoIcon.png").getImage());
		setSize(ConstantsUI.SIZE_WINDOW);
		getContentPane().setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		setLayout(new BorderLayout());
		setUndecorated(true);

		restaurantToolbar = new RestaurantToolbar(controller);
		add(restaurantToolbar, BorderLayout.NORTH);

		panelContainer = new JPanel();
		panelContainer.setLayout(new GridLayout(0, 2));
		panelContainer.setBackground(Color.WHITE);
		panelContainer.setAlignmentX(CENTER_ALIGNMENT);

		JScrollPane scrollProducts = new JScrollPane(panelContainer);
		scrollProducts.setBackground(Color.WHITE);
		add(scrollProducts, BorderLayout.CENTER);

		JButton createPro = new JButton("Add a new product");
		createPro.addActionListener(controller);
		createPro.setActionCommand(Actions.CREATE_PRODUCT_NEW.toString());
		createPro.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		createPro.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		createPro.setFocusable(false);
		createPro.setIcon(new ImageIcon(new ImageIcon("src/image/Buttons/678092-sign-add-128.png").getImage().getScaledInstance(30, 26, 100)));
		add(createPro, BorderLayout.PAGE_END);
	}

	public void addPanelsToDialogForProducts(ArrayList<Product> products) {
		panelContainer.removeAll();
			for (Product product : products) {
				panelContainer.add(new PanelAddProducts(product, controller));
				panelContainer.updateUI();
		}
	}
	// Este metodo es para agregar los paneles para ordenes que tiene el DUEÑO
	public void addPanelsToDialogForOrders(ArrayList<Product> productList) {
		panelContainer.removeAll();
		for (Product product : productList) {
			once = new Once(controller, product);
			panelContainer.add(once);
		}
	}

	public String getWordOnSpace() {
		return restaurantToolbar.getWordOnSpace();
	}
	
	public void clear(){
		restaurantToolbar.clear();
	}
}