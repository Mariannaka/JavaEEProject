package com.marianna.web.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.marianna.web.bean.Account;

public class CreateAccount {
	
	public static void main (String [] args) {
		
		SessionFactory mySessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Account.class).buildSessionFactory();
		
		Session mySession = mySessionFactory.getCurrentSession();
		
		try {
				
			
		} finally {
			mySessionFactory.close();
		}
	}

}
