package com.marianna.web.bean;

public class Account {
	
	private String userName;
	private String userPass;
	private int userId;
	
	
	public Account(String userName, String userPass, int userId) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.userId = userId;
	}
	
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPass() {
		return userPass;
	}
	
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	

}
