package view;

import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.Actions;
import controller.Controller;
import exceptions.ExceptionIncorrectPassword;
import model.dao.UserManager;
import model.entity.User;

public class Dos extends JDialog {

	private static final long serialVersionUID = 1L;

	private JLabel lblTitle;
	private JButton btnJoin;
	private JTextField txfUserName;
	private JPasswordField txPassword;
	private JPasswordField txConfirmPasword;
	private JFormattedTextField ftxfContactNumber;

	public Dos(Controller controller, MainWindow mainWindow) {
		super(mainWindow, true);
		setTitle("Fast & Luscious");
		setIconImage(new ImageIcon("src/image/logoIcon.png").getImage());
		setSize(ConstantsUI.SIZE_WINDOW);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		setUndecorated(true);
		getContentPane().setBackground(ConstantsUI.BACKGROUND_COLOR);

		GridBagConstraints gbc = new GridBagConstraints();

		lblTitle = new JLabel(ConstantsUI.TITLE_CREATE_ACCOUNT);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font(ConstantsUI.FONT_ARIAL_NARROW, Font.BOLD, 40));
		gbc.insets = new Insets(15, 40, 15, 40);
		gbc.weightx = 1.5;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.CENTER;
		add(lblTitle, gbc);

		gbc.gridy = 1;
		add(new JLabel(), gbc);

		gbc.insets = new Insets(15, -15, 15, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel(new ImageIcon(ConstantsUI.IMAGE_USER)), gbc);

		gbc.gridy = 3;
		add(new JLabel(new ImageIcon(ConstantsUI.IMAGE_PASSWORD)), gbc);

		gbc.gridy = 4;
		add(new JLabel(new ImageIcon(ConstantsUI.IMAGE_PASSWORD)), gbc);

		gbc.gridy = 5;
		add(new JLabel(new ImageIcon(ConstantsUI.IMAGE_PHONE)), gbc);

		txfUserName = new JTextField(ConstantsUI.USER_NAME);
		txfUserName.setBackground(ConstantsUI.BACKGROUND_COLOR_TEXTFILE);
		txfUserName.setBorder(null);
		txfUserName.setForeground(ConstantsUI.BACKGROUND_COLOR);
		txfUserName.setFont(new Font(ConstantsUI.FONT_ARIAL, Font.PLAIN, ConstantsUI.SIZE_FONT));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(15, -60, 15, 40);
		gbc.ipady = 20;
		gbc.gridx = 1;
		gbc.gridy = 2;
		txfUserName.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txfUserName.getText().equals(txfUserName.getText())) {
					txfUserName.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		add(txfUserName, gbc);

		txPassword = new JPasswordField(ConstantsUI.PASSWORD);
		txPassword.setBackground(ConstantsUI.BACKGROUND_COLOR_TEXTFILE);
		txPassword.setBorder(null);
		txPassword.setForeground(ConstantsUI.BACKGROUND_COLOR);
		txPassword.setFont(new Font(ConstantsUI.FONT_ARIAL, Font.PLAIN, ConstantsUI.SIZE_FONT));
		gbc.gridx = 1;
		gbc.gridy = 3;
		txPassword.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(txPassword.getPassword()).equals(ConstantsUI.PASSWORD)) {
					txPassword.setText("");
				}
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
			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(txConfirmPasword.getPassword()).equals(ConstantsUI.PASSWORD)) {
					txConfirmPasword.setText("");
				}
			}
		});
		add(txConfirmPasword, gbc);

		try {
			MaskFormatter maskFormatter = new MaskFormatter("###-###-####");
			ftxfContactNumber = new JFormattedTextField(maskFormatter);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		btnJoin.setActionCommand(Actions.JOIN.toString());
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

	}

	public User createUser() throws ExceptionIncorrectPassword {
		if (String.valueOf(txPassword.getPassword()).equals(String.valueOf(txConfirmPasword.getPassword()))) {
			return UserManager.createUser(txfUserName.getText(), String.valueOf(txPassword.getPassword()), true);
		} else {
			throw new ExceptionIncorrectPassword();
		}
	}

	public void validatePasswordField() {
		txPassword.setBackground(ConstantsUI.BACKGROUND_COLOR_INVALID_PASSWORD);
		txConfirmPasword.setBackground(ConstantsUI.BACKGROUND_COLOR_INVALID_PASSWORD);
		;
	}

	public void clear() {
		txfUserName.setText(ConstantsUI.RESTAURANT_NAME);
		txPassword.setText(ConstantsUI.PASSWORD);
		txConfirmPasword.setText(ConstantsUI.PASSWORD);
		ftxfContactNumber.setText(ConstantsUI.PHONE_NUMBER);
		;
	}
}