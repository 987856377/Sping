package som.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.IoC.Student;
//@Component
public class TestStudent {
//	@Bean @Qualifier("public")
//	public Student publicInstance(){
//		return new Student("lisi",12,"man");
//	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext actx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Student stu = (Student)actx.getBean("student");
		System.out.println(stu.getName());
		System.out.println(stu.getAge());
		System.out.println(stu.getSex());
		stu.setAge(12);
		System.out.println(stu.getAge());
		
	
	}

}
