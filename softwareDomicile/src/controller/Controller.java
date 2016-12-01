package controller;

import java.awt.event.ActionEvent;
import view.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import exceptions.ExceptionIncorrectPassword;
import exceptions.ExceptionSearchId;
import model.dao.OwnerManager;
import model.dao.ProductManager;
import model.dao.UserManager;
import model.entity.Owner;
import model.entity.Product;
import model.entity.State;
import model.entity.User;
import view.DialogLogIn;
import view.Seis;


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
	private Seis seis;
	private Doce doce;
	private User userActual;
	private Owner ownerActual;
	private Cinco cinco;

	public Controller() {
		 seis = new Seis();
		 cinco= new Cinco();
		 ownerManager = new OwnerManager();
		 userManager = new UserManager();
		 dialogLogIn = new DialogLogIn(this);
		 mainWindow = new MainWindow(this );
		 mainWindow.setVisible(true);
		 viewdos = new Dos(this, mainWindow);
		 viewCuatro = new Cuatro(this);
		 viewDiez = new Diez(this);
		 doce = new Doce(this, mainWindow);
		 userActual = null;
		  ownerActual = null;
		 User userActual = null;
		 Owner ownerActual = null;
		 dialogAddOwner = new Nueve(this, mainWindow);
		 ownerManager.addOwner(OwnerManager.createOwner("Mc Donalds", "s","src/image/mcDonalds.jpg"));
		 ownerManager.addOwner(OwnerManager.createOwner("El Pirata", "z","src/image/ElPirata.jpg"));
		 ownerManager.addOwner(OwnerManager.createOwner("Al Toque", "z","src/image/AlToque.png"));
		 userManager.addUser(UserManager.createUser("Juan", "X",null,true));
	
		 productManager.addProduct(ProductManager.createProduct("hamburguesa", "deliciosa", 3000, State.RECEIVED, "src/image/logoicon.png"));
		 productManager.addProduct(ProductManager.createProduct("2", "deliciosa", 3000, State.RECEIVED, "src/image/logoicon.png"));
		 productManager.addProduct(ProductManager.createProduct("23", "deliciosa", 3000, State.RECEIVED, "src/image/logoicon.png"));
		 productManager.addProduct(ProductManager.createProduct("hamb3rguesa", "deliciosa", 3000, State.RECEIVED, "src/image/logoicon.png"));
	     try {
			ownerManager.addAssignProductoToOwner(ownerManager.createAssignProductoToOwner(productManager.searchProductById(0), ownerManager.searchOwner(1)));
			ownerManager.addAssignProductoToOwner(ownerManager.createAssignProductoToOwner(productManager.searchProductById(1), ownerManager.searchOwner(1)));
			ownerManager.addAssignProductoToOwner(ownerManager.createAssignProductoToOwner(productManager.searchProductById(2), ownerManager.searchOwner(1)));
			ownerManager.addAssignProductoToOwner(ownerManager.createAssignProductoToOwner(productManager.searchProductById(3), ownerManager.searchOwner(1)));
		} catch (ExceptionSearchId e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (Actions.valueOf(event.getActionCommand())) {
		case LETS_DO_IT:
			letsDoIt();
			break;
		case SIGN_IN:
			signIn();
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
		case JOIN:
			join();
		case LOGIN:
			login();
			break;	
		case SIGN_UP:
			break;
		case JOIN_ACCOUNT_OWNER:
			joinOwner();
			break;
		case RESTAURANT:
			testingButtons(event);
			break;
		case CREATE_PRODUCT:
			createProduct();
			break;
		}
	}
	
	//Este metodo arroja por consola los ID unicos para cada resturante
	private void testingButtons(ActionEvent e) {
		System.out.println((((JButton) e.getSource()).getName()));
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
	
	public void createProduct() {
		productManager.addProduct(doce.createProduct());
		doce.clear();
		doce.setVisible(false);
	}
	
	public void joinOwner() {
		try {
			ownerManager.addOwner(dialogAddOwner.createOwner());
			dialogAddOwner.clear();
			dialogAddOwner.setVisible(false);
		} catch (ExceptionIncorrectPassword e) {
//			e.printStackTrace();
			dialogAddOwner.validatePasswordField();
		}	
		}
	
	public void join(){
		try {
			userManager.addUser(viewdos.createUser());
			viewdos.clear();
			viewdos.setVisible(false);
		} catch (ExceptionIncorrectPassword e) {
//			e.printStackTrace();
			viewdos.validatePasswordField();
		}
	}
	
	public void login(){
		String nameUser =  dialogLogIn.dataLogIn()[0];
		try {
			userManager.searchUserByName(nameUser);
			seis.addPanelsToDialogForProducts(ownerManager.getOwnerList(), this);
			seis.setVisible(true);
			dialogLogIn.setVisible(false);
		} catch (ExceptionSearchId e) {
			try {
				ownerManager.searchOwnerByName(nameUser);
				viewDiez.setVisible(true);
				dialogLogIn.setVisible(false);
			}catch (ExceptionSearchId f) {
				JOptionPane.showMessageDialog(mainWindow, f.getMessage());
			}
		}
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

	public void signIn() {
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