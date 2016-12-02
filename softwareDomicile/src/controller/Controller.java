package controller;

import java.awt.event.ActionEvent;
import view.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import exceptions.ExceptionSearchId;
import model.dao.OwnerManager;
import model.dao.ProductManager;
import model.dao.UserManager;
import model.entity.Owner;
import model.entity.Product;
import model.entity.State;
import model.entity.User;
import view.DialogLogIn;

public class Controller implements ActionListener, KeyListener {

	private MainWindow mainWindow;
	private OwnerManager ownerManager;
	private ProductManager productManager;
	private UserManager userManager;
	private User user;
	private Owner owner;
	private Nueve dialogAddOwner;
	private Cuatro viewCuatro;
	private Dos viewdos;
	private Diez viewDiez;
	private DialogLogIn dialogLogIn;

	public Controller() {


		 dialogLogIn = new DialogLogIn(this);
		 mainWindow = new MainWindow(this );
		 mainWindow.setVisible(true);
		 viewdos = new Dos(this, mainWindow);
		 viewCuatro = new Cuatro(this);
		 viewDiez = new Diez(this);
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
		case PRODUCT_ADD_MY_CAR:
			addMyProductToListOrder(Integer.parseInt(((JButton) event.getSource()).getName()));
			break;
		}
	}

	private void addMyProductToListOrder(int idProdcut) {
		try {
			Product product = productManager.searchProductById(idProdcut);
			user.addProductToMy(product);
		} catch (ExceptionSearchId e) {
			e.printStackTrace();
		}
		System.out.println(user.getProductsdese());
	}

	public void businessOwnerLogin() {
		viewCuatro.setVisible(false);
		dialogAddOwner.setVisible(true);
	}

	public void userLogin() {
		viewCuatro.setVisible(false);
		viewdos.setVisible(true);

	}

	public void letsDoIt() {
		mainWindow.setVisible(false);
		dialogLogIn.setVisible(true);
	}

	public void logIn() {
		mainWindow.setVisible(false);
		viewCuatro.setVisible(true);

	}

	public void closeAllWindows() {
		mainWindow.setVisible(false);
		viewCuatro.setVisible(false);

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		limitCharactersForToolbar(e);
	}

	public void limitCharactersForToolbar(KeyEvent e) {
		int limit = 38;
		if (viewDiez.getWordOnSpace().length() == limit) {
			e.consume();
		}
	}
}