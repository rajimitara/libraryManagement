package com.library.service.impl;

import java.util.Date;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.library.model.Book;
import com.library.model.PenaltyResponse;
import com.library.model.Student;
import com.library.repository.Ownership;
import com.library.repository.UserRepository;
import com.library.utils.DateUtils;

@Component
public class PenaltyTracking {

	//
	@Autowired
	public Ownership ownership;
	
	@Autowired
	public UserRepository userRepository;
	
	long firstThreeDays;
	
	long secondThreeDays;
	
	long remainingDays;
	
	long readingTime;
	
	long firstThreshold;
	
	long secondThreshold;
	
	//Runs once every 24hour and keep library penalty system updated.
	@Scheduled
	public void calculateLendBookDue(){
		ConcurrentHashMap<String, Book> lendBookList = ownership.getLendBookList();
		
		for(Entry<String, Book> lentbook : lendBookList.entrySet()){
			
			
			String bookTitle = lentbook.getKey();
			Book otherDetails = lentbook.getValue();
			Student student = userRepository.getUser(otherDetails.getUserId());
					
			boolean isDue = isBookOnDue(otherDetails.getDueDate());

			if(!isDue || student.isBackListed())
				continue;
			
			
			Book updatedBookDetails = calculatePenalty(otherDetails,student);
			
			lendBookList.put(bookTitle, updatedBookDetails);
			
		}
	}

	public Book calculatePenalty(Book otherDetails, Student student) {
		Date dueDate = otherDetails.getDueDate();
		long penaltyInRupees = student.getPenaltyInRupees();
		Date penaltyTillDate = student.getPenaltyTillDate();
		Date currentDate = new Date();
		
		//already penalty calculated. while checking api penalty api before scheduler time
		if(penaltyTillDate.equals(currentDate))
			return otherDetails;
		
		long numberOfDaysDue = DateUtils.differenceBetweenDates(dueDate, currentDate);
		
		long currentDateFineInRupees = numberOfDaysDue <= firstThreshold ? firstThreeDays:numberOfDaysDue <= secondThreshold ?
				secondThreeDays:remainingDays;
	
		student.setPenaltyInRupees(penaltyInRupees+currentDateFineInRupees);
		student.setPenaltyTillDate(currentDate);
		//store in DB
		userRepository.updateUser(student.getUserId(), student);
		return otherDetails;
	}

	public PenaltyResponse createPenaltyResponse(Book updatedDetails) {
		PenaltyResponse penaltyResponse = new PenaltyResponse(updatedDetails);
		Student user = userRepository.getUser(updatedDetails.getUserId());
		penaltyResponse.setBackListed(user.isBackListed());
		penaltyResponse.setOutstandingAmount(user.getPenaltyInRupees());
		return null;
	}
	
	private boolean isBookOnDue(Date dueDate) {
		return false;
	}

	public long getFirstThreeDays() {
		return firstThreeDays;
	}

	public void setFirstThreeDays(long firstThreeDays) {
		this.firstThreeDays = firstThreeDays;
	}

	public long getSecondThreeDays() {
		return secondThreeDays;
	}

	public void setSecondThreeDays(long secondThreeDays) {
		this.secondThreeDays = secondThreeDays;
	}

	public long getRemainingDays() {
		return remainingDays;
	}

	public void setRemainingDays(long remainingDays) {
		this.remainingDays = remainingDays;
	}

	public long getReadingTime() {
		return readingTime;
	}

	public void setReadingTime(long readingTime) {
		this.readingTime = readingTime;
	}

	public long getFirstThreshold() {
		return firstThreshold;
	}

	public void setFirstThreshold(long firstThreshold) {
		this.firstThreshold = firstThreshold;
	}

	
}
