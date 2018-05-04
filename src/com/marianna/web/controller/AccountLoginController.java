package com.marianna.web.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marianna.web.jdbc.dao.AccountLoginDao;

/** 
 * @author marianna
 * A servlet class which is going to handle the initial request
 * and talk to the utility (MemberDbUtil.java) and send it to a jsp 
 */

@WebServlet("/AccountLoginController")
public class AccountLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountLoginDao myAccount = new AccountLoginDao();
		String myUser = request.getParameter("user");
		String myPass = request.getParameter("pass");
		
		HttpSession mySession = request.getSession();
		mySession.setAttribute("mySessionUser", myUser);
		
		//check if the user is in-logged 
		if (myAccount.checkStatus(myUser, myPass)) {
			response.sendRedirect("MemberController");
			
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
