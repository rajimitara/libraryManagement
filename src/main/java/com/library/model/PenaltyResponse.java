package com.library.model;

import java.util.Date;

public class PenaltyResponse {

	Date dueDate;
	
	long outstandingAmount;
	
	boolean backListed;

	public PenaltyResponse(Book studentDetails) {
		this.setDueDate(studentDetails.getDueDate());
	}

	public PenaltyResponse() {
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public long getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(long outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public boolean isBackListed() {
		return backListed;
	}

	public void setBackListed(boolean backListed) {
		this.backListed = backListed;
	}
	
	
}
