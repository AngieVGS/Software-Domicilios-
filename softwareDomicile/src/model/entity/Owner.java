package model.entity;

public class Owner {

	private int id;
	private String name;
	private String password;
	private String url;

	public Owner(int id, String name, String password, String url) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}