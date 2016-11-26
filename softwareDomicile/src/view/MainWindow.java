package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;
import model.dao.Manager;
import model.entity.Owner;
import model.entity.User;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainWindow(Manager manager, Controller controller) {
		setTitle("Nombre");
//		NO HE ENCONTRADO UN ICONO
//		setIconImage(new ImageIcon(getClass().getResource("rutaImagen")).getImage());
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
				
		setVisible(true);
	}
	
	public MainWindow(User user , Controller controller) {
	// TODO Auto-generated method stub
	}
	
	public MainWindow(Owner owner , Controller controller) {
		// TODO Auto-generated method stub
	}
}