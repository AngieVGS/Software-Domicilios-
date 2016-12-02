package model.entity;

public class Order {

	private int id;
	private State state;
	private String direction;
	
	public Order(int id, State state, String direction) {
		this.id = id;
		this.state = state;
		this.direction = direction;
	}
	
	public int getId() {
		return id;
	}
	
	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public String getDirection() {
		return direction;
	}

	public void editOrder(){
		
	}
}