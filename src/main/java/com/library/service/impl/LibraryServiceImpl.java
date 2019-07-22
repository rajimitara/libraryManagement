package com.library.service.impl;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.exception.LibraryServiceException;
import com.library.model.Book;
import com.library.model.LendResponse;
import com.library.model.PenaltyResponse;
import com.library.model.Student;
import com.library.repository.BookRepository;
import com.library.repository.Ownership;
import com.library.repository.UserRepository;
import com.library.service.LibraryService;

@Component
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	public Ownership ownership;
	
	@Autowired
	public PenaltyTracking penaltyTracking;
	
	@Autowired
	public BookRepository bookRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	
	@Override
	public String registerBook(Book newBook) throws LibraryServiceException {
		bookRepository.updateBook(newBook.getBookId(),newBook);
		return "";
	}

	@Override
	public String registerUser(Student fresher) throws LibraryServiceException{
		userRepository.updateUser(fresher.getUserId(), fresher);
		return "";
	}

	@Override
	public PenaltyResponse executePenalty(String userId) throws LibraryServiceException{
		Book otherDetails = ownership.getLendBookList().get(userId);
		Book updatedDetails =  penaltyTracking.calculatePenalty(otherDetails,userRepository.getUser(userId));
		return penaltyTracking.createPenaltyResponse(updatedDetails);
	}

	public boolean verifyAuthorisedToTakeBooks(Student studentInfo) {
		if(!studentInfo.isBackListed() && studentInfo.getReadingList().size() < 2)
			return true;
		
		return false;
	}


	@Override
	public LendResponse borrowBook(String userId, String bookId) throws LibraryServiceException{
		Student studentInfo = userRepository.getUser(userId);
		ConcurrentHashMap<String, Book> borrowedBooks = studentInfo.getReadingList();
		if(verifyAuthorisedToTakeBooks(studentInfo)){
			//fetch bookDetails from 
			if(borrowedBooks==null)
				borrowedBooks = new ConcurrentHashMap<String, Book>();
			
			final Book bookDetails = bookRepository.getBook(bookId);
			borrowedBooks.put(bookId, bookDetails);
			//also update book is been borrowed.
			ownership.registerBookAgainstStudent(userId, bookDetails);
			return new LendResponse();
		}
		return new LendResponse("Not authorised");
		
	}

	
	

}
