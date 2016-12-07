package view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Actions;
import controller.Controller;
import model.entity.Order;

public class Once extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel lbInformation;
	private JLabel lbStatus;
	private JButton btnStatusChange;
	private JButton btnCancelOrder;

	public Once(Controller controller, Order order){
		setSize(500,500);
		setLayout(new GridLayout(1, 4));

		lbInformation = new JLabel();
		lbInformation.setText("information");
//		order.getDirection()
		add(lbInformation);
		
		lbStatus = new JLabel();
		lbStatus.setIcon(new ImageIcon(""));
		lbStatus.setText("to send");
//		order.getState().toString()
		add(lbStatus);
		
		btnStatusChange = new JButton();
		btnStatusChange.setIcon(new ImageIcon("src/image.Buttons/lbStatus.png"));
		btnStatusChange.setBorder(null);
		btnStatusChange.setActionCommand(Actions.CHANGE_STATUS.toString());
		btnStatusChange.addActionListener(controller);
		add(btnStatusChange);
		
		btnCancelOrder = new JButton();
		btnCancelOrder.setIcon(new ImageIcon("src/image.Buttons/exit.png"));
		btnCancelOrder.addActionListener(controller);
		btnCancelOrder.setActionCommand(Actions.CANCEL_ORDER.toString());
		add(btnCancelOrder);

		JScrollPane scPrincipal = new JScrollPane();
		add(scPrincipal);

	}
	
	@SuppressWarnings("static-access")
	public void changeStatus(Order order){
		if(lbStatus.getText().equals("TO_SEND")){
			lbStatus.setText(order.getState().SEND.toString());
		}else if(lbStatus.getText().equals("SEND")){
			lbStatus.setText(order.getState().RECEIVED.toString());
		}else{
			lbStatus.setText(order.getState().TO_SEND.toString());
		}
	}
}
