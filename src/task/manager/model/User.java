package task.manager.model;

import java.util.Date;

import task.manager.utility.PasswordUtility;

public class User {

	private String username;
	private String password;
	private Date timestampAccountCreated;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String planPassword) {
		this.password = PasswordUtility.encryptPassword(planPassword);
	}
	
	public String getPassword() {
		return password;
	}
	
	
	public void setTimestampAccountCreated(Date timestampAccountCreated) {
		this.timestampAccountCreated = timestampAccountCreated;
	}
	
	public Date getTimestampAccountCreated() {
		return timestampAccountCreated;
	}
	
}
