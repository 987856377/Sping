package com.spring.IoC;

public class TestDataBase {
//		�ӿ�ע��
		Business2 business1 = new Business2();
//		����ע��
		Business2 business2 = new Business2(new OracleDataBaseImp());
//		set ע��
		Business2 business3 = new Business2();
		
		public void getData1(){
//			��Oracle���ݿ��л�ȡ����
			business1.setDataBase(new OracleDataBaseImp());
			
//			��MySql���ݿ��л�ȡ����
			business1.setDataBase(new MySqlDataBaseImp());
			
			business1.getData();
			
		}
		

}
