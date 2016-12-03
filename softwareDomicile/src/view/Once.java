package view;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import controller.Controller;

public class Once extends JDialog{
	private static final long serialVersionUID = 1L;
	private RestaurantToolbar restaurantToolbar;
	private JPanel panelCenter;

	public Once(Controller controller){
		setTitle("Fast & Luscious");
		setIconImage(new ImageIcon("src/image/logoIcon.png").getImage());
		setSize(ConstantsUI.SIZE_WINDOW);
		setLayout(new BorderLayout());

		restaurantToolbar = new RestaurantToolbar(controller);
		add(restaurantToolbar, BorderLayout.NORTH);

		panelCenter = new JPanel();

		JScrollPane scPrincipal = new JScrollPane(panelCenter);
		add(scPrincipal, BorderLayout.CENTER);

	}
	
	//en este metodo agrego los productos al panel
//	public void addProductsToPanel(ArrayList<Product> productList){
//		for (Product product : productList) {
//			panelProducts = new JPanel();
//		}
//	}
}