package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.entity.AssignProductToOwner;

public class PanelSiete extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelshowProducts;
	private JLabel lbTotalChange;
	
	public PanelSiete() {
	setLayout(new BorderLayout());
	

	
	panelshowProducts = new JPanel();
	JScrollPane pane = new JScrollPane(panelshowProducts);
	add(pane, BorderLayout.CENTER);
	
	JPanel total  = new JPanel();
	JLabel lbTotal = new JLabel("Total:");
	lbTotal.setForeground(Color.decode("#BDBDBD"));
	lbTotal.setFont(new Font("Arial Narrow", Font.BOLD, 40));
	total.add(lbTotal);
	
	lbTotalChange = new JLabel("$0");
	lbTotalChange.setForeground(Color.decode("#FF0000"));
	lbTotalChange.setFont(new Font("Arial Narrow", Font.BOLD, 40));
	total.add(lbTotalChange);
	
	add(total,BorderLayout.LINE_END);
	
	}
	
	public void showProducts(ArrayList<AssignProductToOwner> assignProductToOwners) {
		for (AssignProductToOwner assignProductToOwner : assignProductToOwners) {
			panelshowProducts.add(new SieteShowProduct(assignProductToOwner));
			repaint();
		}
	}
	
	public void showTotal(double total) {
		lbTotalChange.setText("$"+ total);
	}
}