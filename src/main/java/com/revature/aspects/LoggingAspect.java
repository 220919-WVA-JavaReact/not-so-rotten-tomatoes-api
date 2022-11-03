package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(com.revature..*)")
    public void logAll(){
        //our pointcut reference

    }

    public String extractMethodSignature(JoinPoint jp){
        String methodSignature = jp.getTarget().getClass().getSimpleName()+":"+jp.getSignature().getName();
        return methodSignature;
    }
    @Before(value = "logAll()")
    public void logMethodStart(JoinPoint jp) {
        String methodSignature = extractMethodSignature(jp);
        String methodArgs = Arrays.toString(jp.getArgs());

        log.trace(methodSignature + " invoked with provided arguments: " + methodArgs);
    }

    @AfterReturning(value = "logAll()", returning = "returnedObject")
    public void logMethodReturn(JoinPoint jp, Object returnedObject) {
        String methodSignature = extractMethodSignature(jp);
        log.trace(methodSignature + " successfully returned with the value: " + returnedObject);
    }

    @AfterThrowing(value = "logAll()", throwing = "t")
    public void logMethodException(JoinPoint jp, Throwable t){
        String methodSignature = extractMethodSignature(jp);
        log.trace(methodSignature + " successfully returned with the value: " + t.getMessage());
    }
}
