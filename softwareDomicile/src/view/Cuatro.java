package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.Actions;
import controller.Controller;

public class Cuatro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel principalPanel;
	private JButton userButton;
	private JButton businessOwnerButton;

	public Cuatro(Controller controller) {
		setTitle("Fast & Luscious");
		setIconImage(new ImageIcon("src/image/logoIcon.png").getImage());
		setSize(ConstantsUI.SIZE_WINDOW);
		principalPanel = new JPanel();
		principalPanel.setBackground(ConstantsUI.BACKGROUND_COLOR);
		setUndecorated(true);
		principalPanel.setLayout(new GridLayout(4, 1));
		setSize(410, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		userButton = new JButton(new ImageIcon("src/image/Buttons/userButton.png"));
		businessOwnerButton = new JButton(new ImageIcon("src/image/Buttons/businnesOwnerButton.png"));
		userButton.setBackground(null);
		userButton.setBorder(null);
		businessOwnerButton.setBorder(null);
		businessOwnerButton.setBackground(null);

		userButton.setActionCommand(Actions.USER.toString());
		userButton.addActionListener(controller);

		businessOwnerButton.setActionCommand(Actions.BUSINESS_OWNER.toString());
		businessOwnerButton.addActionListener(controller);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 1));
		buttonPanel.setBackground(null);
		buttonPanel.add(userButton);
		buttonPanel.add(businessOwnerButton);
		principalPanel.add(Box.createRigidArea(new Dimension(10, 100)));
		principalPanel.add(new JLabel(new ImageIcon("src/image/WhatAreYou.png")));
		principalPanel.add(buttonPanel);
		add(principalPanel);
	}
}