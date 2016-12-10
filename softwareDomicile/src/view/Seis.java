package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.Actions;
import controller.Controller;
import model.entity.AssignOrderToUser;
import model.entity.Owner;
import model.entity.Product;

public class Seis extends JDialog {

	private static final long serialVersionUID = 1L;
	private SeisToolbar seisToolbar;
	private JPanel panelContainer;
	private Controller controller;

	public Seis(Controller controller) {
		this.controller = controller;
		setTitle("Fast & Luscious");
		setIconImage(new ImageIcon("src/image/logoIcon.png").getImage());
		setSize(ConstantsUI.SIZE_WINDOW);
		setUndecorated(true);
		setLayout(new BorderLayout());

		seisToolbar = new SeisToolbar(controller);
		add(seisToolbar, BorderLayout.NORTH);

		panelContainer = new JPanel(new GridLayout(0, 1));
		panelContainer.setAlignmentX(CENTER_ALIGNMENT);

		add(new JScrollPane(panelContainer), BorderLayout.CENTER);
	}

	public void addPanelsToDialogForProducts(ArrayList<Owner> arrayList) {
		panelContainer.removeAll();
		panelContainer.setLayout(new GridLayout(arrayList.size(), 1));
		for (Owner owner : arrayList) {
			panelContainer.add(new PanelAddRestaurants(owner, controller));
			revalidate();
		}
	}

	public void fillPanelCenter(ArrayList<Product> listProductSelected, int total) {
		panelContainer.removeAll();
		panelContainer.setLayout(new BorderLayout());
		JPanel panelDiv = new JPanel();
		panelDiv.setBackground(Color.white);
		panelDiv.setLayout(new GridLayout(listProductSelected.size(), 1, 15, 25));
		for (Product product : listProductSelected) {
			JPanel productDetail = new JPanel();
			productDetail.setBackground(Color.white);
			productDetail.setLayout(new GridLayout(1, 3));
			productDetail.add(new JLabel(new ImageIcon(product.getImg()), JLabel.CENTER));

			JPanel detail = new JPanel();
			detail.setBorder(BorderFactory.createEtchedBorder());

			detail.setBackground(Color.white);
			detail.setLayout(new BorderLayout());
			JTextArea txtDeatail = new JTextArea(
					product.getName() + "\n" + product.getPrice() + "\n" + product.getDescription());
			txtDeatail.setEditable(false);
			txtDeatail.setFont(new Font("Arial", Font.PLAIN, 15));
			txtDeatail.setForeground(ConstantsUI.FOREGROUND_NAME_OWNER_SHOW_PRODUCT);
			productDetail.add(txtDeatail);
			JButton cancel = new JButton("cancel", new ImageIcon(
					new ImageIcon("").getImage().getScaledInstance(128, 118, java.awt.Image.SCALE_AREA_AVERAGING)));
			cancel.setBackground(ConstantsUI.BACKGROUND_COLOR_INVALID_PASSWORD);
			cancel.setActionCommand(Actions.CANCEL_PRODUCT_MY_SHOPPING.toString());
			cancel.addActionListener(controller);
			cancel.setName("" + product.getId());

			detail.add(txtDeatail, BorderLayout.CENTER);
			detail.add(cancel, BorderLayout.PAGE_END);
			panelDiv.add(productDetail);
			panelDiv.add(detail);
			revalidate();
		}
		JPanel end = new JPanel();
		end.setBorder(null);
		end.setLayout(new GridLayout(1, 2));
		JButton buy = new JButton("Buy");
		buy.setFont(new Font("Arial", Font.PLAIN, 20));
		buy.setBackground(ConstantsUI.BACKGROUND_COLOR_BUTTON_GENERATE_ORDER);
		buy.setForeground(ConstantsUI.FOREGROUND_NAME_OWNER_SHOW_PRODUCT);
		buy.addActionListener(controller);
		buy.setActionCommand(Actions.GENERATE_ORDER.toString());
		JLabel jlTotal = new JLabel("$ " + total);
		jlTotal.setFont(new Font("Arial", Font.PLAIN, 20));
		jlTotal.setForeground(ConstantsUI.FOREGROUND_NAME_OWNER_SHOW_PRODUCT);
		end.add(jlTotal);
		end.add(buy);
		panelContainer.add(new JScrollPane(panelDiv), BorderLayout.CENTER);
		panelContainer.add(end, BorderLayout.PAGE_END);
		revalidate();
	}

	public String getWordOnSpace() {
		return seisToolbar.getWordOnSpace();
	}

	public void clear() {
		seisToolbar.clear();
	}

	public void fillPanelStateToOrders(ArrayList<Product> productShopping) {
		panelContainer.removeAll();
		if (productShopping.size() == 0) {
			panelContainer.setLayout(new BorderLayout());
			panelContainer.add(new JLabel(new ImageIcon("src/image/UserIcon.JPG"), JLabel.CENTER));
		} else {
			panelContainer.setLayout(new GridLayout(productShopping.size(), 1, 15, 25));
			for (Product product : productShopping) {
				JPanel pnlProduct = new JPanel();
				pnlProduct.setBackground(Color.white);
				pnlProduct.setLayout(new GridLayout(1, 2));
				pnlProduct.add(new JLabel(new ImageIcon(product.getImg()), JLabel.CENTER));
				pnlProduct.add(new JLabel("" + product.getState(), JLabel.CENTER));
				panelContainer.add(pnlProduct);
				revalidate();
			}
		}
	}
}