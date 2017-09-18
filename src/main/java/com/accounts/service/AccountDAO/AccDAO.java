package com.accounts.service.AccountDAO;

import java.util.List;

import com.accounts.service.Accounts.Accounts;

public interface AccDAO {

	public List<Accounts> getAllAccounts();

	public Accounts getAccount(int accId);

	public void updateAccount(Accounts Accounts);

	public void deleteAccount(Accounts Accounts);
	
	public void addAccount(Accounts Accounts);
}
