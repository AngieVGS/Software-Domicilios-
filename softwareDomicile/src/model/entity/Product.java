package model.entity;

public class Product {

	private static int AUXILIAR;
	private int id;
	private String name;
	private String description;
	private double price;
	private State state;
	private String img;

	public Product(String name, String description, double price, State state, String img) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.state = state;
		this.img = img;
		this.id = AUXILIAR++;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", img="
				+ img + "]";
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