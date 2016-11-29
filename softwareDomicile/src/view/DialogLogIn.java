package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class DialogLogIn extends JDialog {

	private static final String TEXT_PASSWORD_INIT = "Password";
	private static final String TEXT_USER_INIT = "USER";
	private static final long serialVersionUID = 1L;
	private GridSystem gridSystem ;
	private JPanel principalPanel;
	private JButton buttonLogIn;
	private JButton buttonSignUp;
	private JTextArea txUser;

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
		gridSystem.addExternalBorder(40,40,40,40);
		
		JLabel lbImage = new JLabel(new ImageIcon("src/image/logoMedium.png"));
		principalPanel.add(lbImage, gridSystem.insertComponent(1, 0, 70, 50));
		setUndecorated(true);		
		
		JPanel panelInformation  = new JPanel(new GridLayout(2, 1,0,5));
		panelInformation.setBackground(Color.decode("#D8D8D8"));
		txUser = new JTextArea(TEXT_USER_INIT);
		txUser.setForeground(ConstantsUI.FOREGROUND_LOGIN);
		txUser.setBackground(ConstantsUI.BACKGROUND_COLOR_TEXTFILE);
		txUser.setFont(new Font("Arial", Font.PLAIN, 15));
		txUser.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txUser.getText().equals("")){
					txUser.setText(TEXT_USER_INIT);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txUser.getText().equals(TEXT_USER_INIT)){
					txUser.setText("");
				}
			}
		});
		panelInformation.add(txUser);
		JPasswordField txPassword = new  JPasswordField(TEXT_PASSWORD_INIT);
		txPassword.setForeground(ConstantsUI.FOREGROUND_LOGIN);
		txPassword.setBorder(null);
		txPassword.setBackground(ConstantsUI.BACKGROUND_COLOR_TEXTFILE);
		txPassword.setFont(new Font("Arial", Font.PLAIN, 30));
		txPassword.addFocusListener(new FocusListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if(txPassword.getText().isEmpty()){
					txPassword.setText(TEXT_PASSWORD_INIT);
				}
				
			}
			
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if (txPassword.getText().equals(TEXT_PASSWORD_INIT)) {
					txPassword.setText("");
				}
			}
		});
		panelInformation.add(txPassword);
		
		gridSystem.addExternalBorder(50,50,50,50);
		principalPanel.add(panelInformation, gridSystem.insertComponent(2,0 , 0, 15));
		
		JPanel panelButtons = new JPanel();
		panelButtons.add(Box.createRigidArea(new Dimension(51, 0)));
		panelButtons.add(buttonLogIn);
		panelButtons.add(Box.createRigidArea(new Dimension(51, 0)));
		panelButtons.add(buttonSignUp);
		panelButtons.setBackground(null);
		
		buttonLogIn.setBorder(null);;
		buttonSignUp.setBorder(null);;
		
		
		principalPanel.add(Box.createRigidArea(new Dimension(5, 290)));
		principalPanel.add(panelButtons, gridSystem.insertComponent(3, 0, 12, 50));
		
		
		add(principalPanel);
		setVisible(true);
	}
}