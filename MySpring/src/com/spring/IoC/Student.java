package com.spring.IoC;

public class Student {
	private String name;
//	@Autowired
	private int age;
	private String sex;
	
	public Student(){
		
	}
	
	public Student(String name,int age,String sex){
		this.name=name;
		this.age=age;
		this.sex=sex;
	}
	
	public String getName() {
		return name;
	}
//	@Required	// 用于setter方法，表明bean属性必须在配置时通过bean定义中的显示属性值或通过自动装配来填充
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
//	@Autowired	// 可用于setter方法，可用于构造函数和字段
//	@Required
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
//	@Required
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
