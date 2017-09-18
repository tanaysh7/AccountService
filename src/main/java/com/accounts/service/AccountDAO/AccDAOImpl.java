package com.accounts.service.AccountDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.accounts.service.Accounts.Accounts;

public class AccDAOImpl implements AccDAO {

	List<Accounts> k=new ArrayList<Accounts>();
	public AccDAOImpl(){	
	k.add( new Accounts(1,"Tanay Shankar",10000.0,new Date()));
	k.add( new Accounts(2,"Steve Jobs",20000.0,new Date()));
}
	@Override
	public List<Accounts> getAllAccounts() {
		
		return k;
	}

	@Override
	public Accounts getAccount(int accId) {
		
		return  k.get(accId-1);
	}

	@Override
	public void updateAccount(Accounts Accounts) {
		Accounts changed=k.get(Accounts.getAccId()-1);
		changed.setAccBalance(Accounts.getAccBalance());
		changed.setAccHolderName(Accounts.getAccHolderName());
		changed.setDateCreated(Accounts.getDateCreated());
	}

	@Override
	public void deleteAccount(Accounts Accounts) {
		k.remove(Accounts.getAccId()-1);
		
	}
	@Override
	public void addAccount(Accounts Accounts) {
		k.add(Accounts);
		
	}

}
