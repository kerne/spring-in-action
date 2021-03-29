package cl.caraya.action.aop;

import cl.caraya.action.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class AspectBeans {

//    @Before("PointCutBeans.pointCut()")
//    public void before(JoinPoint joinPoint) {
//        log.info("{}", "before");
//    }
//
//    @After("PointCutBeans.pointCut()")
//    public void after() {
//        log.info("{}", "after");
//    }

    @Around("PointCutBeans.pointCut()")
    public Object watcher(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Type {} method {} ", "around", joinPoint.getArgs());


        Arrays.asList(joinPoint.getArgs()).stream().filter(e -> e instanceof Person)
                .forEach(e -> {
                    Person p = (Person) e;
                    p.setId(123456789);
                    log.info("AAAAAAA {}", p.getName());
                });

        if(joinPoint.getTarget() instanceof Person){

        }

        Person response = (Person) joinPoint.proceed();
        response.setCtaCte("XXXX");
        return response;
    }

}
