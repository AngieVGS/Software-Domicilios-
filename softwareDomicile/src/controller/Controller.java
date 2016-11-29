package controller;

import java.awt.event.ActionEvent;
import view.*;
import java.awt.event.ActionListener;
import model.dao.OwnerManager;
import model.dao.ProductManager;
import model.dao.UserManager;
import model.entity.Owner;
import model.entity.User;


public class Controller implements ActionListener{
	
	private MainWindow mainWindow;
	private OwnerManager ownerManager;
	private ProductManager productManager;
	private UserManager userManager;
	private User user;
	private Owner owner;
	private Nueve dialogAddOwner;
	private Cuatro viewCuatro;
	private Dos viewdos;
	
	public Controller() {
		
		mainWindow = new MainWindow(this );
		mainWindow.setVisible(true);
		viewdos = new Dos(this, mainWindow);
		
		viewCuatro = new Cuatro(this);
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
		case USER:
			userLogin();
			break;
		case BUSINESS_OWNER:
			businessOwnerLogin();
			break;
		}
	}
	public void businessOwnerLogin(){
		viewCuatro.setVisible(false);
		dialogAddOwner.setVisible(true);
	}
	
	public void userLogin(){
		viewCuatro.setVisible(false);
		viewdos.setVisible(true);
		
	}
	
	public void letsDoIt() {
		mainWindow.setVisible(false);
	}
	
	public void logIn(){
		mainWindow.setVisible(false);
		viewCuatro.setVisible(true);
		 
	}
	
	public void closeAllWindows(){
		mainWindow.setVisible(false);
		viewCuatro.setVisible(false);
	   
	}
}