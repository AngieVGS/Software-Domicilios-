package exceptions;

public class ProductNotFound extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ProductNotFound() {
		super("The product is not added in this order");
	}
}