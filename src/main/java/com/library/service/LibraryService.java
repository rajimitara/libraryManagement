package com.library.service;

import com.library.exception.LibraryServiceException;
import com.library.model.Book;
import com.library.model.LendResponse;
import com.library.model.PenaltyResponse;
import com.library.model.Student;

public interface LibraryService {

	String registerBook(Book newBook)throws LibraryServiceException;;
	String registerUser(Student fresher)throws LibraryServiceException;;
	PenaltyResponse executePenalty(String userId) throws LibraryServiceException;
	LendResponse borrowBook(String userId, String bookId)throws LibraryServiceException;;
}
