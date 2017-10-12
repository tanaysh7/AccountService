package com.accounts.service.AccountDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import com.accounts.service.Accounts.AccountStatus;
import com.accounts.service.Accounts.Accounts;


/**
 * @author Tanay Shankar on 22-Sep-2017
 *
 */

public class AccDAOImpl implements AccDAO {
	
  	
  	public static RedissonClient createClient() {
  		final Config config;
  		config = new Config();
  		config.useSingleServer().setAddress("redis://127.0.0.1:6379");
  		return Redisson.create(config);
  	}
  	 	

	
	public AccDAOImpl(){	
		/*
		RedissonClient client = createClient();
		RBucket<List<Accounts>> bucket = client.getBucket("accounts");
		List<Accounts> next=new ArrayList<Accounts>();
		next.add( new Accounts(1,"Tanay Shankar",10000.0,new Date()));
		next.add( new Accounts(2,"Steve Jobs",20000.0,new Date()));
		bucket.set(next);*/
}
	@Override
	public List<Accounts> getAllAccounts() {
		RedissonClient client = createClient();
		RBucket<List<Accounts>> bucket = client.getBucket("accounts");
		return (List<Accounts>) bucket.get();
	}

	@Override
	public Accounts getAccount(int accId) {
		
		RedissonClient client = createClient();
		RBucket<List<Accounts>> bucket = client.getBucket("accounts");
		return bucket.get().stream().filter(i->i.getAccId()==accId).collect(Collectors.toList()).get(0);
	}

	@Override
	public void updateAccount(Accounts Accounts) {
		RedissonClient client = createClient();
		RBucket<List<Accounts>> bucket = client.getBucket("accounts");
		List<Accounts> next = new ArrayList<Accounts>();
		next = bucket.get().stream().filter(i->i.getAccId()!=Accounts.getAccId()).collect(Collectors.toList());
		next.add(Accounts);
		bucket.set(next);
	}

	@Override
	public void deleteAccount(Accounts Accounts) {
		RedissonClient client = createClient();
		RBucket<List<Accounts>> bucket = client.getBucket("accounts");
		bucket.set(bucket.get().stream().filter(i->i.getAccId()!=Accounts.getAccId()).collect(Collectors.toList()));
		
	}
	@Override
	public void addAccount(Accounts Accounts) {
		RedissonClient client = createClient();
		RBucket<List<Accounts>> bucket = client.getBucket("accounts");
		List<Accounts> next = new ArrayList<Accounts>();
		next=bucket.get();
		if(next.stream().filter(i->i.getAccId()==Accounts.getAccId()).collect(Collectors.toList()).size()!=0)
		next.add(Accounts);
		bucket.set(next);
		
	}



	/* (non-Javadoc)
	 * @see com.accounts.service.AccountDAO.AccDAO#getStatus()
	 */
	@Override
	public AccountStatus getStatus() {
		RedissonClient client = createClient();
		RBucket<List<Accounts>> bucket = client.getBucket("accounts");
		List<Accounts> all= bucket.get();
		return new AccountStatus((double) all.size(), all.stream().mapToDouble(a -> a.getAccBalance()).average().getAsDouble(),all.stream().mapToDouble(a -> a.getAccBalance()).average().getAsDouble(), all.stream().mapToDouble(a -> a.getAccBalance()).average().getAsDouble(), all.stream().mapToDouble(a -> a.getAccBalance()).average().getAsDouble());
	}

}
