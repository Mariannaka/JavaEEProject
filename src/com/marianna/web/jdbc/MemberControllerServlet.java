package com.marianna.web.jdbc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * this class handles the initial request 
 * and talks to the utility and then sends it to the JSP
 */

/**
 * Servlet implementation class MemberControllerServlet
 */
@WebServlet("/MemberControllerServlet")
public class MemberControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * setting up a reference to MemberDbUtil
	 */
	private MemberDbUtil memberDbUtil;
	
	/**
	 * TomCat server will inject the connection pool object 
	 * and assign it to the DataSource object
	 */
	@Resource(name="jdbc/myvillage")
	private DataSource myDataSource;
	
	/**
	 * initializing MemberDbUtil by using init() method
	 * (overriding it to add some costume functionality to it)
	 * and that method will be called by the app 
	 * server when the servlet is initialized (first loaded)
	 * so normally the work that is done in a constructor,
	 * in Servlet we do it inside init() method.
	 * init() method method we inherit it from a generic method and then override it
	 */ 

	@Override
	public void init() throws ServletException {
		try {
			memberDbUtil = new MemberDbUtil(myDataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listMembers(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// get members from db util
		List<Member> myMembers = memberDbUtil.getMembers();
		
		
		// add members to the request
		//myMembers.add();
		request.setAttribute("MEMBER_LIST", myMembers);
		
		// send to jsp page (view)
		RequestDispatcher reqDis = request.getRequestDispatcher("/members-list.jsp");
		reqDis.forward(request, response);
	}

}
