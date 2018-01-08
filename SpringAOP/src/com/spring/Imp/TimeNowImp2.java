package com.spring.Imp;

import com.spring.intf.TimeNow;

public class TimeNowImp2 implements TimeNow {

	@Override
	public void printBefore() {
		// TODO Auto-generated method stub
		System.out.println("开始再次审核...");
	}

	@Override
	public void printAfter() {
		// TODO Auto-generated method stub
		System.out.println("再次审核结束...");
	}

}
