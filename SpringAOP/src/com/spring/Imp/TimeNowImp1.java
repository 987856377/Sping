package com.spring.Imp;

import com.spring.intf.TimeNow;

public class TimeNowImp1 implements TimeNow {

	@Override
	public void printBefore() {
		// TODO Auto-generated method stub
		System.out.println("¿ªÊ¼ÉóºË...");
	}

	@Override
	public void printAfter() {
		// TODO Auto-generated method stub
		System.out.println("ÉóºË½áÊø...");
	}

}
