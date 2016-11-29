package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class Class10 extends JFrame{
	private static final long serialVersionUID = 1L;
	private RestaurantToolbar restaurantToolbar;
	public Class10(){
		setSize(500, 500);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		restaurantToolbar = new RestaurantToolbar();
		add(restaurantToolbar, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
}
