package com.hcl.banking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transcation")
public class Transcation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@OneToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="from_account")
	private Account fromAccount;
	@OneToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="to_account")
	private Account toAccount;
	@Column(name="amount")
	private int amount;
	@Column(name="transcation_date")
	private Date transcationDate;
	@Column(name="transcation_type")
	private String transcationType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getTranscationDate() {
		return transcationDate;
	}
	public void setTranscationDate(Date transcationDate) {
		this.transcationDate = transcationDate;
	}
	public String getTranscationType() {
		return transcationType;
	}
	public void setTranscationType(String transcationType) {
		this.transcationType = transcationType;
	}
	
}
