package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.entity.Order;
import model.entity.Product;

public class Diez extends JDialog{

	private static final long serialVersionUID = 1L;
	private RestaurantToolbar restaurantToolbar;
	private JPanel panelContainer;

	public Diez(){
		setSize(500, 500);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		restaurantToolbar = new RestaurantToolbar();
		add(restaurantToolbar, BorderLayout.NORTH);

		panelContainer = new JPanel( new GridLayout(0, 1));
		panelContainer.setAlignmentX(CENTER_ALIGNMENT);

		JScrollPane scrollProducts = new JScrollPane(panelContainer);
		add(scrollProducts, BorderLayout.CENTER);
	}

	public void addPanelsToDialogForProducts(ArrayList<Product> products){
		panelContainer.removeAll();
		for (Product product : products) {
		//	panelContainer.add(new PanelAddProducts(product));
			panelContainer.updateUI();
		}
	}
	
	//Este metodo es para agregar los paneles para ordenes que tiene el DUE�O
	public void addPanelsToDialogForOrders(ArrayList<Order> orders){
		panelContainer.removeAll();
		for (Order order : orders) {
		}
	}
}
