package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class DialogLogIn extends JDialog {

	private static final long serialVersionUID = 1L;
	private GridSystem gridSystem ;
	private JPanel principalPanel;
	private JButton buttonLogIn;
	private JButton buttonSignUp;

	public DialogLogIn() {
		setTitle("Fast & Luscious");
		setIconImage(new ImageIcon("src/image/logoIcon.png").getImage());
		setSize(410, 720);
		buttonLogIn = new JButton(new ImageIcon("src/image/Buttons/LoginButton.png"));
		buttonSignUp = new JButton(new ImageIcon("src/image/Buttons/SignInButton.png"));
		buttonSignUp.setBackground(null);
		buttonLogIn.setBackground(null);
		
		principalPanel = new JPanel();
		
		gridSystem = new GridSystem(principalPanel);
		principalPanel.setBackground(ConstantsUI.BACKGROUND_COLOR);
		gridSystem.addExternalBorder(0,0,0,0);
		
		principalPanel.add(new JLabel(new ImageIcon("src/image/logoMedium.png")), gridSystem.insertComponent(0, 0, 0, 10));
		setUndecorated(true);
		gridSystem.addExternalBorder(0,0,0,0);
		
		
		JPanel panelInformation  = new JPanel(new GridLayout(2, 1));
		JTextArea txUser = new JTextArea("USER");
		txUser.setForeground(ConstantsUI.FOREGROUND_LOGIN);
		panelInformation.add(txUser);
		JPasswordField txPassword = new  JPasswordField("Password");
		txPassword.setForeground(ConstantsUI.FOREGROUND_LOGIN);
		panelInformation.add(txPassword);
		
		gridSystem.addExternalBorder(10,10,10,10);
		principalPanel.add(panelInformation, gridSystem.insertComponent(1, 1, 10, 0));
		
		JPanel panelButtons = new JPanel();
		panelButtons.add(Box.createRigidArea(new Dimension(51, 0)));
		panelButtons.add(buttonLogIn);
		panelButtons.add(Box.createRigidArea(new Dimension(51, 0)));
		panelButtons.add(buttonSignUp);
		panelButtons.setBackground(null);
		
		buttonLogIn.setBorder(null);;
		buttonSignUp.setBorder(null);;
		
		
		principalPanel.add(Box.createRigidArea(new Dimension(5, 290)));
		principalPanel.add(panelButtons, gridSystem.insertComponent(3, 0, 12, 10));
		
		
		add(principalPanel);
		setVisible(true);
	}
}