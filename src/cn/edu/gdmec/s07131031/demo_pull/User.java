package cn.edu.gdmec.s07131031.demo_pull;

public class User {
	private int id;
	private String name;
	private String password;
	protected User() {
		super();
	}
	protected User(int did, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int did) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [did=" + id + ", name=" + name + ", password=" + password
				+ "]";
	}
	

}
