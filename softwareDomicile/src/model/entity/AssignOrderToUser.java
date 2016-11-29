package model.entity;

public class AssignOrderToUser {

	private Order order;
	private User user;

	public AssignOrderToUser(Order order, User user) {
		this.order = order;
		this.user = user;
	}
	public Order getOrder() {
		return order;
	}
	public User getUser() {
		return user;
	}
	@Override
	public String toString() {
		return "AssignOrder [order=" + order + ", user=" + user + "]";
	}
}