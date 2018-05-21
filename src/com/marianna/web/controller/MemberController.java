package com.marianna.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.marianna.web.bean.Member;
import com.marianna.web.jdbc.MemberDbUtil;
import com.marianna.web.jdbc.dao.AccountLoginDao;

/**
 * this class handles the initial request 
 * and talks to the utility and then sends it to the JSP
 */

@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * setting up a reference to MemberDbUtil
	 */
	private MemberDbUtil memberDbUtil;

	
	/**
	 * TomCat server will inject the connection pool object 
	 * and assign it to the DataSource object
	 * and we that with the help of @Resource annotation.
	 * Provide the same resource name as it is in context.xml file
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
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
			try {
				
				//get the command parameter from new-member-form.jsp
				String myCommand = request.getParameter("command");
				
				//if the command is empty, then list the default list
				if(myCommand == null) {
					myCommand = "LIST";
				}
				
				switch (myCommand) {
				
				case "LIST" :
					listMembers(request, response);
					break;
					
				case "ADD" :
					addMembers(request, response);
					break;
					
				case "LOAD":
					loadMember(request, response);
					break;
					
				case "UPDATE":
					updateMember(request, response);
					break;
					
				case "DELETE":
					deleteMember(request, response);
					break;
					
				default : 
						listMembers(request, response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

	}
	
	
	
	private void deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String memberId = request.getParameter("memberId");
		
		memberDbUtil.deleteMember(memberId);
		
		listMembers(request, response);
	}

	private void updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("memberId"));
		String fullName = request.getParameter("full-name");
		String email =request.getParameter("email") ;
		String nationality = request.getParameter("nationality");
		String title = request.getParameter("title") ;
		
		Member myMember = new Member (id, fullName, email, title, nationality);
		
		memberDbUtil.updateMember(myMember);
		
		listMembers(request, response);
		
		
	}

	private void loadMember(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String memberId = request.getParameter("memberId");
		Member myMember = memberDbUtil.getMember(memberId);
		//place the member in request attribute
		request.setAttribute("THE_MEMBER", myMember);
		response.setContentType("text/html");
		RequestDispatcher reqDis = request.getRequestDispatcher("/edit-member-form.jsp");
		reqDis.forward(request, response);
		  
	}

	/**
	 * This method will read data from new-member-form.jsp and create
	 * a new member object using the same data as parameters for the new object.
	 * Then save the new object in our database,
	 * then list it on our existing list and display it to the user 
	 * @throws Exception 
	 */

	private void addMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//1.read data from the form
		int id = Integer.parseInt(request.getParameter("id"));
		String fullName = request.getParameter("full-name");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String nationality = request.getParameter("nationality");

		//2.create new member object
		Member newMember = new Member(fullName, email, title, nationality);
		
		//3.save the new object in database
		memberDbUtil.addMember(newMember);
		
		//4.display/send that data in the list
		listMembers(request, response);
	}

	private void listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// get members from db util
		List<Member> myMembers = memberDbUtil.getMembers();
		
		
		// add members to the request
		request.setAttribute("MEMBER_LIST", myMembers);
		
		// send to jsp page (view)
		RequestDispatcher reqDis = request.getRequestDispatcher("/members-list.jsp");
		reqDis.forward(request, response);
	}

}
