package com.library.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.exception.LibraryServiceException;
import com.library.exception.EnumBase.ErrorCode;
import com.library.model.Book;
import com.library.model.LendResponse;
import com.library.model.Student;
import com.library.service.LibraryService;

@RestController
public class Registration {
	
	@Autowired
	LibraryService libraryService;
	
	@PostMapping(value="/v1/register/book")
	public ResponseEntity<String> registerBook(@RequestBody Book newBook){
		try{
			return new ResponseEntity<String>(libraryService.registerBook(newBook),HttpStatus.OK);
		}catch(LibraryServiceException e){
			return new ResponseEntity<>("",
					(e.getErrorCode() == ErrorCode.BAD_REQUEST) ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/v1/register/student")
	public ResponseEntity<String> enrollStudent(@RequestBody Student fresher){
		try{
			return new ResponseEntity<String>(libraryService.registerUser(fresher),HttpStatus.OK);
		}catch(LibraryServiceException e){
			return new ResponseEntity<>("",
					(e.getErrorCode() == ErrorCode.BAD_REQUEST) ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

}
