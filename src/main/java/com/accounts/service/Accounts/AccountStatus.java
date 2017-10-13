/**
 * 
 */
package com.accounts.service.Accounts;

/**
 * @author Tanay Shankar on 13-Oct-2017
 *
 */
public class AccountStatus {

	int totalCustomers;
	double totalBal;
	double avgBal;
	double interestRate;
	double minCashAvail;
	
	/**
	 * @param totalCustomers
	 * @param totalBal
	 * @param avgBal
	 * @param interestRate
	 * @param minCashAvail
	 */
	public AccountStatus(int totalCustomers, double totalBal, double avgBal, double interestRate,
			double minCashAvail) {
		super();
		this.totalCustomers = totalCustomers;
		this.totalBal = totalBal;
		this.avgBal = avgBal;
		this.interestRate = interestRate;
		this.minCashAvail = minCashAvail;
	}
	public int getTotalCustomers() {
		return totalCustomers;
	}
	public void setTotalCustomers(int totalCustomers) {
		this.totalCustomers = totalCustomers;
	}
	public double getTotalBal() {
		return totalBal;
	}
	public void setTotalBal(double totalBal) {
		this.totalBal = totalBal;
	}
	public double getAvgBal() {
		return avgBal;
	}
	public void setAvgBal(double avgBal) {
		this.avgBal = avgBal;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getMinCashAvail() {
		return minCashAvail;
	}
	public void setMinCashAvail(double minCashAvail) {
		this.minCashAvail = minCashAvail;
	}
}
