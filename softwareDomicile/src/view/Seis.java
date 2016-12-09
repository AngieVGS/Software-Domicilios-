package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
			panelContainer.updateUI();
		}
	}

	public void fillPanelCenter(ArrayList<Product> listProductSelected, int total) {
		panelContainer.removeAll();
		panelContainer.setLayout(new BorderLayout());
		JPanel panelDiv = new JPanel();
		panelDiv.setLayout(new GridLayout(listProductSelected.size(), 1, 10, 10));
		for (Product product : listProductSelected) {
			JPanel productDetail = new JPanel();
			productDetail.setLayout(new GridLayout(1, 3));
			JLabel imageP = new JLabel(new ImageIcon(product.getImg()), JLabel.CENTER);
			productDetail.add(imageP);
			JTextArea detailProduct = new JTextArea(
					product.getName() + "\n" + product.getPrice() + "\n" + product.getDescription());
			detailProduct.setEditable(false);
			detailProduct.setAlignmentX(JTextArea.CENTER_ALIGNMENT);

			detailProduct.setFont(new Font("Arial", Font.PLAIN, 20));
			detailProduct.setForeground(ConstantsUI.FOREGROUND_NAME_OWNER_SHOW_PRODUCT);
			productDetail.add(detailProduct);
			JButton cancel = new JButton("cancel",new ImageIcon(
					new ImageIcon("").getImage().getScaledInstance(128, 118, java.awt.Image.SCALE_AREA_AVERAGING)));
			productDetail.add(cancel);
			panelDiv.add(productDetail);
			revalidate();
		}
		JPanel end = new JPanel();
		end.setLayout(new GridLayout(1, 2));
		JButton buy = new JButton("Buy");
		buy.setFont(new Font("Arial", Font.PLAIN, 20));
		buy.setForeground(ConstantsUI.FOREGROUND_NAME_OWNER_SHOW_PRODUCT);
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

	public void fillPnelCenterToOrders(ArrayList<AssignOrderToUser> arrayList) {
		panelContainer.removeAll();
		if (arrayList != null) {
			panelContainer.setLayout(new BorderLayout());
			panelContainer.add(new JLabel(new ImageIcon("src/image/UserIcon.JPG"), JLabel.CENTER));
		}else {
//			for (AssignOrderToUser assignOrderToUser : arrayList) {
//				
//			}
		}
		revalidate();
	}
}