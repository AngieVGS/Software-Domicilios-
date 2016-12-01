package view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Actions;
import controller.Controller;
import model.entity.Owner;

public class PanelAddRestaurants extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public PanelAddRestaurants(Owner owner, Controller controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		
		JButton btnImageRestaurant = new JButton();
		btnImageRestaurant.setIcon(new ImageIcon(new ImageIcon(owner.getImg()).getImage().getScaledInstance(407, 150, 100)));
		btnImageRestaurant.setBackground(Color.WHITE);
		btnImageRestaurant.setName(String.valueOf(owner.getId()));
		btnImageRestaurant.addActionListener(controller);
		btnImageRestaurant.setBorder(null);
		btnImageRestaurant.setActionCommand(Actions.RESTAURANT.toString());
		add(btnImageRestaurant);
	}
}
