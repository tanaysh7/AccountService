package com.accounts.service.AccountDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import com.accounts.service.Accounts.Accounts;


public class AccDAOImpl implements AccDAO {
	
  	
  	public static RedissonClient createClient() {
  		final Config config;
  		config = new Config();
  		config.useSingleServer().setAddress("redis://127.0.0.1:6379");
  		return Redisson.create(config);
  	}
  	 	

	List<Accounts> k=new ArrayList<Accounts>();//TODO Remove and replace
	public AccDAOImpl(){	
		
		RedissonClient client = createClient();
		RBucket<List<Accounts>> bucket = client.getBucket("accounts");
		List<Accounts> k=new ArrayList<Accounts>();
		k.add( new Accounts(1,"Tanay Shankar",10000.0,new Date()));
		k.add( new Accounts(2,"Steve Jobs",20000.0,new Date()));
		bucket.set(k);
}
	@Override
	public List<Accounts> getAllAccounts() {
		RedissonClient client = createClient();
		RBucket<List<Accounts>> bucket = client.getBucket("accounts");
		return (List<Accounts>) bucket.get();
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
