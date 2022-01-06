package com.demo.ersSpring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class RequestPojo {
	
	
	private int id=0;
	private int userId=0;
	private String date="";
	private int amount=0;
	private String status="";
	private String expenseType="";
	private String imageId;
	
	public RequestPojo(int id,int uID, String date, int amount, String status) {
		this.id=id;
		this.userId = uID;
		this.date = date;
		this.amount=amount;
		this.status = status;
	}
	
	public RequestPojo(int uID, String date, int amount, String status) {
		this.userId = uID;
		this.date = date;
		this.amount=amount;
		this.status = status;
	}
	
	public RequestPojo(int id,int uID, String date, int amount, String status, String expenseType, String imageId) {
		this.id=id;
		this.userId = uID;
		this.date = date;
		this.amount=amount;
		this.status = status;
		this.imageId = imageId;
	}
	
	public RequestPojo() {
		
	}
	
	
	public String getExpenseType() {
		return expenseType;
	}

	
	@Value("injury")
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getImageId() {
		return this.imageId;
	}

	@Value("0")
	public void setImageUrl(String imageId) {
		this.imageId = imageId;
	}

	@Value("88")
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	@Value("88")
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getDate() {
		return this.date;
	}
	
	@Value("TEST")
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	@Value("-1")
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	@Value("Pending")
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return "BookPojo [requestId=" + id + ", userId=" + userId + ", date=" + date + ", amount="
				+ amount + ", status=" + status + "]";
	}
	
}
