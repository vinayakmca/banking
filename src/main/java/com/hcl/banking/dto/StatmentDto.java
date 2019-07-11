package com.hcl.banking.dto;

import java.util.Date;

public class StatmentDto {

	private String fromAccount;
	private String toAccount;
	private Date  transactionDate;
	private int amount;
	private String transactionType;
	
	public StatmentDto(String fromAccount, String toAccount, Date transactionDate, int amount, String transactionType) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionType = transactionType;
	}
	
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
}
