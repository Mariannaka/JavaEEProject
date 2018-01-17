package com.marianna.web.jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marianna.web.jdbc.dao.AccountLoginDao;

@WebServlet("/AccountLoginServlet")
public class AccountLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountLoginDao myAccount = new AccountLoginDao();
		String myUser = request.getParameter("user");
		String myPass = request.getParameter("pass");
		
		HttpSession mySession = request.getSession();
		mySession.setAttribute("mySessionUser", myUser);
		
		//check if the user is inloged
		if (myAccount.checkStatus(myUser, myPass)) {
			response.sendRedirect("MemberControllerServlet");
			
		} else {
			response.sendRedirect("indexing.jsp");
		}
	}

}
