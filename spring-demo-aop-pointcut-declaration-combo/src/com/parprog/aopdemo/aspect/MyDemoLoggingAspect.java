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
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.parprog.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.parprog.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	//create pointcut: include package ... exclude getter/setter
	@Pointcut("forAllPackages() && !(getter() || setter())")
	private void forPackagesNoGetterSetter() {}
	// use pointcut expression multiple times
	@Before("forPackagesNoGetterSetter()")
	public void beforeAddAdvice() {
		System.out.println("\n======>>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forPackagesNoGetterSetter()")
	public void beforeAddAdvice2() {
		System.out.println("1---------1");
	}
}
