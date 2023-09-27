package com.parprog.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AllAopExpressions {

	// pointcut expression with package match
		@Pointcut("execution(* com.parprog.aopdemo.dao.*.*(..))")
		public void forAllPackages() {}
		
		// create pointcut for getter methods
		@Pointcut("execution(* com.parprog.aopdemo.dao.*.get*(..))")
		public void getter() {}
		
		// create pointcut for setter methods
		@Pointcut("execution(* com.parprog.aopdemo.dao.*.set*(..))")
		public void setter() {}
		
		//create pointcut: include package ... exclude getter/setter
		@Pointcut("forAllPackages() && !(getter() || setter())")
		public void forPackagesNoGetterSetter() {}

}
