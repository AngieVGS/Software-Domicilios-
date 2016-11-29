package model.dao;

import java.util.ArrayList;

import exceptions.ExceptionSearchId;
import model.entity.AssignOrder;
import model.entity.AssignProduct;
import model.entity.Order;
import model.entity.User;

public class UserManager {
	private ArrayList<User> userList;
	private ArrayList<AssignOrder> assignOrderList;
	
	public UserManager(){
		userList = new ArrayList<>();
		assignOrderList = new ArrayList<>();
	}
	// crud de ususario
		public User createUser(int id, String name, String password, ArrayList<Order> orderList, boolean state) {
			return new User(id, name, password, orderList, state);
		}

		public void addUser(User user) {
			userList.add(user);
		}

		public User searchUser(int id) throws ExceptionSearchId {
			for (User user : userList) {
				if (user.getId() == id) {
					return user;
				}
			}
			throw new ExceptionSearchId();
		}

		public void deleteUser(User user) {
			userList.remove(user);
		}

		public void editUser(User user, int id) {
			userList.set(id, user);
		}
public static AssignOrder createAssignOrder(Order order, User user){
	return new AssignOrder(order, user);
}
public void addAssignProductoToOwner(AssignOrder assignOrder) {
	assignOrderList.add(assignOrder);
}

public AssignOrder searchAssignProductoToOwner(int id) throws ExceptionSearchId {
	for (AssignOrder assignOrder : assignOrderList) {
		if (assignOrder.getUser().getId() == id) {
			return assignOrder;
		}
	}
	throw new ExceptionSearchId();
}

public void deleteAssignProduct(AssignOrder assignOrder) {
	assignOrderList.remove(assignOrder);
}
}
