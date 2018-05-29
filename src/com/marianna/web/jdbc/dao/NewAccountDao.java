package com.marianna.web.jdbc.dao;

import java.util.List;

import com.marianna.web.bean.Account;

public interface NewAccountDao {
	
	public List<Account> showAllAccounts();
	public void saveNewAccount (Account myAccount);
	public void deleteAccount (Account myAccount);
}
