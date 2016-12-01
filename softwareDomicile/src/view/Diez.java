package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import model.entity.Order;
import model.entity.Product;

public class Diez extends JDialog{

	private static final long serialVersionUID = 1L;
	private RestaurantToolbar restaurantToolbar;
	private JPanel panelContainer;

	public Diez(Controller controller){
		setSize(410, 720);
		setLayout(new BorderLayout());
		restaurantToolbar = new RestaurantToolbar(controller);
		add(restaurantToolbar, BorderLayout.NORTH);

		panelContainer = new JPanel( new GridLayout(0, 1));
		panelContainer.setAlignmentX(CENTER_ALIGNMENT);

		JScrollPane scrollProducts = new JScrollPane(panelContainer);
		scrollProducts.setBackground(Color.WHITE);
		add(scrollProducts, BorderLayout.CENTER);
	}

	public void addPanelsToDialogForProducts(ArrayList<Product> products){
		panelContainer.removeAll();
		for (Product product : products) {
		//	panelContainer.add(new PanelAddProducts(product));
			panelContainer.updateUI();
		}
	}
	
	//Este metodo es para agregar los paneles para ordenes que tiene el DUEÑO
	public void addPanelsToDialogForOrders(ArrayList<Order> orders){
		panelContainer.removeAll();
		for (Order order : orders) {
		}
	}
	
	public String getWordOnSpace(){
		return restaurantToolbar.getWordOnSpace();
	}
}
