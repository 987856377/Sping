package com.spring.IoC;

public class Business2 {
//	��Խӿ� DataBase �������
	private DataBase db = null;
	
//	�ӿ�ע��
//	�ṩĬ�ϵĹ��췽�������ӿ�ע��ʹ��
	public Business2(){
		
	}
	public void createDI(DataBase db){
		this.db = db;
	}
	
//	����ע��
	public Business2(DataBase db){
		
	}
	
//	set ע��
	public void setDataBase(DataBase db){
		this.db = db;
	}
//	���ע������ݿ��࣬�� �� �� �� ���ݿ��л�ȡ����
	public void getData(){
		
		db.getData();
		
	}
}
