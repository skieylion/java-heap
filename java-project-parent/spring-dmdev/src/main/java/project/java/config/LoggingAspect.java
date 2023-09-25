package project.java.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* project.java.service.CompanyService.findById(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Метод " + joinPoint.getSignature().getName() + " будет вызван");
    }
}
