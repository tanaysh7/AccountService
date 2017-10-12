/**
 * 
 */
package com.accounts.service.Accounts;

/**
 * @author Tanay Shankar on 13-Oct-2017
 *
 */
public class AccountStatus {

	Double totalCustomers;
	Double totalBal;
	Double avgBal;
	Double interestRate;
	Double minCashAvail;
	
	public Double getTotalCustomers() {
		return totalCustomers;
	}
	public void setTotalCustomers(Double totalCustomers) {
		this.totalCustomers = totalCustomers;
	}
	public Double getTotalBal() {
		return totalBal;
	}
	public void setTotalBal(Double totalBal) {
		this.totalBal = totalBal;
	}
	public Double getAvgBal() {
		return avgBal;
	}
	public void setAvgBal(Double avgBal) {
		this.avgBal = avgBal;
	}
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	public Double getMinCashAvail() {
		return minCashAvail;
	}
	public void setMinCashAvail(Double minCashAvail) {
		this.minCashAvail = minCashAvail;
	}
}
