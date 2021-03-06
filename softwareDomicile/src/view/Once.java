package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.Actions;
import controller.Controller;
import model.entity.Product;

public class Once extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel lbInformation;
	private JLabel lbStatus;
	private JButton btnStatusChange;
	private JButton btnCancelOrder;

	public Once(Controller controller, Product product){
		setSize(500,500);
		setBorder(new LineBorder(ConstantsUI.FOREGROUND_NAME_PRODUCT_SHOW_PRODUCT));
		setLayout(new GridLayout(1, 4));
		
		lbInformation = new JLabel();
		lbInformation.setText(product.getName() + "<html><body><br>" + product.getDescription() + "</body></html>");
		add(lbInformation);

		lbStatus = new JLabel();
		lbStatus.setText(product.getState().toString());
		lbStatus.setFont(new Font("Arial", Font.BOLD, 15));
		add(lbStatus);

		btnStatusChange = new JButton();
		btnStatusChange.setIcon(reSize(new ImageIcon("src/image.Buttons/lbStatus.png")));
		btnStatusChange.setActionCommand(Actions.CHANGE_STATUS.toString());
		btnStatusChange.addActionListener(controller);
		btnStatusChange.setToolTipText("Change status of product");
		add(btnStatusChange);

		btnCancelOrder = new JButton();
		btnCancelOrder.setIcon(reSize(new ImageIcon("src/image.Buttons/exit.png")));
		btnCancelOrder.addActionListener(controller);
		btnCancelOrder.setActionCommand(Actions.CANCEL_ORDER.toString());
		btnCancelOrder.setToolTipText("Cancel product");
		add(btnCancelOrder);
	}

	@SuppressWarnings("static-access")
	public void changeStatus(Product product, String id){
		if(this.getName().equals(id)){
			if(lbStatus.getText().equals("TO_SEND")){
				lbStatus.setText(product.getState().SEND.toString());
			}else if(lbStatus.getText().equals("SEND")){
				lbStatus.setText(product.getState().RECEIVED.toString());
			}else{
				lbStatus.setText(product.getState().TO_SEND.toString());
			}
		}
	}
	public Icon reSize(ImageIcon imagen){
		Image conversion = imagen.getImage();
		Image tamanio = conversion.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon result = new ImageIcon(tamanio);
		return result;
	}
}