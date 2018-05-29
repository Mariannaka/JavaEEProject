package com.marianna.web.jdbc.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.marianna.web.bean.Account;
import com.marianna.web.hibernate.HibernateUtil;



public class NewAccountDaoImpl implements NewAccountDao {
	
	public void saveNewAccount (Account myAccount) {
		
		Session mySession = HibernateUtil.getSessionFactory().getCurrentSession(); //or openSession()
		Transaction myTrans = mySession.beginTransaction();
	
		mySession.save(myAccount);
		myTrans.commit();
		mySession.close();
		
	}
	
	
	
	 @Override
	    public List<Account> showAllAccounts() {
	        List<Account> accountList = new ArrayList();
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Query query = session.createQuery("From Account");
	        accountList = query.list();
	        return accountList;
	    }


	  @Override
	    public void deleteAccount(Account myAccount) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	        session.delete(myAccount);
	        transaction.commit();
	        session.close();
	    }


}
