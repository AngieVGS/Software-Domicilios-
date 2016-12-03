package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controller.Actions;
import controller.Controller;
import model.dao.ProductManager;
import model.entity.Product;

public class Doce extends JDialog {

	private static final long serialVersionUID = 1L;

	private String imageDefault;
	private JLabel lblTitle, lblImage;
	private JTextField txtNameProduct;
	private JTextArea txtDescription;
	private JFormattedTextField ftxtPrice;
	private JButton btnCreateProduct;

	public Doce(Controller controller, MainWindow mainWindow) {
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

		lblTitle = new JLabel("CREATE PRODUCT");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial Narrow", Font.BOLD, 40));
		gbc.insets = new Insets(15, 40, 15, 40);
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
		lblImage.setDropTarget(new DropTarget() {
			private static final long serialVersionUID = 1L;

			public synchronized void drop(DropTargetDropEvent dtde) {
				dtde.acceptDrop(DnDConstants.ACTION_COPY);
				try {
					addImage(dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor).toString()
							.replace("[", "").replace("]", "").replace("\\", "/"));
					Toolkit.getDefaultToolkit().beep();
				} catch (UnsupportedFlavorException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		add(lblImage, gbc);

		txtNameProduct = new JTextField(ConstantsUI.PRODUCT_NAME);
		txtNameProduct.setBackground(ConstantsUI.BACKGROUND_COLOR_TEXTFILE);
		txtNameProduct.setBorder(null);
		txtNameProduct.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (txtNameProduct.getText().equals(ConstantsUI.PRODUCT_NAME)) {
					txtNameProduct.setText("");
				}
			}

			public void focusLost(FocusEvent e) {
				// txPassword.setText("Password");
			}
		});
		txtNameProduct.setForeground(ConstantsUI.BACKGROUND_COLOR);
		txtNameProduct.setFont(new Font("Arial", Font.PLAIN, 15));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 20;
		gbc.gridy = 2;
		add(txtNameProduct, gbc);

		txtDescription = new JTextArea(ConstantsUI.DESCRIPTION_PRODUCT);
		txtDescription.setLineWrap(true);// corta la linea
		txtDescription.setRows(10);// la canttidad de columnas que muestra
		txtDescription.setBackground(ConstantsUI.BACKGROUND_COLOR_TEXTFILE);
		txtDescription.setBorder(null);
		txtDescription.setForeground(ConstantsUI.BACKGROUND_COLOR);
		txtDescription.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (txtDescription.getText().equals(ConstantsUI.DESCRIPTION_PRODUCT)) {
					txtDescription.setText("");
				}
			}

			public void focusLost(FocusEvent e) {
				// txPassword.setText("Password");
			}
		});
		txtDescription.setFont(new Font("Arial", Font.PLAIN, 15));
		JScrollPane jScrollPane = new JScrollPane(txtDescription);
		jScrollPane.setBorder(null);
		jScrollPane.setBackground(Color.WHITE);
		gbc.gridy = 3;
		add(jScrollPane, gbc);

		ftxtPrice = new JFormattedTextField(ConstantsUI.getIntegerFormatter());
		ftxtPrice.setValue(0);
		ftxtPrice.setBackground(ConstantsUI.BACKGROUND_COLOR_TEXTFILE);
		ftxtPrice.setBorder(null);
		ftxtPrice.setForeground(ConstantsUI.BACKGROUND_COLOR);
		ftxtPrice.setFont(new Font("Arial", Font.PLAIN, 15));
		gbc.gridy = 4;
		add(ftxtPrice, gbc);

		btnCreateProduct = new JButton(ConstantsUI.BUTTON_CREATE_PRODUCT);
		btnCreateProduct.setBorder(null);
		// btnCreateProduct.setContentAreaFilled(false);
		btnCreateProduct.setBackground(ConstantsUI.BACKGROUND_COLOR_BUTTON);
		btnCreateProduct.setForeground(Color.WHITE);
		btnCreateProduct.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 15));
		btnCreateProduct.addActionListener(controller);
		btnCreateProduct.setActionCommand(Actions.CREATE_PRODUCT.toString());
		gbc.insets = new Insets(15, 150, 15, 100);
		gbc.ipady = 15;
		gbc.gridy = 5;
		add(btnCreateProduct, gbc);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				clear();
			}
		});
	}

	public void addImage(String pathImg) {
		imageDefault = pathImg;
		Image img = new ImageIcon(imageDefault).getImage().getScaledInstance(128, 118,
				java.awt.Image.SCALE_AREA_AVERAGING);
		lblImage.setIcon(new ImageIcon(img));
	}

	public Product createProduct() {
		return ProductManager.createProduct(txtNameProduct.getText(), txtDescription.getText(),
				Double.parseDouble(ftxtPrice.getText()), null, imageDefault);
	}

	public void clear() {
		txtNameProduct.setText(ConstantsUI.PRODUCT_NAME);
		txtDescription.setText(ConstantsUI.DESCRIPTION_PRODUCT);
		ftxtPrice.setValue(0);
	}
}