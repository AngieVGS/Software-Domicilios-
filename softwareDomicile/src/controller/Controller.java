package controller;

import view.*;

import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import exceptions.*;
import model.dao.*;
import model.entity.*;
import persistence.FileWrite;

public class Controller implements ActionListener, KeyListener, DropTargetListener {

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
	private User userActual;
	private Owner ownerActual;
	private Cinco cinco;
	private FileWrite fileWrite;
	private Doce doce;
	private DialogOptions options;
	private int position;
	private KeyListenerForLogin keyListener;
	private SieteShowProduct sieteShowProduct;
	private OrderManager orderManager;

	public Controller() {
		keyListener = new KeyListenerForLogin(this);
		options = new DialogOptions(this, mainWindow);
		doce = new Doce(this, mainWindow);
		seis = new Seis(this);
		fileWrite = new FileWrite();
		cinco = new Cinco(this);
		ownerManager = new OwnerManager();
		userManager = new UserManager();
		dialogLogIn = new DialogLogIn(this, keyListener);
		productManager = new ProductManager();
		mainWindow = new MainWindow(this);
		mainWindow.setVisible(true);
		viewdos = new Dos(this, mainWindow);
		viewCuatro = new Cuatro(this);
		viewDiez = new Diez(this);
		userActual = null;
		ownerActual = null;
		dialogAddOwner = new Nueve(this, mainWindow);
		orderManager = new OrderManager();
		sieteShowProduct = new SieteShowProduct(this);
		ownerManager.addOwner(OwnerManager.createOwner("Mc Donalds", "s", "src/image/mcDonalds.jpg"));
		ownerManager.addOwner(OwnerManager.createOwner("El Pirata", "z", "src/image/ElPirata.jpg"));
		ownerManager.addOwner(OwnerManager.createOwner("Al Toque", "z", "src/image/AlToque.png"));
		userManager.addUser(UserManager.createUser("Juan", "X", true));

		productManager.addProduct(ProductManager.createProduct("Hamburguesa Dijon", "deliciosa", 3000, State.RECEIVED,
				"src/image/HamburguerProduct.png"));
		productManager.addProduct(
				ProductManager.createProduct("Gaseosa Manzana", "deliciosa", 3000, State.RECEIVED, "src/image/BebidaProducto.png"));
		productManager.addProduct(
				ProductManager.createProduct("Gaseosa Manzana", "deliciosa", 3000, State.RECEIVED, "src/image/BebidaProducto.png"));
		productManager.addProduct(ProductManager.createProduct("Hamburguesa Dijon", "deliciosa", 3000, State.RECEIVED,
				"src/image/HamburguerProduct.png"));
		try {
			ownerManager.addAssignProductoToOwner(ownerManager
					.createAssignProductoToOwner(productManager.searchProductById(0), ownerManager.searchOwner(1)));
			ownerManager.addAssignProductoToOwner(ownerManager
					.createAssignProductoToOwner(productManager.searchProductById(1), ownerManager.searchOwner(1)));
			ownerManager.addAssignProductoToOwner(ownerManager
					.createAssignProductoToOwner(productManager.searchProductById(2), ownerManager.searchOwner(1)));
			ownerManager.addAssignProductoToOwner(ownerManager
					.createAssignProductoToOwner(productManager.searchProductById(3), ownerManager.searchOwner(1)));
		} catch (ExceptionSearchId e) {
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
			break;
		case LOGIN:
			login();
			break;
		case SIGN_UP:
			signIn();
			break;
		case JOIN_ACCOUNT_OWNER:
			joinOwner();
			break;
		case RESTAURANT:
			testingButtons(Integer.parseInt(((JButton) event.getSource()).getName()));
			break;
		case CREATE_PRODUCT:
			createProduct();
			break;
		case GENERATE_ORDER:
			break;
		case CREATE_PRODUCT_NEW:
			showDialogcreateProduct();
			break;
		case BACK_VIEW_THREE:
			backViewThree();
			break;
		case SHOW_DIALOG_OPTIONS:
			showDialogOptionsRestaurant();
			break;
		case BACK_OF_OPTIONS_DIALOG:
			dontShowOptionsDialog();
			break;
		case EDIT_PRODUCT_BYOWNER:
			showProductByOwner(Integer.parseInt(((JButton) event.getSource()).getName()));
			break;
		case SAVE_EDITED_PRODUCT:
			saveEditedProductByOwner();
			break;
		case SEARCH_PRODUCT_BYWORD:
			searchProductsByOwner();
			break;
		case SEARCH_OWNER_BYWORD:
			searchOwnersByUser();
			break;
		case SHOW_MENU_FOR_OWNER:
			showMenuOwner();
			break;
		case SHOW_ORDERS_FOR_OWNER:
			showOrdersOwner();
			break;
		case BACK_SIX:
			backsix();
			break;
		case EXIT:
             System.exit(0);
             break;
		case CHANGE_STATUS:
			break;
		case GENERATE_SHOPPING_CAR:
			generateShoppingCar();
			break;
		}
	}
	
	private void generateShoppingCar() {
		
		sieteShowProduct.fillPanelCenter(orderManager.getShoppingCarList());
		sieteShowProduct.setVisible(true);
		cinco.setVisible(false);
		seis.setVisible(false);
	}
	
	private void backsix() {
		cinco.setVisible(false);
		seis.setVisible(true);
	}

	//Este metodo es para mostrar las ordenes que tiene un restaurante. Utilizar el metodo de la clase Diez, agregarpaneles
	private void showOrdersOwner() {
	}

	private void showMenuOwner() {
		try {
			viewDiez.addPanelsToDialogForProducts(ownerManager.searchAssignProductoToOwner(ownerActual.getId()));
		} catch (ExceptionSearchId e) {
			e.printStackTrace();
		}
	}

	private void searchOwnersByUser(){
		seis.addPanelsToDialogForProducts(ownerManager.searchOwnersByWord(seis.getWordOnSpace()));
	}

	private void searchProductsByOwner() {
		try {
			ArrayList<Product> products = ownerManager.searchProductByWord(viewDiez.getWordOnSpace(), ownerManager.searchAssignProductoToOwner(ownerActual.getId()));
			viewDiez.addPanelsToDialogForProducts(products);
		} catch (ExceptionSearchId e) {
			e.printStackTrace();
		}
	}

	private void saveEditedProductByOwner() {
		try {
			Product product = productManager.searchProductById(position);
			product.setAttributes(doce.getNameProduct(), doce.getDescriptionProduct(), doce.getPriceProduct(), doce.getImageProduct());
			viewDiez.addPanelsToDialogForProducts(ownerManager.searchAssignProductoToOwner(ownerActual.getId()));
			viewDiez.setVisible(true);
			doce.setVisible(false);
			doce.clear();
		} catch (ExceptionSearchId e) {
			e.printStackTrace();
		}
	}

	private void showProductByOwner(int idProduct) {
		try {
			viewDiez.setVisible(false);
			doce.editProduct(productManager.searchProductById(idProduct));
			position = idProduct;
			doce.setVisible(true);
		} catch (ExceptionSearchId e1) {
		}
	}

	private void showDialogcreateProduct() {
		viewDiez.setVisible(false);
		options.setVisible(false);
		doce.addProduct();
		doce.setVisible(true);
	}

	private void dontShowOptionsDialog() {
		options.setVisible(false);
	}

	private void showDialogOptionsRestaurant() {
		options.setVisible(true);
	}

	private void backViewThree() {
		seis.setVisible(false);
		seis.clear();
		dialogLogIn.setVisible(true);
		viewDiez.clear();
		options.setVisible(false);
		viewDiez.setVisible(false);
	}

	public void createProduct() {
		try {
			Product product = doce.createProduct();
			productManager.addProduct(product);
			ownerManager.addAssignProductoToOwner(ownerManager.createAssignProductoToOwner(product, ownerActual));
			viewDiez.addPanelsToDialogForProducts(ownerManager.searchAssignProductoToOwner(ownerActual.getId()));
			viewDiez.setVisible(true);
			doce.setVisible(false);
			doce.clear();
		} catch (ExceptionSearchId e) {
			e.printStackTrace();
		}
	}

	// Este metodo arroja por consola los ID unicos para cada resturante
	private void testingButtons(int idOwner) {
		try {
			Owner owner = ownerManager.searchOwner(idOwner);
			cinco.fillCenter(ownerManager.searchAssignProductoToOwner(idOwner), this);
			cinco.changeNameOwner(owner.getName());
			cinco.setVisible(true);
		} catch (ExceptionSearchId e1) {
		}
	}

	private void addMyProductToListOrder(int idProdcut) {
		try {
			Product product = productManager.searchProductById(idProdcut);
			cinco.counttotal(product.getPrice());
			orderManager.addShoppingCarList(product);
		} catch (ExceptionSearchId e) {
		}
	}

	public void joinOwner() {
		try {
			ownerManager.addOwner(dialogAddOwner.createOwner());
			fileWrite.saveOwner(ownerManager.getOwnerList());
			dialogAddOwner.clear();
			dialogAddOwner.setVisible(false);
			dialogLogIn.setVisible(true);
		} catch (ExceptionIncorrectPassword e) {
			dialogAddOwner.validatePasswordField();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void join() {
		try {
			
			userManager.addUser(viewdos.createUser());
			fileWrite.saveUser(userManager.getUserList());
			viewdos.clear();
			viewdos.setVisible(false);
			dialogLogIn.setVisible(true);
		} catch (ExceptionIncorrectPassword e) {
			viewdos.validatePasswordField();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void login() {
		String nameUser = dialogLogIn.dataLogIn()[0];
		try {
			User user = userManager.searchUserByName(nameUser);
			userActual = user;
			seis.addPanelsToDialogForProducts(ownerManager.getOwnerList());
			seis.setVisible(true);
			dialogLogIn.setVisible(false);
		} catch (ExceptionSearchId e) {
			try {
				Owner owner = ownerManager.searchOwnerByName(nameUser);
				ownerActual = owner;
				viewDiez.addPanelsToDialogForProducts(ownerManager.searchAssignProductoToOwner(ownerActual.getId()));
				viewDiez.setVisible(true);
				dialogLogIn.setVisible(false);
			} catch (ExceptionSearchId f) {
				//				JOptionPane.showMessageDialog(mainWindow, f.getMessage());
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
		dialogLogIn.setVisible(false);
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
		if (seis.getWordOnSpace().length() == limit) {
			e.consume();
		}
	}

	@Override
	public void dragEnter(DropTargetDragEvent arg0) {
	}

	@Override
	public void dragExit(DropTargetEvent arg0) {
	}

	@Override
	public void dragOver(DropTargetDragEvent arg0) {
	}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		dtde.acceptDrop(DnDConstants.ACTION_COPY);
		try {
			if (doce.isVisible() == true) {
				doce.addImage(dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor).toString().replace("[", "").replace("]", "").replace("\\", "/"));
				Toolkit.getDefaultToolkit().beep();
			}else if (dialogAddOwner.isVisible() == true) {
				dialogAddOwner.addImage(dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor).toString().replace("[", "").replace("]", "").replace("\\", "/"));
				Toolkit.getDefaultToolkit().beep();
			}
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		dtde.dropComplete(true);

	}

	@Override
	public void dropActionChanged(DropTargetDragEvent arg0) {
	}
}