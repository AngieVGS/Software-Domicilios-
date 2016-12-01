package exceptions;

public class ExceptionIncorrectPassword extends Exception{
	private static final long serialVersionUID = -8404677965169219364L;

	public ExceptionIncorrectPassword() {
		super("Incoming passwords do not match incorrect password");
	}
}