package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.exception.EnumBase.ErrorCode;
import com.library.exception.LibraryServiceException;
import com.library.model.Book;
import com.library.model.LendResponse;
import com.library.model.PenaltyResponse;
import com.library.service.LibraryService;

@RestController
public class LibraryAdministration {

	@Autowired
	LibraryService libraryService;
	
	@GetMapping(value="/v1/lend/{userId}/{bookId}")
	public ResponseEntity<LendResponse> lendBook(@RequestParam String userId, @RequestParam String bookId){
		try{
			return new ResponseEntity<>(libraryService.borrowBook(userId,bookId),HttpStatus.OK);
		}catch(LibraryServiceException e){
			return new ResponseEntity<>(new LendResponse(),
					(e.getErrorCode() == ErrorCode.BAD_REQUEST) ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/v1/bookDetails/{bookId}")
	public ResponseEntity<Book> searchBook(@RequestParam String bookId){
		return null;
		
	}
	
	@GetMapping(value="/v1/book/penalty/{userId}")
	public ResponseEntity<PenaltyResponse> penaltyDetails(@RequestParam String userId){
		try{
			return new ResponseEntity<PenaltyResponse>(libraryService.executePenalty(userId), HttpStatus.OK);
		}catch(LibraryServiceException e){
			return new ResponseEntity<PenaltyResponse>(new PenaltyResponse(),
					(e.getErrorCode() == ErrorCode.BAD_REQUEST) ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
	}
	
}
