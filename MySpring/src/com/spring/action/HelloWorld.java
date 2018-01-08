package com.spring.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HelloWorld {
	private String message = null;
	private Date date = null;
	private List<?> list = null;
	private Set<?> set = null;
	private Map<?, ?> map = null;
//	Ĭ�ϵĹ��췽��֧�� applicationContext.xml �� bean �ĳ�ʼ��
	public HelloWorld(){
		
	}
//	�Զ���Ĺ��췽����֧��
	public HelloWorld(String message){
		this.message = message;
	}
	/*
	 * �� applicationContext.xml ���� init-method="init" ��ɳ�ʼ������
	 */
	public void init(){
		this.message = "hello world";
		this.date = new Date();
	}
	/*
	 * �� applicationContext.xml ���� destroy-method="destroy" ���������
	 */
	public void destroy(){
		this.message = null;
		this.date = null;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public void setList(List<?> list){
		this.list = list;
	}
	public List<?> getList(){
		return this.list;
	}
	
	public void setSet(Set<?> set){
		this.set = set;
	}
	public Set<?> getSet(){
		return this.set;
	}
	
	public void setMap(Map<?,?> map){
		this.map = map;
	}
	public Map<?, ?> getMap(){
		return this.map;
	}
	
}
