package com.marianna.web.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="user_account")
public class Account implements Serializable {
	
	@Id
	@Column (name="user_id")
	private int userId;

	@Column (name="user_name")
	private String userName;
	
	@Column (name="user_password")
	private String userPass;
	
	public Account() {
		
	}
	
	
	public Account(String userName, String userPass) {
		super();
		this.userName = userName;
		this.userPass = userPass;
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


	@Override
	public String toString() {
		return "Account [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + "]";
	}


}
