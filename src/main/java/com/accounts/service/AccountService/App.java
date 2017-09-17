package com.accounts.service.AccountService;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    Accounts getAllAccounts() {
        return new Accounts(1,"Tanay Shankar",1200.0,new Date());
    }
}