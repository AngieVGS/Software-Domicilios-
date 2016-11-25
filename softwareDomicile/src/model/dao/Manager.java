package model.dao;

import java.util.ArrayList;

import model.entity.Order;
import model.entity.Owner;
import model.entity.Product;
import model.entity.User;

public class Manager {
	private ArrayList<Owner> ownerList;
	private ArrayList<User> userList;
	
	public Manager(){
		ownerList = new ArrayList<>();
		userList = new ArrayList<>(); 
	}
	
//	public Owner createOwner(int id, String name, String password, ArrayList<Product> productList){
//		return new Owner(id, name, password,productList);
//	}
	
	public void addOwner(Owner owner){
		ownerList.add(owner);
	}
	
	public Owner searchOwner(int id){
		for (Owner owner : ownerList) {
//			if(owner.getId() == id){
//				return owner;
//			}
		}
		return null;
	}
	
	public void deleteOwner(Owner owner){
		ownerList.remove(owner);
	}
	
	public void editOwner(Owner owner, int id){
		ownerList.set(id, owner);
	}
	
	
	//crud de ususario
	public User createUser(int id, String name, String password, ArrayList<Order> orderList, boolean state){
		return new User(id, name, password, orderList, state);
	}
	
	public void addUser(User user){
		userList.add(user);
	}
	
	public User searchUser(int id){
		for (User user : userList){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public void deleteUser(User user){
		userList.remove(user);
	}
	
	public void editUser(User user, int id){
		userList.set(id, user);
	}
	
}
