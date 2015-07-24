package main;

public class User {
	private int id;
	private String name;
	private String email;

	public User(int id, String name, String email) {
		this.setName(name);
		this.setId(id);
		this.setEmail(email);
	}

	/**
	 * Get method for id.
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set method for id.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 *  Set method for name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set method for name.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * Get method for email.
 * @return string
 */
	public String getEmail() {
		return email;
	}
/** 
 * Set method for email.
 * @param email
 */
	public void setEmail(String email) {
		this.email = email;
	}

	
}