package com.tka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  customerId;
	
	private String customerName;
	private String accountNumber;
	private double customerBalance;
	private String customerLoanType;
	
	
	public CustomerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerInfo(String customerName, String accountNumber, double customerBalance, String customerLoanType) {
		super();
		this.customerName = customerName;
		this.accountNumber = accountNumber;
		this.customerBalance = customerBalance;
		this.customerLoanType = customerLoanType;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getCustomerBalance() {
		return customerBalance;
	}


	public void setCustomerBalance(double customerBalance) {
		this.customerBalance = customerBalance;
	}


	public String getCustomerLoanType() {
		return customerLoanType;
	}


	public void setCustomerLoanType(String customerLoanType) {
		this.customerLoanType = customerLoanType;
	}


	@Override
	public String toString() {
		return "CustomerInfo [customerId=" + customerId + ", customerName=" + customerName + ", accountNumber="
				+ accountNumber + ", customerBalance=" + customerBalance + ", customerLoanType=" + customerLoanType
				+ "]";
	}
	
	
	
	
	
	

}
