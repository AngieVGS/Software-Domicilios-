package exceptions;

public class NotFoundOrderToList extends Exception {
	private static final long serialVersionUID = 1L;

	public NotFoundOrderToList() {
		super("NOT FOUND ORDER...");
	}
}