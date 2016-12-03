package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.Controller;

public class RestaurantToolbar extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField tfSearchItem;

	public RestaurantToolbar(Controller controller){
		setLayout(new GridLayout(2, 1));
		setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		
		JButton btnOptions = new JButton();
		btnOptions.setIcon(new ImageIcon(new ImageIcon("src/image/Buttons/imageOptions.png").getImage().getScaledInstance(60, 60, 100)));
		btnOptions.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		btnOptions.setBorder(null);
		
		JButton btnSearch = new JButton();
		btnSearch.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		btnSearch.setIcon(new ImageIcon(new ImageIcon("src/image/Buttons/imageSearch.png").getImage().getScaledInstance(60, 60, 100)));
		btnSearch.setBorder(null);
		
		tfSearchItem = new JTextField(5);
		tfSearchItem.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		tfSearchItem.setBorder(null);
		tfSearchItem.addKeyListener(controller);
		
		JPanel panelTop = new JPanel();
		panelTop.setLayout(new BorderLayout());
		panelTop.add(btnSearch, BorderLayout.EAST);
		panelTop.add(tfSearchItem, BorderLayout.CENTER);
		panelTop.add(btnOptions, BorderLayout.WEST);
		add(panelTop);
		
		JButton btnOrders = new JButton("Orders");
		btnOrders.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		btnOrders.setBorder(null);
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		btnMenu.setBorder(null);
		
		JPanel panelDown = new JPanel();
		panelDown.setLayout(new GridLayout(1,2));
		panelDown.add(btnOrders);
		panelDown.add(btnMenu);
		add(panelDown);
	}
	
	public String getWordOnSpace(){
		return tfSearchItem.getText();
	}
}