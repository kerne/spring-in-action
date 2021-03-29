package cl.caraya.action.aop;

import cl.caraya.action.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class AspectBeans {
    @Autowired
    ObjectMapper mapper;


    @Around("PointCutBeans.pointCut()")
    public Object watcher(ProceedingJoinPoint joinPoint) throws Throwable {

        before(joinPoint);
        Person response = (Person) joinPoint.proceed();
        after(response);
        return response;
    }

    private void before(ProceedingJoinPoint joinPoint) {
        Arrays.stream(joinPoint.getArgs()).filter(e -> e instanceof Person)
                .forEach(e -> {
                    Person p = (Person) e;
                    p.setId(123456789);
                });
        try {
            log.info("Request {}", mapper.writeValueAsString(joinPoint.getArgs()[0]));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void after(Person response) {
        response.setCtaCte("XXXX");
        try {
            log.info("Response {}", mapper.writeValueAsString(response));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
