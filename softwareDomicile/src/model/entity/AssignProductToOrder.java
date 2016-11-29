package model.entity;

public class AssignProductToOrder {

	private Order order;
	private Product product;
	public AssignProductToOrder(Order order, Product product) {
		super();
		this.order = order;
		this.product = product;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public String toString() {
		return "AssignProductToOrder [order=" + order + ", product=" + product + "]";
	}
	
}
