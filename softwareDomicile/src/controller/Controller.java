package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.dao.OwnerManager;
import model.dao.ProductManager;
import model.dao.UserManager;
import model.entity.Owner;
import model.entity.User;
import view.Nueve;
import view.MainWindow;

public class Controller implements ActionListener{
	
	private MainWindow mainWindow;
	private OwnerManager ownerManager;
	private ProductManager productManager;
	private UserManager userManager;
	private User user;
	private Owner owner;
	private Nueve dialogAddOwner;
	
	public Controller() {

		mainWindow = new MainWindow(this );
		mainWindow.setVisible(true);
		
		User userActual = null;
		Owner ownerActual = null;		
		dialogAddOwner = new Nueve(this, mainWindow);

	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		switch (Actions.valueOf(event.getActionCommand())) {
		case LETS_DO_IT:
			letsDoIt();
			break;
		case SIGN_IN:
			logIn();
			break;
		}
	}
	
	public void letsDoIt() {
		closeAllWindows();
	}
	
	public void logIn(){
		closeAllWindows();
	}
	
	public void closeAllWindows(){
		mainWindow.setVisible(false);
	}
}