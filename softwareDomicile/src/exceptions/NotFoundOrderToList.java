package exceptions;

import javax.management.remote.SubjectDelegationPermission;

public class NotFoundOrderToList extends Exception {
	public NotFoundOrderToList() {
		super("NOT FOUND ORDER...");
	}
}