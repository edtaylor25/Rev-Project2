package com.demo.ersSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="request_info")
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="request_id")
	private int id=0;
	@Column(name="user_id")
	private int userId=0;
	@Column(name="date")
	private String date="";
	@Column(name="amount")
	private int amount=0;
	@Column(name="status")
	private String status="";
	@Column(name="expense_type")
	private String expenseType="";
	
	
	public Request(int id,int uID, String date, int amount, String status) {
		this.id=id;
		this.userId = uID;
		this.date = date;
		this.amount=amount;
		this.status = status;
	}
	
	public Request(int uID, String date, int amount, String status) {
		this.userId = uID;
		this.date = date;
		this.amount=amount;
		this.status = status;
	}
	public Request(int id,int uID, String date, int amount, String status, String expenseType) {
		this.id=id;
		this.userId = uID;
		this.date = date;
		this.amount=amount;
		this.status = status;
		
	}
	
	public Request() {
		
	}
	
	
	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getAmount() {
		return this.amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return "BookPojo [requestId=" + id + ", userId=" + userId + ", date=" + date + ", amount="
				+ amount + ", status=" + status + "]";
	}
	
}