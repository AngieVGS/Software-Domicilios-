package model.entity;

public class Product {

	private int id;
	private String name;
	private String description;
	private double price;
	private State state;
	private String img;

	public Product(int id, String name, String description, double price, State state, String img) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.state = state;
		this.img = img;
	}

	@Override
	public String toString() {
		return "Producto: " + " " + name + " " + description + " " + price + " " + state;
	}

	public void changeStatus(State state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public State getState() {
		return state;
	}

	public String getImg() {
		return img;
	}
}