package cl.caraya.action.aop;

import cl.caraya.action.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectParameters {

    @Pointcut("execution(* cl.caraya.action.beans.custom.CheckingBeans.check(..)) && args(person)")
    public void pointCut(Person person){}

    @Around("pointCut(person)")
    public Object around(ProceedingJoinPoint joinPoint, Person person) throws Throwable {
        log.info("Parameter Persona {}", person);
        Person response = (Person) joinPoint.proceed();
        log.info("Response Person {}", response);
        return response;
    }

}
