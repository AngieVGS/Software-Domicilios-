package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Actions;
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
		btnOptions.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		btnOptions.addActionListener(controller);
		btnOptions.setActionCommand(Actions.SHOW_DIALOG_OPTIONS.toString());
		
		JButton btnSearch = new JButton();
		btnSearch.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		btnSearch.setIcon(new ImageIcon(new ImageIcon("src/image/Buttons/imageSearch.png").getImage().getScaledInstance(60, 60, 100)));
		btnSearch.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		
		tfSearchItem = new JTextField(5);
		tfSearchItem.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		tfSearchItem.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		tfSearchItem.addKeyListener(controller);
		
		JPanel panelTop = new JPanel();
		panelTop.setLayout(new BorderLayout());
		panelTop.add(btnSearch, BorderLayout.EAST);
		panelTop.add(tfSearchItem, BorderLayout.CENTER);
		panelTop.add(btnOptions, BorderLayout.WEST);
		add(panelTop);
		
		JButton btnOrders = new JButton("Orders");
		btnOrders.setFocusable(false);
		btnOrders.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		btnOrders.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		JButton btnMenu = new JButton("Menu");
		btnMenu.setFocusable(false);
		btnMenu.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		btnMenu.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		
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