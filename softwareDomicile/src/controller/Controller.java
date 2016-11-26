package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.dao.Manager;
import model.entity.Owner;
import model.entity.User;
import view.MainWindow;

public class Controller implements ActionListener{
	
	private MainWindow mainWindow;
	private Manager manager;
	private User user;
	private Owner owner;
	
	public Controller() {
//		mainWindow = new MainWindow(Controller );
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (Actions.valueOf(event.getActionCommand())) {
		}
	}
}