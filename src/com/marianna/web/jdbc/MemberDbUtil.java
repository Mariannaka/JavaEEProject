package com.marianna.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.marianna.web.bean.Member;

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
			st = con.createStatement();

			// execute query
			String sql = "select * from orchestra_player";
			rs = st.executeQuery(sql);

			// process resultSet
			while (rs.next()) {

				// get resultset row
				int id = rs.getInt("id");
				String fullName = rs.getString("full_name");
				String email = rs.getString("email");
				String nationality = rs.getString("nationality");
				String title = rs.getString("title");

				// create new member object for each rs row
				Member myMembers = new Member(id, fullName, email, title, nationality);

				// save them in the member List
				members.add(myMembers);
			}

			return members;
		} finally {
			// close connection
			close(con, rs, st);
		}
	}

	private void close(Connection con, ResultSet rs, Statement st) {

		try {
			/**
			 * this doesn't actually close the connection it just put it back in the
			 * connection pool again and make it available for someone else to use and this
			 * is important to use in a bigger/productive projects
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

	
	public void addMember(Member newMember) throws Exception {

		Connection myConnection = null;
		PreparedStatement myPreStatement = null;

		try {
			myConnection = myDataSource.getConnection();

			String mySql = "insert into orchestra_player (full_name, email, title, nationality)"
					+ "values (?, ?, ?, ?)";
			myPreStatement = myConnection.prepareStatement(mySql);

			// set the parameter values for the member
			myPreStatement.setString(1, newMember.getFullName());
			myPreStatement.setString(2, newMember.getEmail());
			myPreStatement.setString(3, newMember.getTitle());
			myPreStatement.setString(4, newMember.getNationality());

			// execute the "insert" request
			myPreStatement.execute();
		}

		finally {

			close(myConnection, null, myPreStatement);
		}

	}

	public Member getMember(String memberId) throws Exception {

		Member myMember = null;
		Connection myCon = null;
		PreparedStatement myPreSt = null;
		ResultSet myResultSet = null;
		int myMemberId;

		try {

			myMemberId = Integer.parseInt(memberId);
			myCon = myDataSource.getConnection();
			String mySql = "select * from orchestra_player where id=?";
			myPreSt = myCon.prepareStatement(mySql);
			myPreSt.setInt(1, myMemberId);
			myResultSet = myPreSt.executeQuery();  
			if (myResultSet.next()) {
				String fullName = myResultSet.getString("full_name");
				String email = myResultSet.getString("email");
				String nationality = myResultSet.getString("nationality");
				String title = myResultSet.getString("title");
				myMember = new Member(myMemberId, fullName, email, title, nationality);
			} 
			
			else {
				throw new Exception("Error: couldn't find student: " + myMemberId);
			}

			return myMember;
			
		} finally {
			close(myCon, myResultSet, myPreSt);

		}
	}

	public void updateMember(Member myMember) throws Exception {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
		con = myDataSource.getConnection();
		String mySql = "UPDATE orchestra_player set full_name=?, email=?, title=?, nationality=? where id=? ";
		
		st = con.prepareStatement(mySql);
		st.setString(1, myMember.getFullName());
		st.setString(2, myMember.getEmail());
		st.setString(3, myMember.getTitle());
		st.setString(4, myMember.getNationality());
		st.setInt(5, myMember.getId());
		st.execute();	
	} 
		finally {
		
		close(con, rs, st);
	}
	
	}

	public void deleteMember(String memberId) throws Exception{
		
		Connection myConnection = null;
		PreparedStatement myPreStatement = null;
		int myMemberId;

		try {
			
			myMemberId = Integer.parseInt(memberId);
			myConnection = myDataSource.getConnection();
			String mySql= "delete from orchestra_player where id=?";
			myPreStatement = myConnection.prepareStatement(mySql);
			myPreStatement.setInt(1, myMemberId);
			myPreStatement.execute();
		}
		
		finally {
			
			close(myConnection, null , myPreStatement);
		}
		
		
		
	}
	
	
	
}















