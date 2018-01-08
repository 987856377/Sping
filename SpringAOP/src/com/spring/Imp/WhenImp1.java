package com.spring.Imp;

import com.spring.intf.When;

public class WhenImp1 implements When {

	@Override
	public void before(String param) {
		// TODO Auto-generated method stub
		System.out.println("当前用户  "+param);
	}

	@Override
	public void after(String param) {
		// TODO Auto-generated method stub
		System.out.println("当前用户  "+param);
	}

}
