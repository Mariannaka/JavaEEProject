package com.marianna.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marianna.web.bean.Account;
import com.marianna.web.jdbc.dao.NewAccountDao;
import com.marianna.web.jdbc.dao.NewAccountDaoImpl;

/**
 * Servlet implementation class NewAccountController
 */
@WebServlet("/NewAccountController")
public class NewAccountController extends HttpServlet {

	Account myAccount = new Account();
	NewAccountDaoImpl myAccountDaoImpl = new NewAccountDaoImpl();
	NewAccountDao myNewAccountDao;

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in the method");
		
		String addAccount = request.getParameter("addAccount");
		
		if ( addAccount != null) {
			
			System.out.println("in if state");

			String userName = request.getParameter("user_name");
			String userPass = request.getParameter("user_pass");
			
			myAccount.setUserName(userName);
			myAccount.setUserPass(userPass);
			myAccountDaoImpl.saveNewAccount(myAccount);

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

			rd.forward(request, response);
			//response.sendRedirect("index.jsp");

			
		System.out.println("name is: " + myAccount.getUserName());

		}
	}
	
	
	
	  @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	         if(request.getParameter("showAccounts")!=null){
	            List<Account> accountList = new ArrayList<>();
	            accountList = myAccountDaoImpl.showAllAccounts();
	            request.setAttribute("accountList", accountList);
	            RequestDispatcher rd = request.getRequestDispatcher("showAllAccounts.jsp");
	            rd.forward(request, response);
	        }
	  }
	
	
	
	
	
	
	
	
}
	

