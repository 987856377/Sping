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
//	@Required	// ����setter����������bean���Ա���������ʱͨ��bean�����е���ʾ����ֵ��ͨ���Զ�װ�������
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
//	@Autowired	// ������setter�����������ڹ��캯�����ֶ�
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
