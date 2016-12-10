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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.ColorUIResource;

import controller.Actions;
import controller.Controller;
import model.entity.AssignOrderToUser;
import model.entity.Owner;
import model.entity.Product;

public class gif extends JFrame {


    private ImageIcon loading;

	public gif(Controller controller) {
	    loading = new ImageIcon("src/image/gif.gif");
	    add(new JLabel(loading, JLabel.NORTH_EAST));
	    setBackground(Color.decode("#fbfbf6"));
	    getContentPane().setBackground(Color.WHITE);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(ConstantsUI.SIZE_WINDOW);
	    setUndecorated(true);
		
	}

	public void showGif() {
		
		setVisible(true);
		try { 
	    	Thread.sleep(3000); 
	    	 setVisible(false);
	    	} catch (Exception ignored) {} 
		
	}

	
}