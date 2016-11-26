package exceptions;

public class AggregatedProduct extends Exception {

	private static final long serialVersionUID = 1L;

	public AggregatedProduct() {
		super("This product has already been added to the Order");
	}	
}