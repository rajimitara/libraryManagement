package com.library.repository;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.library.model.Book;
import com.library.model.Student;

@Component
public class Ownership {

	/**
	 * Library register containing each book against userId
	 */
	public ConcurrentHashMap<String, Book> lentBookList = new ConcurrentHashMap<>();

	
	public ConcurrentHashMap<String, Book> getLendBookList() {
		return lentBookList;
	}

	public void setLendBookList(ConcurrentHashMap<String, Book> lendBookList) {
		this.lentBookList = lendBookList;
	}
	
	public void registerBookAgainstStudent(String userId,Book book){
		lentBookList.put(userId, book);
	}
	
	
	
	
}
