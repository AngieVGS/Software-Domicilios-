package model.entity;

public class AssignProduct {

	private Product product;
	private Owner owner;

	public AssignProduct(Product product, Owner owner) {
		this.product = product;
		this.owner = owner;
	}

	public Product getProduct() {
		return product;
	}

	public Owner getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return "AssignProduct [product=" + product + ", owner=" + owner + "]";
	}
	
	
	
}
