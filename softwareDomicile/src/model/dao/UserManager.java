package model.dao;

import java.util.ArrayList;

import exceptions.ExceptionSearchId;
import model.entity.AssignOrderToUser;
import model.entity.Order;
import model.entity.User;

public class UserManager {
	private ArrayList<User> userList;
	private ArrayList<AssignOrderToUser> assignOrderList;

	public UserManager() {
		userList = new ArrayList<>();
		assignOrderList = new ArrayList<>();
	}

	// crud de ususario
	public static User createUser(String name, String password, boolean state) {
		return new User(name, password, state);
	}

	public void addUser(User user) {
		userList.add(user);
	}
	
	public void updateUserList(ArrayList<User> users){
		userList = users;
	}

	public User searchUser(int id) throws ExceptionSearchId {
		for (User user : userList) {
			if (user.getId() == id) {
				return user;
			}
		}
		throw new ExceptionSearchId();
	}

	public User searchUserByName(String name) throws ExceptionSearchId {
		for (User user : userList) {
			if (user.getName().equals(name)) {
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

	public static AssignOrderToUser createAssignOrder(Order order, User user) {
		return new AssignOrderToUser(order, user);
	}

	public void addAssignOrderToUser(AssignOrderToUser assignOrder) {
		assignOrderList.add(assignOrder);
	}

	public ArrayList<Order> searchAssignOrderToUser(int id) throws ExceptionSearchId {
		ArrayList<Order> orders = new ArrayList<>();
		for (AssignOrderToUser assignOrder : assignOrderList) {
			if (assignOrder.getUser().getId() == id) {
				orders.add(assignOrder.getOrder());
			}
			return orders;
		}
		throw new ExceptionSearchId();
	}

	public void deleteAssignProduct(AssignOrderToUser assignOrder) {
		assignOrderList.remove(assignOrder);
	}

	public ArrayList<AssignOrderToUser> getAssingOrderToUser() {
		return assignOrderList;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public ArrayList<AssignOrderToUser> getAssignOrderList() {
		return assignOrderList;
	}
}