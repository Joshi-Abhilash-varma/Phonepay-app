package com.phonepay.demo.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FundTransfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long fundTransferId;
	
	private String fromMobileNumber;
	
	private String toMobileNumber;
	
	private double amount;
	
	private String comments;
	
	private LocalDateTime transactionDate;

	public long getFundTransferId() {
		return fundTransferId;
	}

	public void setFundTransferId(long fundTransferId) {
		this.fundTransferId = fundTransferId;
	}

	public String getFromMobileNumber() {
		return fromMobileNumber;
	}

	public void setFromMobileNumber(String fromMobileNumber) {
		this.fromMobileNumber = fromMobileNumber;
	}

	public String getToMobileNumber() {
		return toMobileNumber;
	}

	public void setToMobileNumber(String toMobileNumber) {
		this.toMobileNumber = toMobileNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
