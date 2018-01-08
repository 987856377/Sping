package com.spring.IoC;

public class TestDataBase {
//		接口注入
		Business2 business1 = new Business2();
//		构造注入
		Business2 business2 = new Business2(new OracleDataBaseImp());
//		set 注入
		Business2 business3 = new Business2();
		
		public void getData1(){
//			从Oracle数据库中获取数据
			business1.setDataBase(new OracleDataBaseImp());
			
//			从MySql数据库中获取数据
			business1.setDataBase(new MySqlDataBaseImp());
			
			business1.getData();
			
		}
		

}
