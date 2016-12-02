package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import model.entity.Owner;

public class Seis extends JDialog {

	private static final long serialVersionUID = 1L;
	private SeisToolbar seisToolbar;
	private JPanel panelContainer;
	
	public Seis() {
		setSize(410, 720);
		setUndecorated(true);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		seisToolbar = new SeisToolbar();
		add(seisToolbar);

		panelContainer = new JPanel(new GridLayout(0, 1));
		panelContainer.setAlignmentX(CENTER_ALIGNMENT);

		JScrollPane scrollProducts = new JScrollPane(panelContainer);
		scrollProducts.setBackground(Color.WHITE);
		add(scrollProducts);
	}
	
	public void addPanelsToDialogForProducts(ArrayList<Owner> owners, Controller controller){
		panelContainer.removeAll();
		for (Owner owner : owners) {
			panelContainer.add(new PanelAddRestaurants(owner, controller));
			panelContainer.updateUI();
		}
	}
}
