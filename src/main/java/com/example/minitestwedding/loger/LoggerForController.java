//package com.example.minitestwedding.loger;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LoggerForController {
//    @AfterReturning(pointcut = "within(com.example.minitestwedding..controller.*)", returning = "kq")
//    public void writeLog(JoinPoint joinPoint, Object kq){
//        System.out.println("Start log");
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String method = joinPoint.getSignature().getName();
//        System.out.println(className+"."+method);
//        if (kq != null)
//            System.out.println(kq.hashCode());
//
//    }
//}
