package com.marianna.web.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * @author marianna
 * DAO class (Data Access Object)
 * this class is used when interacting with a database
 */


public class AccountLoginDao {
		
	String url = "jdbc:mysql://localhost:3306/myvillage";
	String username = "myvillageuser";
	String password = "myvillage11";
	String sql = "select * from account where user_name=? and user_password=?";
	
	public boolean checkStatus(String accountUsername, String accountPass) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, accountUsername);
			st.setString(2, accountPass);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}
