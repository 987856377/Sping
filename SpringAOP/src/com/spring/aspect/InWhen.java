package com.spring.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class InWhen {
	// ����������
	@Pointcut(value="execution (* com.spring.Imp.*.*(..))&&args(param)",argNames="param")
	public void anyMethod(String param){}
	
	// ��WhenImp�е�before() ����ִ��֮ǰִ��
	@org.aspectj.lang.annotation.Before(value = "execution (* com.spring.Imp.WhenImp1.before(..))&&args(param)",argNames="param")
	public void before(String param){
		System.out.println("�������"+param);
	}
	
	// ��WhenImp�е�after() ����ִ��֮��ִ��
	@org.aspectj.lang.annotation.After(value = "execution (* com.spring.Imp.WhenImp1.after(..))&&args(param)",argNames="param")
	public void after(String param){
		System.out.println("����"+param);
	}
	
//	@org.aspectj.lang.annotation.AfterReturning(value = "execution (* com.spring.Imp.WhenImp1.after(..))",returning="param")
//	public void afterReturning(Object param){
//		System.out.println("����ֵ��"+param 	);
//	}
	
	@org.aspectj.lang.annotation.AfterThrowing(value = "execution (* com.spring.Imp.*.*(..))",throwing="exception")
	public void whenException(Exception exception){
		System.out.println("�쳣��"+exception);
	}
	
	@org.aspectj.lang.annotation.Around(value = "execution (* com.spring.Imp.*.*(..))")
	public Object around(ProceedingJoinPoint pjp){
		System.out.println("���뷽��");
        Object result = null;
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("�˳�����");
        return result;
	}
}
