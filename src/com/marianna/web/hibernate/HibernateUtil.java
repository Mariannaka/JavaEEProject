package com.marianna.web.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.marianna.web.bean.Account;

public class HibernateUtil {
	
	private static final SessionFactory mySessionFactory; 
	
	static {
		try {
			mySessionFactory = new Configuration()
					.configure("/resource/hibernate.cfg.xml")
					.addAnnotatedClass(Account.class)
					.buildSessionFactory();
			
		} catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}
	
	public static SessionFactory getSessionFactory() {
        return mySessionFactory;
    }
}
