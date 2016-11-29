package model.entity;

public class AssignProductToOwner {

	private Product product;
	private Owner owner;

	public AssignProductToOwner(Product product, Owner owner) {
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
