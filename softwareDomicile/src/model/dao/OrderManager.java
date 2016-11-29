package model.dao;

import java.util.ArrayList;

import exceptions.AggregatedProduct;
import exceptions.ExceptionSearchId;
import exceptions.ProductNotFound;
import model.entity.AssignProductToOrder;
import model.entity.Order;
import model.entity.Product;
import model.entity.State;

public class OrderManager {

	private ArrayList<Order> orderList;
	private ArrayList<Product> productsOfTheOrder;

	public OrderManager() {
		this.orderList = new ArrayList<>();
		this.productsOfTheOrder = new ArrayList<>();
	}

	public static Order createOrder(int id, State state, String direction) {
		return new Order(id, state, direction);
	}

	public void addOrder(Order order) {
		orderList.add(order);
	}

	public Order searchOrder(int id) throws ExceptionSearchId {
		for (Order order : orderList) {
			if (order.getId() == id) {
				return order;
			}
		}
		throw new ExceptionSearchId();
	}

	public void deleteOrder(Order order) {
		orderList.remove(order);
	}

	public void editOwner(Order order, int id) {
		orderList.set(id, order);
	}

	public boolean isToSend() {
		for (Product product : productsOfTheOrder) {
			if (product.getState().equals(State.TO_SEND)) {
				return true;
			}
		}
		return false;
	}

	public boolean isSend() {
		for (Product product : productsOfTheOrder) {
			if (!product.getState().equals(State.SEND)) {
				return false;
			}
		}
		return true;
	}

	public boolean isRecived() {
		for (Product product : productsOfTheOrder) {
			if (product.getState().equals(State.RECEIVED)) {
				return false;
			}
		}
		return true;
	}

	public boolean isProductToOrder(Product product) {
		for (Product productFromOrder : productsOfTheOrder) {
			if (product.equals(productFromOrder)) {
				return true;
			}
		}
		return false;
	}

	public void addProduct(Product product) throws AggregatedProduct {
		if (!isProductToOrder(product)) {
			productsOfTheOrder.add(product);
		} else {
			throw new AggregatedProduct();
		}
	}

	public void addListProduct(ArrayList<Product> productsToOrder) throws AggregatedProduct {
		productsOfTheOrder.addAll(productsToOrder);
	}

	public State getState(Order order) {
		if (isToSend()) {
			order.setState(State.TO_SEND);
		}
		if (isRecived()) {
			order.setState(State.RECEIVED);
		} else {
			order.setState(State.RECEIVED);
		}
		return order.getState();
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
		} else {
			throw new ProductNotFound();
		}
	}
	
	public static AssignProductToOrder createAssignProductToOrder(Order order, Product product){
		return new AssignProductToOrder(order, product);
	}
	
}
