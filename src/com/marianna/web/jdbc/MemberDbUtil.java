package com.marianna.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class MemberDbUtil {
	
	private DataSource myDataSource;
	
	public MemberDbUtil(DataSource dataSource) {
		this.myDataSource = dataSource;
	}

	public List<Member> getMembers() throws Exception {

		List<Member> members = new ArrayList<>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// get connection
			con = myDataSource.getConnection();

			// create statement
			String sql = "select * from orchestra_player";
			st = con.createStatement();

			// execute query
			rs = st.executeQuery(sql);

			// process resultSet
			while (rs.next()) {

				// get resultset row
				//int id = rs.getInt("id");
				String fullName = rs.getString("full_name");
				String email = rs.getString("email");
				String nationality = rs.getString("nationality");
				String title = rs.getString("title");

				// create new member object for each rs row
				Member myMembers = new Member(fullName, email, title, nationality);

				// save them in the member List
				members.add(myMembers);
			}

			return members;
		} 
		finally {
			// close connection
			close(con, rs, st);
		}
	}

	private void close(Connection con, ResultSet rs, Statement st) {

		try {
			/**
			 * this doesn't actually close the connection
			 * it just put it back in the connection pool again
			 * and make it available for someone else to use
			 * and this is important to use in a bigger/productive projects
			 */
			if (con != null) {
				con.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
