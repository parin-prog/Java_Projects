package com.parprog.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// pointcut expression with package match
	@Pointcut("execution(* com.parprog.aopdemo.dao.*.*(..))")
	public void forAllPackages() {}
	
	// use pointcut expression multiple times
	@Before("forAllPackages()")
	public void beforeAddAdvice() {
		System.out.println("\n======>>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forAllPackages()")
	public void beforeAddAdvice2() {
		System.out.println("1---------1");
	}
}
