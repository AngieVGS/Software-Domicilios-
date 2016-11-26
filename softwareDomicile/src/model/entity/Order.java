package model.entity;

import java.util.ArrayList;

import exceptions.AggregatedProduct;
import exceptions.ProductNotFound;

public class Order {

	private int id;
	private ArrayList<Product> productsOfTheOrder;
	private State state;
	private String direction;
	
	
	public Order(int id, ArrayList<Product> productsOfTheOrder, State state, String direction) {
		this.id = id;
		this.productsOfTheOrder = productsOfTheOrder;
		this.state = state;
		this.direction = direction;
	}
	
	public void addproduct(Product product){
		productsOfTheOrder.add(product);
	}
	
	public int getId() {
		return id;
	}
	
	public State  getState(){
		if (isToSend()) {
			state = State.TO_SEND;
		}
		if (isRecived()) {
			state = State.RECEIVED;
		}
		else {
			state = State.RECEIVED;
		}
		return state;
	}
	
	public boolean isToSend(){
		for (Product product : productsOfTheOrder) {
			if (product.getState().equals(State.TO_SEND)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isSend(){
		for (Product product : productsOfTheOrder) {
			if (!product.getState().equals(State.SEND)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isRecived(){
		for (Product product : productsOfTheOrder) {
			if (product.getState().equals(State.RECEIVED)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isProductToOrder(Product product){
		for (Product productFromOrder : productsOfTheOrder) {
			if (product.equals(productFromOrder)) {
				return true;
			}
		}
		return false;
	}
	
	public void addProduct(Product product) throws AggregatedProduct{
		if (!isProductToOrder(product)) {
			productsOfTheOrder.add(product);
		}else{
			throw new AggregatedProduct();
		}
	}	
		
	public void addListProduct(ArrayList<Product> productsToOrder) throws AggregatedProduct{
		productsOfTheOrder.addAll(productsToOrder);
	}
	
	public ArrayList<Product> searchProductByName(String name) {
		ArrayList<Product> productsFounds = new ArrayList<>();
		for (Product product : productsFounds) {
			if (product.getName().equalsIgnoreCase(name)) {
				productsFounds.add(product);
			}
		}
		return productsFounds;
	}
	
	public void deleteProduct(Product product) throws ProductNotFound {
		if (isProductToOrder(product)) {
			productsOfTheOrder.remove(product);
		}else{
			throw new ProductNotFound();
		}
	}
}