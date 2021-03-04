package com.stackroute.flightapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

	@Pointcut("execution (* com.stackroute.flightapp.service.FlightService.*(..)) ")
	public void demo() {
		logger.info("test");
	}
	
	@Before("demo()")
	public void test() {
		logger.info("inside test method");
	}
	
	@After("demo()")
	public void test1() {
		logger.info("inside test method");
	}
	
	
	
//	
//	@Before("execution (* com.stackroute.flightapp.service.FlightService.*(..)) ")
//	public void messagesbeforeservicemethods(JoinPoint joinPoint) {
//		
//		logger.info("Inside the Before method"+joinPoint.getSignature().getName());
//	}
//
//	@After("execution (* com.stackroute.flightapp.service.FlightService.*(..)) ")
//	public void messagesafterservicemethods(JoinPoint joinPoint) {
//		logger.info("Inside the After method"+joinPoint.getSignature().getName());
//	}
//
//	@AfterReturning("execution (* com.stackroute.flightapp.service.FlightService.*(..)) ")
//	public void messagesafterreturningservicemethods(JoinPoint joinPoint) {
//		logger.info("Inside the After returning method"+joinPoint.getSignature().getName());
//	}
//
//	@AfterThrowing("execution (* com.stackroute.flightapp.controller.FlightController.*(..)) ")
//	public void messagesafterthrowingservicemethods(JoinPoint joinPoint) {
//		logger.info("Inside the After throwing method"+joinPoint.getSignature().getName());
//	}

}
