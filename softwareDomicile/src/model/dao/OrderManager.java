package model.dao;

import java.util.ArrayList;

import exceptions.ExceptionSearchId;
import model.entity.Order;
import model.entity.Product;
import model.entity.State;

public class OrderManager {

	private ArrayList<Order> orderList;

	public OrderManager() {
		this.orderList = new ArrayList<>();
	}
	
	public static Order createOrder(int id, ArrayList<Product> productsOfTheOrder, State state, String direction){
		return new Order(id, productsOfTheOrder, state, direction);
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

}
