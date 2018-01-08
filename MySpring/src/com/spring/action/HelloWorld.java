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
//	默认的构造方法支持 applicationContext.xml 中 bean 的初始化
	public HelloWorld(){
		
	}
//	自定义的构造方法不支持
	public HelloWorld(String message){
		this.message = message;
	}
	/*
	 * 在 applicationContext.xml 中用 init-method="init" 完成初始化工作
	 */
	public void init(){
		this.message = "hello world";
		this.date = new Date();
	}
	/*
	 * 在 applicationContext.xml 中用 destroy-method="destroy" 完成清理工作
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
