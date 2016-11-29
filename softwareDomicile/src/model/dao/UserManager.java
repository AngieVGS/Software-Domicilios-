package model.dao;

import java.util.ArrayList;

import exceptions.ExceptionSearchId;
import model.entity.Order;
import model.entity.User;

public class UserManager {
	private ArrayList<User> userList;
	
	public UserManager(){
		userList = new ArrayList<>();
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

}