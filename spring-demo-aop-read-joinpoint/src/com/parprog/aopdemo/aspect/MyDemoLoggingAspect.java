package com.parprog.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.parprog.aopdemo.dao.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	@Before("com.parprog.aopdemo.aspect.AllAopExpressions.forPackagesNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n======>>>> Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: "+methodSig);
		
		// display the method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop of args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	}
	
	
}
