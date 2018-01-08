package com.spring.IoC;

public class Business {
	
	private OracleDateBase odb = new OracleDateBase();
//	从oracle中获取数据
	public void getData(){
		
		odb.getData();
		
	}
	
}
