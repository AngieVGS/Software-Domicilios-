package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import model.entity.Product;

public class Once extends JDialog{
	private static final long serialVersionUID = 1L;
	private RestaurantToolbar restaurantToolbar;
	private JPanel panelCenter;
	private JPanel panelProducts;

	public Once(Controller controller){
		setSize(410, 720);
		setLayout(new BorderLayout());

		restaurantToolbar = new RestaurantToolbar(controller);
		add(restaurantToolbar, BorderLayout.NORTH);

		panelCenter = new JPanel();

		JScrollPane scPrincipal = new JScrollPane(panelCenter);
		add(scPrincipal, BorderLayout.CENTER);

	}
	
	//en este metodo agrego los productos al panel
	public void addProductsToPanel(ArrayList<Product> productList){
		for (Product product : productList) {
			panelProducts = new JPanel();
		}
	}
	

}
