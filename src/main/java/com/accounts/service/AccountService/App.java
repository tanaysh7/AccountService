package com.accounts.service.AccountService;
import java.util.Date;
import java.util.List;

/**
 * @author Tanay Shankar on 22-Sep-2017
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.service.AccountDAO.AccDAO;
import com.accounts.service.AccountDAO.AccDAOImpl;
import com.accounts.service.Accounts.AccountStatus;
import com.accounts.service.Accounts.Accounts;

@SpringBootApplication
@RestController
public class App {
	
	
    public static void main(String[] args) {
    	
  
        SpringApplication.run(App.class, args);
    }

    @RequestMapping(value = "/")
    String hello() {
        return "Hello, welcome to AccountService";
    }
    
    @RequestMapping(value = "/accounts")
    List<Accounts> getAllAccounts() {
    	AccDAO AccData = new AccDAOImpl();
    	return AccData.getAllAccounts();
    }
    
    @RequestMapping(value = "/account/{id}")
    Accounts getAccount(@PathVariable("id") int id) {
    	AccDAO AccData = new AccDAOImpl();
    	return AccData.getAccount(id);
    }
    
    @RequestMapping(value = "/status")
    AccountStatus getStatus() {
    	AccDAO AccData = new AccDAOImpl();
    	return AccData.getStatus();
    }
}