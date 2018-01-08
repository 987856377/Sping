package com.spring.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@SuppressWarnings("rawtypes")
public class LogListener implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		if(event instanceof LogEvent){
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
			sdf.setLenient(false);
			String currentDate = sdf.format(new Date());
			System.out.println("时间:"+currentDate+"事件"+event.toString());
		}
	}

}
