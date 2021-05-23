package model;

public class Profile {
	
	private int id;
	private long userId;
	private String firstName;
	private String lastName;
	private String email;
	private int recent_parameters_id;
	private int watchlist_id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRecent_parameters_id() {
		return recent_parameters_id;
	}
	public void setRecent_parameters_id(int recent_parameters_id) {
		this.recent_parameters_id = recent_parameters_id;
	}
	public int getWatchlist_id() {
		return watchlist_id;
	}
	public void setWatchlist_id(int watchlist_id) {
		this.watchlist_id = watchlist_id;
	}

}
