package com.marianna.web.jdbc.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
