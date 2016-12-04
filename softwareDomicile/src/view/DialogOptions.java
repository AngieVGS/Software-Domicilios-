package view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import controller.Actions;
import controller.Controller;

public class DialogOptions extends JDialog{

	private static final long serialVersionUID = 1L;
	
	public DialogOptions(Controller controller, MainWindow mainWindow) {
		super(mainWindow, true);
		setTitle("Fast & Luscious");
		setIconImage(new ImageIcon("src/image/logoIcon.png").getImage());
		setSize(205, 150);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		getContentPane().setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		setUndecorated(true);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(controller);
		btnBack.setActionCommand(Actions.BACK_OF_OPTIONS_DIALOG.toString());
		btnBack.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		btnBack.setAlignmentX(CENTER_ALIGNMENT);
		btnBack.setSize(getSize());
		btnBack.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		btnBack.setIcon(new ImageIcon(new ImageIcon("src/image/Buttons/back-alt-128.png").getImage().getScaledInstance(30, 26, 100)));
		btnBack.setFocusable(false);
		add(btnBack);
		
		JButton btnLogOut= new JButton("Log Out");
		btnLogOut.addActionListener(controller);
		btnLogOut.setActionCommand(Actions.BACK_VIEW_THREE.toString());
		btnLogOut.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		btnLogOut.setAlignmentX(CENTER_ALIGNMENT);
		btnLogOut.setSize(getSize());
		btnLogOut.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		btnLogOut.setIcon(new ImageIcon(new ImageIcon("src/image/Buttons/Home.png").getImage().getScaledInstance(30, 26, 100)));
		btnLogOut.setFocusable(false);
		add(btnLogOut);
		
		JButton btnAddNewProduct = new JButton("Add new product");
		btnAddNewProduct.addActionListener(controller);
		btnAddNewProduct.setActionCommand(Actions.CREATE_PRODUCT_NEW.toString());
		btnAddNewProduct.setBackground(ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT);
		btnAddNewProduct.setAlignmentX(CENTER_ALIGNMENT);
		btnAddNewProduct.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ConstantsUI.BACKGROUND_COLOR_TOOLBAR_RESTAURANT_BUTTONS));
		btnAddNewProduct.setFocusable(false);
		btnAddNewProduct.setIcon(new ImageIcon(new ImageIcon("src/image/Buttons/678092-sign-add-128.png").getImage().getScaledInstance(30, 26, 100)));
		add(btnAddNewProduct);
	}
}
