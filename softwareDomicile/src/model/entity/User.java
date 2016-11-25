package model.entity;

import java.util.ArrayList;

import exceptions.NotFoundOrderToList;

public class User {
	private int id;
	private String name;
	private String password;
	private ArrayList<Order> orders;
	private boolean state;

	public User(int id, String name, String password, ArrayList<Order> orders, boolean state) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.orders = orders;
		this.state = state;
	}

	public void addOrden(Order order) {
		orders.add(order);
	}

	public ArrayList<Order> addListOder(Order order) {
		ArrayList<Order> listTotal = new ArrayList<>();
		listTotal.addAll(orders);
		return listTotal;
	}

	public String getName() {
		return name;
	}
	
	public int getId(){
		return id;
	}

	public Order searchOrderAddedtoListToName(String nameOrder) throws NotFoundOrderToList {
		for (Order order : orders) {
			if (order.getName().equals(nameOrder)) {
				return order;
			}
		}
		throw new NotFoundOrderToList();
	}

	public Order searchOrderAddedtoListToId(int idOrder) throws NotFoundOrderToList {
		for (Order order : orders) {
			if (order.getId() == idOrder) {
				return order;
			}
		}
		throw new NotFoundOrderToList();
	}

	public void deleteOrderToList(Order order2) {
		orders.remove(order2);
	}

	public void adithOrder() {

	}

	
}
