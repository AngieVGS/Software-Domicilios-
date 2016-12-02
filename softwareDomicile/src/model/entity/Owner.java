package model.entity;

public class Owner {
	
	private static int ID_GENERIC;
	private int id;
	private String name;
	private String password;
	private String img;

	public Owner(String name, String password, String img) {
		this.id = ID_GENERIC++;
		this.name = name;
		this.password = password;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return img;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", password=" + password + ", img=" + img + "]";
	}
	
}