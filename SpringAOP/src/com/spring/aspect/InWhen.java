package com.spring.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class InWhen {
	// 设置切入面
	@Pointcut(value="execution (* com.spring.Imp.*.*(..))&&args(param)",argNames="param")
	public void anyMethod(String param){}
	
	// 在WhenImp中的before() 方法执行之前执行
	@org.aspectj.lang.annotation.Before(value = "execution (* com.spring.Imp.WhenImp1.before(..))&&args(param)",argNames="param")
	public void before(String param){
		System.out.println("连接完成"+param);
	}
	
	// 在WhenImp中的after() 方法执行之后执行
	@org.aspectj.lang.annotation.After(value = "execution (* com.spring.Imp.WhenImp1.after(..))&&args(param)",argNames="param")
	public void after(String param){
		System.out.println("结束"+param);
	}
	
//	@org.aspectj.lang.annotation.AfterReturning(value = "execution (* com.spring.Imp.WhenImp1.after(..))",returning="param")
//	public void afterReturning(Object param){
//		System.out.println("返回值："+param 	);
//	}
	
	@org.aspectj.lang.annotation.AfterThrowing(value = "execution (* com.spring.Imp.*.*(..))",throwing="exception")
	public void whenException(Exception exception){
		System.out.println("异常："+exception);
	}
	
	@org.aspectj.lang.annotation.Around(value = "execution (* com.spring.Imp.*.*(..))")
	public Object around(ProceedingJoinPoint pjp){
		System.out.println("进入方法");
        Object result = null;
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("退出方法");
        return result;
	}
}
