package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainWindow;

public class Controller implements ActionListener{
	
	private MainWindow mainWindow;
	
	public Controller() {
		mainWindow = new MainWindow();
	}
	
	public void run(){
		mainWindow.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (Actions.valueOf(event.getActionCommand())) {
		}
	}
}