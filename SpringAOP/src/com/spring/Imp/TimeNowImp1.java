package com.spring.Imp;

import com.spring.intf.TimeNow;

public class TimeNowImp1 implements TimeNow {

	@Override
	public void printBefore() {
		// TODO Auto-generated method stub
		System.out.println("��ʼ���...");
	}

	@Override
	public void printAfter() {
		// TODO Auto-generated method stub
		System.out.println("��˽���...");
	}

}
