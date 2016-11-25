package exceptions;

public class ExceptionSearchId extends Exception{

	private static final long serialVersionUID = 1L;

	public ExceptionSearchId() {
		super("The element you are looking for does not exist.");
	}
}
