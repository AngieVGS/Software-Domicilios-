package model.entity;


public class Owner {

	private int id;
	private String name;
	private String password;

	
	public Owner(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	
	}
	
	public int getId(){
		return id;
	}
	
	
}
