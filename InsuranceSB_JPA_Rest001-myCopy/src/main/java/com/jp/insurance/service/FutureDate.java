package com.jp.insurance.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FutureDate {
	public Date getFutureDate(int days){
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DATE,days);
		return calendar.getTime();
		
		
		
	}
}
