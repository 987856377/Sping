package com.spring.IoC;

public class Business {
	
	private OracleDateBase odb = new OracleDateBase();
//	��oracle�л�ȡ����
	public void getData(){
		
		odb.getData();
		
	}
	
}
