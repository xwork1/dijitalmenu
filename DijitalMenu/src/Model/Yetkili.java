package Model;

public class Yetkili {
	
	private int id;
	String username,password,logged;
	
	
	public Yetkili(int id, String username, String password, String logged) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.logged = logged;
	}
	public Yetkili() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogged() {
		return logged;
	}
	public void setName(String logged) {
		this.logged = logged;
	}
	
	
	

}
