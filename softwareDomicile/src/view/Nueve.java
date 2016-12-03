package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.dnd.DropTarget;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Actions;
import controller.Controller;
import exceptions.ExceptionIncorrectPassword;
import model.dao.OwnerManager;
import model.entity.Owner;

public class Nueve extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitle, lblImage;
	private JButton btnJoin;
	private JTextField txfRestaurantName;
	private JPasswordField txPassword;
	private JPasswordField txConfirmPasword;
	private JFormattedTextField ftxfContactNumber;
	private String imageDefault;

	public Nueve(Controller controller, MainWindow mainWindow) {
		super(mainWindow, true);
		setTitle("Fast & Luscious");
		setIconImage(new ImageIcon("src/image/logoIcon.png").getImage());
		setSize(ConstantsUI.SIZE_WINDOW);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		imageDefault = ConstantsUI.IMAGE_DEFAULT;
		setUndecorated(true);
		getContentPane().setBackground(ConstantsUI.BACKGROUND_COLOR);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		lblTitle = new JLabel(ConstantsUI.TITLE_CREATE_ACCOUNT);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font(ConstantsUI.FONT_ARIAL_NARROW, Font.BOLD, 40));
		gbc.insets = new Insets(15,40,15,40);
		gbc.weightx = 1.5;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;
		add(lblTitle, gbc);
		
		lblImage = new JLabel();
		gbc.gridy = 1;
		lblImage.setIcon(new ImageIcon(imageDefault));
		lblImage.setPreferredSize(new Dimension(128, 128));
		lblImage.setDropTarget(new DropTarget(lblImage, controller));
		add(lblImage, gbc);
		
		txfRestaurantName = new JTextField(ConstantsUI.RESTAURANT_NAME);
		txfRestaurantName.setBackground(ConstantsUI.BACKGROUND_COLOR_TEXTFILE);
		txfRestaurantName.setBorder(null);
		txfRestaurantName.setForeground(ConstantsUI.BACKGROUND_COLOR);
		txfRestaurantName.setFont(new Font(ConstantsUI.FONT_ARIAL, Font.PLAIN, ConstantsUI.SIZE_FONT));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(15,50,15,40);
		gbc.gridwidth = 2;
		gbc.ipady = 20;
		gbc.gridx = 0;
        gbc.gridy = 2;
        txfRestaurantName.addFocusListener(new FocusListener() {
        	public void focusGained(FocusEvent e) {
        		if (txfRestaurantName.getText().equals(ConstantsUI.RESTAURANT_NAME)) {
        			txfRestaurantName.setText("");
        		}
        	}
        	
        	public void focusLost(FocusEvent e) {
//        		txfRestaurantName.setText("Restaurant Name");
        	}
        });
		add(txfRestaurantName, gbc);
		
		gbc.insets = new Insets(15,-15,15,0);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
        gbc.gridy = 3;
		add(new JLabel(new ImageIcon(ConstantsUI.IMAGE_PASSWORD)), gbc);
		
		gbc.gridy = 4;
		add(new JLabel(new ImageIcon(ConstantsUI.IMAGE_PASSWORD)), gbc);
		
		gbc.gridy = 5;
		add(new JLabel(new ImageIcon(ConstantsUI.IMAGE_PHONE)), gbc);
		
		txPassword = new JPasswordField(ConstantsUI.PASSWORD);
		txPassword.setBackground(ConstantsUI.BACKGROUND_COLOR_TEXTFILE);
		txPassword.setBorder(null);
		txPassword.setForeground(ConstantsUI.BACKGROUND_COLOR);
		txPassword.setFont(new Font(ConstantsUI.FONT_ARIAL, Font.PLAIN, ConstantsUI.SIZE_FONT)); 
		gbc.insets = new Insets(15,-60,15,40);
		gbc.gridx = 1;
        gbc.gridy = 3;
        txPassword.addFocusListener(new FocusListener() {
        	public void focusGained(FocusEvent e) {
        		if (String.valueOf(txPassword.getPassword()).equals(ConstantsUI.PASSWORD)) {
        			txPassword.setText("");
				}
        	}
        	
        	public void focusLost(FocusEvent e) {
//        		txPassword.setText("Password");
        	}
        });
		add(txPassword, gbc);
		
		
		txConfirmPasword = new JPasswordField(ConstantsUI.PASSWORD);
		txConfirmPasword.setBackground(ConstantsUI.BACKGROUND_COLOR_TEXTFILE);
		txConfirmPasword.setBorder(null);
		txConfirmPasword.setForeground(ConstantsUI.BACKGROUND_COLOR);
		txConfirmPasword.setFont(new Font(ConstantsUI.FONT_ARIAL, Font.PLAIN, ConstantsUI.SIZE_FONT)); 
		gbc.gridy = 4;
		txConfirmPasword.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (String.valueOf(txConfirmPasword.getPassword()).equals(ConstantsUI.PASSWORD)) {
					txConfirmPasword.setText("");
					}
			}
			
			public void focusLost(FocusEvent e) {
//				txConfirmPasword.setText("Password");
			}
		});
		add(txConfirmPasword, gbc);
		
		ftxfContactNumber = new JFormattedTextField(ConstantsUI.getIntegerFormatter());
		ftxfContactNumber.setBackground(ConstantsUI.BACKGROUND_COLOR_TEXTFILE);
		ftxfContactNumber.setBorder(null);
		ftxfContactNumber.setForeground(ConstantsUI.BACKGROUND_COLOR);
		ftxfContactNumber.setFont(new Font(ConstantsUI.FONT_ARIAL, Font.PLAIN, ConstantsUI.SIZE_FONT)); 
		ftxfContactNumber.setToolTipText(ConstantsUI.PHONE_NUMBER);
		gbc.gridy = 5;
		add(ftxfContactNumber, gbc);
		
		btnJoin = new JButton(new ImageIcon(ConstantsUI.IMAGE_JOIN));
		btnJoin.setBorder(null);
		btnJoin.setContentAreaFilled(false);
		btnJoin.addActionListener(controller);
		btnJoin.setActionCommand(Actions.JOIN_ACCOUNT_OWNER.toString());
		gbc.ipady = 20;
		gbc.gridy = 6;
		add(btnJoin, gbc);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				clear();
			}
		});
		
		//setVisible(true);
	}
	
	public void addImage(String pathImg) {
		imageDefault = pathImg;
		Image img = new ImageIcon(imageDefault).getImage().getScaledInstance(128, 118, java.awt.Image.SCALE_AREA_AVERAGING);
		lblImage.setIcon(new ImageIcon(img));
	}
	
	public Owner createOwner() throws ExceptionIncorrectPassword {
		if (String.valueOf(txPassword.getPassword()).equals(String.valueOf(txConfirmPasword.getPassword()))) {
			return OwnerManager.createOwner(txfRestaurantName.getText(), String.valueOf(txPassword.getPassword()), imageDefault);
		}else{
			throw new ExceptionIncorrectPassword();
		}
	}
	
	public void validatePasswordField() {
		txPassword.setBackground(ConstantsUI.BACKGROUND_COLOR_INVALID_PASSWORD);
		txConfirmPasword.setBackground(ConstantsUI.BACKGROUND_COLOR_INVALID_PASSWORD);;
	}
	
	public void clear() {
		lblImage.setIcon(new ImageIcon(imageDefault));
		txfRestaurantName.setText(ConstantsUI.RESTAURANT_NAME);
		txPassword.setText(ConstantsUI.PASSWORD);
		txConfirmPasword.setText(ConstantsUI.PASSWORD);
		ftxfContactNumber.setText(ConstantsUI.PHONE_NUMBER);
		txPassword.setBorder(null);
		txConfirmPasword.setBorder(null);
	}
}
