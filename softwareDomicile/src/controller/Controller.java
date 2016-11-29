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
//		mainWindow = new MainWindow(Controller );
//		manager = new Manager();
		dialogAddOwner = new Nueve(this, mainWindow);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (Actions.valueOf(event.getActionCommand())) {
		}
	}
}