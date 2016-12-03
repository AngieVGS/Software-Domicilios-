package view;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.Actions;
import controller.Controller;
import model.entity.User;

public class MainWindow extends JFrame {
	private JPanel principalPanel;
	private GridSystem gridSystem ;
	private static final long serialVersionUID = 1L;
	private JButton buttonLetsDoIt;
	private JButton buttonSignIn;
	
	public MainWindow( Controller controller) {
		setTitle("Fast & Luscious");
		setIconImage(new ImageIcon("src/image/logoIcon.png").getImage());
		setSize(ConstantsUI.SIZE_WINDOW);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		buttonLetsDoIt = new JButton(new ImageIcon("src/image/Buttons/LetsDoItButton.png"));
		buttonSignIn = new JButton(new ImageIcon("src/image/Buttons/SignInButton.png"));
		buttonSignIn.setBackground(null);
		buttonLetsDoIt.setBackground(null);
		principalPanel = new JPanel();
		gridSystem = new GridSystem(principalPanel);
		principalPanel.setBackground(ConstantsUI.BACKGROUND_COLOR);
		JLabel title = new JLabel(new ImageIcon("src/image/wallpaper.png"));
		gridSystem.addExternalBorder(0,0,0,0);
		principalPanel.add(new JLabel(new ImageIcon("src/image/logoMedium.png")), gridSystem.insertComponent(0, 0, 1, 1));
		setUndecorated(true);
		gridSystem.addExternalBorder(0,0,0,0);
		principalPanel.add(title, gridSystem.insertComponent(0, 1, 11, 1));
		
		buttonLetsDoIt.setActionCommand(Actions.LETS_DO_IT.toString());
		buttonLetsDoIt.addActionListener(controller);
		
		buttonSignIn.setActionCommand(Actions.SIGN_IN.toString());
		buttonSignIn.addActionListener(controller);
		
		JPanel panelButtons = new JPanel();
		panelButtons.add(Box.createRigidArea(new Dimension(10, 200)));
		panelButtons.add(buttonLetsDoIt);
		panelButtons.add(Box.createRigidArea(new Dimension(51, 0)));
		panelButtons.add(buttonSignIn);
		panelButtons.setBackground(null);
		
		buttonLetsDoIt.setBorder(null);;
		buttonSignIn.setBorder(null);;
		
		principalPanel.add(new JLabel(new ImageIcon("src/image/Hamburguer.png")), gridSystem.insertComponent(1, 6, 12, 2));
		principalPanel.add(Box.createRigidArea(new Dimension(5, 290)));
		principalPanel.add(panelButtons, gridSystem.insertComponent(1, 0, 12, 1));
		
		add(principalPanel);
	}
}