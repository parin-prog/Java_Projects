package com.parprog.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	@Before("com.parprog.aopdemo.aspect.AllAopExpressions.forPackagesNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>>> Executing @Before advice on addAccount()");
	}
	
	
}
