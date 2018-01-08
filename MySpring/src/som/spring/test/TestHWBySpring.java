package som.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.action.HelloWorld;

public class TestHWBySpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext actx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld hello = (HelloWorld)actx.getBean("HelloWorld");
//		System.out.println(hello.getMessage());
		hello.setMessage("hello  world");
		System.out.println(hello.getMessage());
		System.out.println(hello.getDate());
		
	}

}
