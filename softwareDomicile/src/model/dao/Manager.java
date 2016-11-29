package model.dao;

import java.util.ArrayList;

import exceptions.ExceptionSearchId;
import model.entity.Order;
import model.entity.Owner;
import model.entity.Product;
import model.entity.State;
import model.entity.User;

public class Manager {
	private ArrayList<Owner> ownerList;
	private ArrayList<User> userList;
	private ArrayList<Product> productList;

	public Manager() {
		ownerList = new ArrayList<>();
		userList = new ArrayList<>();
		productList = new ArrayList<>();
	}

	public Owner createOwner(int id, String name, String password) {
		return new Owner(id, name, password);
	}

	public void addOwner(Owner owner) {
		ownerList.add(owner);
	}

	public Owner searchOwner(int id) throws ExceptionSearchId {
		for (Owner owner : ownerList) {
			if (owner.getId() == id) {
				return owner;
			}
		}
		throw new ExceptionSearchId();
	}

	public void deleteOwner(Owner owner) {
		ownerList.remove(owner);
	}

	public void editOwner(Owner owner, int id) {
		ownerList.set(id, owner);
	}

	// crud de ususario
	public User createUser(int id, String name, String password, ArrayList<Order> orderList, boolean state) {
		return new User(id, name, password, orderList, state);
	}

	public void addUser(User user) {
		userList.add(user);
	}

	public User searchUser(int id) throws ExceptionSearchId {
		for (User user : userList) {
			if (user.getId() == id) {
				return user;
			}
		}
		throw new ExceptionSearchId();
	}

	public void deleteUser(User user) {
		userList.remove(user);
	}

	public void editUser(User user, int id) {
		userList.set(id, user);
	}

	public static Product createProduct(int id, String name, String description, double price, State state, String img) {
		return new Product(id, name, description, price, state,img);
	}

	public void addProduct(Product product) {
		productList.add(product);
	}

	public Product searchProductById(int id) throws ExceptionSearchId {
		for (Product product : productList) {
			if (product.getId() == id) {
				return product;
			}
		}
		throw new ExceptionSearchId();
	}

	public ArrayList<Product> searchProductByName(String name) {
		ArrayList<Product> productSearchList = new ArrayList<>();
		for (Product product : productList) {
			if (product.getName().equalsIgnoreCase(name)) {
				productSearchList.add(product);
			}
		}
		return productSearchList;
	}

	public void editProduct(Product product) throws ExceptionSearchId {
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getId() == product.getId()) {
				productList.remove(i);
				productList.add(i, product);
				break;
			}
		}
	}

	public void deleteProduct(int id) {
		for (Product product : productList) {
			if (product.getId() == id) {
				productList.remove(product);
				break;
			}
		}
	}
}