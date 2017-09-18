package com.accounts.service.Accounts;

import java.util.Date;

public class Accounts {

	private int accId;
	private String accHolderName;
	private double accBalance;
	private Date dateCreated;
	
	public Accounts(){}

	public Accounts(int accId, String accHolderName, double accBalance, Date dateCreated) {
		this.accId=accId;
		this.accHolderName=accHolderName;
		this.accBalance=accBalance;
		this.dateCreated=dateCreated;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
