package com.example.springbootfilter.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class DemoAspectLog {

    @Pointcut("@annotation(com.example.springbootfilter.anno.DemoLogAnno)")
    public void pointCut() {
        System.out.println("pointCut()");
    }

//    @Before(value = "pointCut()")
//    public void before(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("执行目标方法【" + methodName + "】之前执行<前置通知>,入参" +
//                Arrays.asList(joinPoint.getArgs()));
//    }
//
//    @After(value = "pointCut()")
//    public void methodAfter(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("执行目标方法【" + methodName + "】之前执行<后置通知>,入参" + Arrays.asList(joinPoint.getArgs()));
//    }
//
//    @AfterReturning(value = "pointCut()")
//    public void methodReturning(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("执行目标方法【" + methodName + "】之前执行<返回通知>,入参" + Arrays.asList(joinPoint.getArgs()));
//    }
//
//    @AfterThrowing(value = "pointCut()")
//    public void methodAfterThrowing(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("执行目标方法【" + methodName + "】之前执行<异常通知>,入参" + Arrays.asList(joinPoint.getArgs()));
//    }

    @Around(value = "pointCut()")
    public void methodAfterThrowing(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【" + methodName + "】之前执行<环绕通知>,入参" + Arrays.asList(joinPoint.getArgs()));
        try {
            //调用目标方法
            joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("调用目标方法异常:" + throwable.getMessage());
            throwable.printStackTrace();
        }
    }
}
