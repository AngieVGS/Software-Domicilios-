package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Actions;
import controller.Controller;

public class SeisToolbar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField tfSearchItem;
	
	public SeisToolbar(Controller c) {
		setLayout(new GridLayout(2, 1));
		setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		
		JButton btnOptions = new JButton();
		btnOptions.setIcon(new ImageIcon(new ImageIcon("src/image/Buttons/Home.png").getImage().getScaledInstance(40, 40, 100)));
		btnOptions.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		btnOptions.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		btnOptions.setFocusable(false);
		btnOptions.addActionListener(c);
		btnOptions.setActionCommand(Actions.BACK_VIEW_THREE.toString());
		
		JButton btnSearch = new JButton();
		btnSearch.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		btnSearch.setIcon(new ImageIcon(new ImageIcon("src/image/Buttons/imageSearch.png").getImage().getScaledInstance(50, 50, 100)));
		btnSearch.setFocusable(false);
		btnSearch.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		btnSearch.addActionListener(c);
		btnSearch.setActionCommand(Actions.SEARCH_OWNER_BYWORD.toString());
		
		tfSearchItem = new JTextField(5);
		tfSearchItem.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		tfSearchItem.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		tfSearchItem.addKeyListener(c);
		
		JPanel panelTop = new JPanel();
		panelTop.setLayout(new BorderLayout());
		panelTop.add(btnSearch, BorderLayout.EAST);
		panelTop.add(tfSearchItem, BorderLayout.CENTER);
		panelTop.add(btnOptions, BorderLayout.WEST);
		add(panelTop);
		
		JButton lblHand = new JButton();
		lblHand.setIcon(new ImageIcon(new ImageIcon("src/image/buttons/hand button.png").getImage().getScaledInstance(60, 60, 100)));
		lblHand.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		lblHand.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		lblHand.addActionListener(c);
		lblHand.setActionCommand(Actions.GENERATE_SHOPPING_CAR.toString());
		lblHand.setForeground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		lblHand.setOpaque(true);
		
		JButton btnOrders = new JButton("Orders");
		btnOrders.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		btnOrders.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		btnOrders.setFocusable(false);
		
		JButton btnMenu = new JButton("Restaurants");
		btnMenu.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		btnMenu.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		btnMenu.setFocusable(false);
		
		JPanel panelDown = new JPanel();
		panelDown.setLayout(new GridLayout(1,2));
		panelDown.add(lblHand);
		panelDown.add(btnOrders);
		panelDown.add(btnMenu);
		add(panelDown);
	}
	
	public String getWordOnSpace(){
		return tfSearchItem.getText();
	}
	
	public void clear(){
		tfSearchItem.setText("");
	}
}	