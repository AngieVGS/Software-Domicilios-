package model.entity;

public class Owner {

	private int id;
	private String name;
	private String password;
	private String url;
	private static int ID_GENERIC;

	public Owner(String name, String password, String url) {
		this.id = ID_GENERIC++;
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