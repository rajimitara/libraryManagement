package com.library.exception;

import com.library.exception.EnumBase.ErrorCode;

public class LibraryServiceException extends Exception{

	public LibraryServiceException(String message){
		
	}
	
	private ErrorCode errorCode;

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	   
	
}

