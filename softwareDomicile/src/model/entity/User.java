package model.entity;

import java.util.ArrayList;

import exceptions.NotFoundOrderToList;

public class User {
	private int id;
	private String name;
	private String password;
	private ArrayList<Order> orders;
	private boolean state;
	private ArrayList<Product> productsdese = new ArrayList<>();
	private static int ID_GENERIC = 0;

	public User(String name, String password, ArrayList<Order> orders, boolean state) {
		this.id = ID_GENERIC++;
		this.name = name;
		this.password = password;
		this.orders = orders;
		this.state = state;
	}

	public void addOrden(Order order) {
		orders.add(order);
	}

	public void addProductToMy(Product product) {
		productsdese.add(product);
	}

	public ArrayList<Order> addListOder(Order order) {
		ArrayList<Order> listTotal = new ArrayList<>();
		listTotal.addAll(orders);
		return listTotal;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
	public boolean isState() {
		return state;
	}

	public String getPassword() {
		return password;
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

	public ArrayList<Product> getProductsdese() {
		return productsdese;
	}

	@Override
	public String toString() {
		return "User {id=" + id + ", name=" + name + ", password=" + password + ", orders=" + orders + ", state="
				+ state + ", productsdese=" + productsdese + "}";
	}
}