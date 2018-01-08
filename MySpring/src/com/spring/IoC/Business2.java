package com.spring.IoC;

public class Business2 {
//	针对接口 DataBase 定义变量
	private DataBase db = null;
	
//	接口注入
//	提供默认的构造方法，供接口注入使用
	public Business2(){
		
	}
	public void createDI(DataBase db){
		this.db = db;
	}
	
//	构造注入
	public Business2(DataBase db){
		
	}
	
//	set 注入
	public void setDataBase(DataBase db){
		this.db = db;
	}
//	针对注入的数据库类，从 。 。 。 数据库中获取数据
	public void getData(){
		
		db.getData();
		
	}
}
