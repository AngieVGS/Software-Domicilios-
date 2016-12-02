package exceptions;

public class ExceptionIncorrectPassword extends Exception{
	
	public ExceptionIncorrectPassword() {
		super("Incoming passwords do not match incorrect password");
	}

}
