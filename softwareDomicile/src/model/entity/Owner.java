package model.entity;

import java.util.ArrayList;
import exceptions.ExceptionSearchId;

public class Owner {

	private int id;
	private String name;
	private String password;
	private ArrayList<Product> productList;
	
	public Owner(int id, String name, String password, ArrayList<Product> productList) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.productList = productList;
	}
	
	public static Product createProduct(int id, String name, String description, double price, State state) {
		return new Product(id, name, description, price, state);
	}
	
	public void addProduct(Product product) {
		productList.add(product);
	}
	
	public void addProducts(ArrayList<Product> products) {
		for (Product product : products) {
			productList.add(product);
		}
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
