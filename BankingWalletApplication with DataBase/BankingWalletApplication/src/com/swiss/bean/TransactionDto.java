package com.swiss.bean;

public class TransactionDto {
	
	private int userId;
	private String transactionTime;
	private String transactionType;
	private int withdrawlAmount;
	private int depositAmount;
	private int balance;
	private String accountNo;
	private int transactionSequence;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getWithdrawlAmount() {
		return withdrawlAmount;
	}
	public void setWithdrawlAmount(int withdrawlAmount) {
		this.withdrawlAmount = withdrawlAmount;
	}
	public int getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getTransactionSequence() {
		return transactionSequence;
	}
	public void setTransactionSequence(int transactionSequence) {
		this.transactionSequence = transactionSequence;
	}
	public String getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
