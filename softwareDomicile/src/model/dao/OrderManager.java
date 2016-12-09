package model.dao;

import java.util.ArrayList;

import exceptions.ExceptionSearchId;
import model.entity.AssignProductToOrder;
import model.entity.Order;
import model.entity.Product;
import model.entity.State;

public class OrderManager {

	private ArrayList<Order> orderList;
	private ArrayList<AssignProductToOrder> productsOfTheOrder;
	private ArrayList<Product> shoppingCarList;

	public OrderManager() {
		this.orderList = new ArrayList<>();
		this.productsOfTheOrder = new ArrayList<>();
		shoppingCarList = new ArrayList<>();
	}

	public void addShoppingCarList(Product product) {
		shoppingCarList.add(product);
	}

	public void removeProducOfShoppingCarList(Product product) {
		shoppingCarList.remove(product);
	}

	public ArrayList<Product> getShoppingCarList() {
		return shoppingCarList;
	}

	public void removeAllProductOfShoppingCarList() {
		shoppingCarList.clear();
	}

	public static Order createOrder(int id, String direction) {
		return new Order(id, direction);
	}

	public void addOrder(Order order) {
		orderList.add(order);
	}

	public Product searchProductMyCar(int id) throws ExceptionSearchId {
		for (Product product : shoppingCarList) {
			if (product.getId() == id) {
				return product;
			}
		}
		throw new ExceptionSearchId();
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
		for (AssignProductToOrder assignProductToOrder : productsOfTheOrder) {
			if (assignProductToOrder.getProduct().getState().equals(State.TO_SEND)) {
				return true;
			}
		}
		return false;
	}

	public boolean isSend() {
		for (AssignProductToOrder assignProductToOrder : productsOfTheOrder) {
			if (!assignProductToOrder.getProduct().getState().equals(State.SEND)) {
				return false;
			}
		}
		return true;
	}

	public boolean isRecived() {
		for (AssignProductToOrder assignProductToOrder : productsOfTheOrder) {
			if (assignProductToOrder.getProduct().getState().equals(State.RECEIVED)) {
				return false;
			}
		}
		return true;
	}

	public boolean isProductToOrder(Product product) {
		for (AssignProductToOrder assignProductToOrder : productsOfTheOrder) {
			if (assignProductToOrder.getProduct().equals(assignProductToOrder)) {
				return true;
			}
		}
		return false;
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

	public static AssignProductToOrder createAssignProductToOrder(Order order, Product product) {
		return new AssignProductToOrder(order, product);
	}

	public void addAssignProductoToOrder(AssignProductToOrder assignProductToOrder) {
		productsOfTheOrder.add(assignProductToOrder);
	}

	public ArrayList<Product> searchAssignProductToOrder(int id) throws ExceptionSearchId {
		ArrayList<Product> products = new ArrayList<>();
		for (AssignProductToOrder assignProductToOrder : productsOfTheOrder) {
			if (assignProductToOrder.getOrder().getId() == id) {
				products.add(assignProductToOrder.getProduct());
			}
		}
		return products;
	}

	public void deleteAssignProductToOrder(AssignProductToOrder assignProductToOrder) {
		productsOfTheOrder.remove(assignProductToOrder);
	}

}
