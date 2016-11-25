package model.entity;

import java.util.ArrayList;

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
		
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}



	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}