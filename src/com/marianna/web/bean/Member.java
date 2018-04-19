
package com.marianna.web.bean;

/**
 * 
 * @author marianna
 * A bean class to create new objects of "member" type
 * which represent the orchestra members.
 *
 */

public class Member {
	private int id;
	private String fullName;
	private String email;
	private String title;
	private String nationality;
	
	/**
	 * 
	 * @param fullName
	 * @param email
	 * @param title
	 * @param nationality
	 */
	
	
	
	public Member(String fullName, String email, String title, String nationality) {
		this.fullName = fullName;
		this.email = email;
		this.title = title;
		this.nationality = nationality;
	}


	public Member(int id, String fullName, String email, String title, String nationality) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.title = title;
		this.nationality = nationality;
	}


	public int getId() {
		return id;
	}

	/*
	 * public void setId(int id) {
		this.id = id;
		}
	 */
	

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	//toString() method for debugging/logging issues
	@Override
	public String toString() {
		return "Member [fullName=" + fullName + ", email=" + email + ", title=" + title
				+ ", nationality=" + nationality + "]";
	}
	
}
