package com.glinboy.sample.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(@org.springframework.stereotype.Repository *)"
			+ " || within(@org.springframework.stereotype.Service *)"
			+ " || within(@org.springframework.web.bind.annotation.RestController *)")
	public void springBeanPointcut() {
		throw new UnsupportedOperationException();
	}

	@Pointcut("within(com.glinboy.sample.aop.repository..*)"
			+ " || within(com.glinboy.sample.aop.service.impl..*)"
			+ " || within(com.glinboy.sample.aop.web..*)")
	public void applicationPackagePointcut() {
		throw new UnsupportedOperationException();
	}

	@AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		logger.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e.getCause() != null ? e.getMessage() : "NULL");
	}

	@Around("applicationPackagePointcut() && springBeanPointcut()")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		final String joinPoints = Arrays.toString(joinPoint.getArgs());
		if (joinPoints != null) {
			logger.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(), joinPoints);
		}
		final Object result = joinPoint.proceed();
		logger.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), result);
		return result;
	}

}
