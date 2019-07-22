package com.library.utils;

import java.util.Date;

public class DateUtils {

	public static long differenceBetweenDates(Date from,Date to){
		
		
		return Math.abs(to.getTime() - from.getTime());
		
	}
}
