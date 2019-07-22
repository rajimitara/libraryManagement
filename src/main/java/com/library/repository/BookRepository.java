package com.library.repository;

import java.util.concurrent.ConcurrentHashMap;

import com.library.model.Book;
import com.library.model.Student;

public class BookRepository {

	public ConcurrentHashMap<String, Book> bookDetailList = new ConcurrentHashMap<>();
	
	//findAll
	public ConcurrentHashMap<String, Book> getBookDetailList() {
		return bookDetailList;
	}

	public void setBookDetailList(ConcurrentHashMap<String, Book> bookDetailList) {
		this.bookDetailList = bookDetailList;
	}
	
	public Book getBook(String bookId){
		return bookDetailList.get(bookId);
	}
	
	public void updateBook(String bookId,Book book){
		bookDetailList.put(bookId, book); 
	}
}
