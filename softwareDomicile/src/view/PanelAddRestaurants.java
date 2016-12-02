package view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.entity.Owner;

public class PanelAddRestaurants extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public PanelAddRestaurants(Owner owner) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		
		JButton btnImageRestaurant = new JButton();
		btnImageRestaurant.setIcon(new ImageIcon(new ImageIcon(owner.getImg()).getImage().getScaledInstance(357, 150, 100)));
		btnImageRestaurant.setBackground(Color.WHITE);
		add(btnImageRestaurant);
	}
}
