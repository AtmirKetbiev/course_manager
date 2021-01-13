package ru.ketbiev.course_manager.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//    @Around("execution(* ru.ketbiev.course_manager.validator.UserValidator.validate(*,*))")
//    public Object validatorAdvice(ProceedingJoinPoint proceedingJoinPoint){
//        System.out.println("Start validator " + proceedingJoinPoint.getSignature().getName());
//        Object value = null;
//        try {
//            value = proceedingJoinPoint.proceed();
//        } catch (Throwable e) {
//            System.out.println("Error validator " + proceedingJoinPoint.getSignature().getName());
//            e.printStackTrace();
//        }
//        System.out.println("Finish validator " + proceedingJoinPoint.getSignature().getName());
//        return value;
//    }

//    @Around("execution(* ru.ketbiev.course_manager.service..*(..))")
//    public Object serviceAdvice(ProceedingJoinPoint proceedingJoinPoint){
//        System.out.println("Start service " + proceedingJoinPoint.getSignature().getName());
//        Object value = null;
//        try {
//            value = proceedingJoinPoint.proceed();
//        } catch (Throwable e) {
//            System.out.println("Error service " + proceedingJoinPoint.getSignature().getName());
//            e.printStackTrace();
//        }
//        System.out.println("Finish service " + proceedingJoinPoint.getSignature().getName());
//        return value;
//    }

//    @Around("execution(* ru.ketbiev.course_manager.controller.*.*(..))")
//    public Object controllerAdvice(ProceedingJoinPoint proceedingJoinPoint){
//        System.out.println("Start controller " + proceedingJoinPoint.getSignature().getName());
//        Object value = null;
//        try {
//            value = proceedingJoinPoint.proceed();
//        } catch (Throwable e) {
//            System.out.println("Error controller " + proceedingJoinPoint.getSignature().getName());
//            e.printStackTrace();
//        }
//        System.out.println("Finish controller " + proceedingJoinPoint.getSignature().getName());
//        return value;
//    }
}
