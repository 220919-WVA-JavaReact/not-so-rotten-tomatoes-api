package com.revature.aspects;

import com.revature.annotations.Secured;
import com.revature.dtos.UserDTO;
import com.revature.exceptions.AuthorizationException;
import com.revature.services.TokenService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class SecurityAspect {

    private HttpServletRequest req;
    private TokenService ts;

    public SecurityAspect(HttpServletRequest req, TokenService ts){
        this.req = req;
        this.ts = ts;
    }
    @Around("@annotation(com.revature.annotations.Secured)")
    public Object secure(ProceedingJoinPoint pjp) throws Throwable {

        Method method = ((MethodSignature) pjp.getSignature()).getMethod();

        Secured securedAnnotation = method.getAnnotation(Secured.class);

        List<String> allowedRoles = Arrays.asList(securedAnnotation.rolesAllowed());

        String token = req.getHeader("Authorization");

        UserDTO user = ts.extractTokenDetails(token);

        if(!allowedRoles.contains(user.getRole().toString())){
            throw new AuthorizationException();
        }
        return pjp.proceed();

    }
}
