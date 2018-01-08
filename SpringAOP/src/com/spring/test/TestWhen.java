package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import com.spring.intf.When;

public class TestWhen {
	@SuppressWarnings("resource")
	@Test
	public static void test(){
		ApplicationContext actx = new ClassPathXmlApplicationContext("aop.xml");
		When imp = (When)actx.getBean("whenImp1");
		imp.before("sam");
		System.out.println();
		imp.after("sam");
		
	}
	
	public static void main(String[] args){
		test();
	}
}
