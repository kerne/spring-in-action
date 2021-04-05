package cl.caraya.action.aop;

import cl.caraya.action.annotations.Payload;
import cl.caraya.action.domain.PayLoadDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
@Aspect
@Slf4j
public class AspectPayload {


    @Around("PointCutBeans.pointCutPayload(payload)")
    public void aroundPayload(ProceedingJoinPoint joinPoint, Payload payload) throws Throwable {
        if (joinPoint.getArgs().length == 2) {
            Optional<Object> opPayload = Arrays.stream(joinPoint.getArgs())
                    .filter(e -> e instanceof PayLoadDTO)
                    .findAny();

            if (opPayload.isPresent()) {
                PayLoadDTO payLoadDTO = (PayLoadDTO) opPayload.get();
                MDC.put("mdcName", payLoadDTO.getName());
                joinPoint.proceed(new Object[]{payLoadDTO, payLoadDTO.toString()});
            }
            return;
        }
        joinPoint.proceed();
    }
}
