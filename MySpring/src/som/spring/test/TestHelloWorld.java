package som.spring.test;

import com.spring.action.HelloWorld;

public class TestHelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloWorld hello = new HelloWorld();
		hello.setMessage("hello my friend!");
		System.out.println(hello.getMessage());
		
		HelloWorld hello1 = new HelloWorld("hello all my friends");
		System.out.println(hello1.getMessage());
	}

}
