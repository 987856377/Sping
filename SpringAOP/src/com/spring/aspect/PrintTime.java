package com.spring.aspect;

import java.util.Date;

public class PrintTime {
	
	public void beginTime(){
		System.out.println(new Date());
	}	
	
	public void endTime(){
		System.out.println(new Date());
	}
}