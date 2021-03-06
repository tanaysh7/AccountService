package com.accounts.service.Tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Test;
import com.accounts.service.AccountDAO.AccDAOImpl;
import com.accounts.service.Accounts.Accounts;

/**
 * @author Tanay Shankar on 22-Sep-2017
 *
 */


public class TestDAO {
	
	AccDAOImpl tester = new AccDAOImpl();
	
	
	@Test 
	public void testAdd(){
		 
		tester.addAccount(new Accounts(100,"Test Name",20000.0,new Date()));
		assertNotNull(tester.getAccount(100));
	}
	
		
	@Test 
	public void testUpdate(){
		 
		tester.updateAccount(new Accounts(100,"Test Name",0.0,new Date()));
		assertEquals((int)tester.getAccount(100).getAccBalance(), 0);
	}
	
	@Test
	public void testDelete(){
		
		 tester.deleteAccount(new Accounts(100,"Test Name",0.0,new Date()));
		 assertNotEquals(tester.getAllAccounts().get(tester.getAllAccounts().size()-1), 100);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testStatus(){
		
		 assertNotNull((tester.getStatus()));
		 assertEquals(tester.getAllAccounts().size(), tester.getStatus().getTotalCustomers());

	}
	
	@After
	public void Cleanup() {
		tester.deleteAccount(new Accounts(100,"Test Name",0.0,new Date()));	
		tester=null;
	}
	
	
	
	
}
