package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.entity.Owner;

public class Seis extends JDialog {

	private static final long serialVersionUID = 1L;
	private SeisToolbar seisToolbar;
	private JPanel panelContainer;
	
	public Seis() {
		setSize(410, 720);
		setLayout(new BorderLayout());
		seisToolbar = new SeisToolbar();
		add(seisToolbar, BorderLayout.NORTH);

		panelContainer = new JPanel( new GridLayout(0, 1));
		panelContainer.setAlignmentX(CENTER_ALIGNMENT);

		JScrollPane scrollProducts = new JScrollPane(panelContainer);
		scrollProducts.setBackground(Color.WHITE);
		add(scrollProducts, BorderLayout.CENTER);
		
	}
	
	public void addPanelsToDialogForProducts(ArrayList<Owner> owners){
		panelContainer.removeAll();
		for (Owner owner : owners) {
			panelContainer.add(new PanelAddRestaurants(owner));
			panelContainer.updateUI();
		}
	}
}
