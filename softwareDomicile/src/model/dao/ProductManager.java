package model.dao;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import exceptions.ExceptionSearchId;
import model.entity.Product;
import model.entity.State;

public class ProductManager {
	private ArrayList<Product> productList;
	
	public ProductManager(){
		productList = new ArrayList<>();
	}
	public static Product createProduct(String name, String description, double price, State state, ImageIcon img) {
		return new Product(name, description, price, state,img);
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
