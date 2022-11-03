package com.revature.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    
}
