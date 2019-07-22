package com.library.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Student {
	
	private String userId;
	
	long penaltyInRupees;
	
	Date penaltyTillDate;
	
	boolean backListed;
	
	//bookId,books
	ConcurrentHashMap<String, Book> readingList = new ConcurrentHashMap<>(2);
	
	//bookId,books
	Map<String,Book> historyOfBooks = new LinkedHashMap<>();
	
	public long getPenaltyInRupees() {
		return penaltyInRupees;
	}

	public void setPenaltyInRupees(long penaltyInRupees) {
		this.penaltyInRupees = penaltyInRupees;
	}

	public boolean isBackListed() {
		return backListed;
	}

	public void setBackListed(boolean backListed) {
		this.backListed = backListed;
	}

	public Date getPenaltyTillDate() {
		return penaltyTillDate;
	}

	public void setPenaltyTillDate(Date penaltyTillDate) {
		this.penaltyTillDate = penaltyTillDate;
	}

	

	public ConcurrentHashMap<String, Book> getReadingList() {
		return readingList;
	}

	public void setReadingList(ConcurrentHashMap<String, Book> readingList) {
		this.readingList = readingList;
	}

	public Map<String, Book> getHistoryOfBooks() {
		return historyOfBooks;
	}

	public void setHistoryOfBooks(Map<String, Book> historyOfBooks) {
		this.historyOfBooks = historyOfBooks;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
