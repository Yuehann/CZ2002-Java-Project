
public class User {

	private String username;
	private String password;
	private String domain;
	
/*-------------------------constructor---------------------------- */	
// Creates a new User without specified attributes
	public User() {
		
	}
// Creates a new User with username, password, domain passed in
	public User(String username, String password, String domain) {
		this.username = username;
		this.password = password;
		this.domain = domain;
	}
	
/*-----------------------get&set attributes-------------------------- */
// Get and set username
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
// Get and set password
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
// Get and set domain
	public String getDomain() {
		return this.domain;
	}
	
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	
}
