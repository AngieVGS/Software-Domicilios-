package model.entity;

public class User {
	private int id;
	private String name;
	private String password;
	private boolean state;
	private static int ID_GENERIC = 0;

	public User(String name, String password, boolean state) {
		this.id = ID_GENERIC++;
		this.name = name;
		this.password = password;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public boolean isState() {
		return state;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User {id=" + id + ", name=" + name + ", password=" + password + ", state=" + state + "}";
	}
}