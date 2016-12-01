package view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAddRestaurants extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public PanelAddRestaurants() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		
		JLabel lblImageRestaurant = new JLabel();
		add(lblImageRestaurant);
	}
}
