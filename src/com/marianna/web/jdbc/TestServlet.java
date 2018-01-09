package com.marianna.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Define datasource/connection pool for Resource injection
	
	@Resource(name="jdbc/myvillage")
	private DataSource dataSource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			String sql = "select * from orchestra_player";
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				String email = rs.getString("email");
				out.println(email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
