package com.library.model;

import org.springframework.beans.factory.annotation.Autowired;

public class LendResponse {

	@Autowired
	SequenceGenerator sequenceGenerator;
	
	public LendResponse() {
		super();
		this.message = "We have registered Book";
		this.grantRequest = true;
		sequenceGenerator.addOne();
		this.borrowRequestId = sequenceGenerator.get();
	}
	public LendResponse(String message) {
		super();
		this.message = "Failed to borrow book";
		this.grantRequest = false;
	}

	String message;
	boolean grantRequest;
	long borrowRequestId;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isGrantRequest() {
		return grantRequest;
	}
	public void setGrantRequest(boolean grantRequest) {
		this.grantRequest = grantRequest;
	}
	public long getBorrowRequestId() {
		return borrowRequestId;
	}
	public void setBorrowRequestId(long borrowRequestId) {
		this.borrowRequestId = borrowRequestId;
	}
	
	
	
}
