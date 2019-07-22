package com.library.model;


import org.springframework.stereotype.Component;

@Component
public class SequenceGenerator {
	  int i = 0;
	    public synchronized void addOne()
	    {
	        i++;
	    }
	    public synchronized int get()
	    {
	        return i;
	    }
}
