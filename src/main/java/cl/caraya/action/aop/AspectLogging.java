package cl.caraya.action.aop;

import cl.caraya.action.annotations.Logging;
import cl.caraya.action.annotations.NotLogging;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@Aspect
@Component
@Slf4j
public class AspectLogging {
    private final Predicate<Annotation> isAnnotationLoggable = annotation -> !(annotation instanceof NotLogging);

    @Autowired
    ObjectMapper objectMapper;


    @Around("PointCutBeans.pointCutLogging(logging)")
    public void aroundLogging(ProceedingJoinPoint joinPoint, Logging logging) throws Throwable {
        MDC.put("mdcName", "NAME");
        getMethodParameters(joinPoint).ifPresent(
                paramValues -> {
                    try {
                        log.info("{}", objectMapper.writeValueAsString(paramValues));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
        );

        joinPoint.proceed();

    }

    private Optional<Map<String, Object>> getMethodParameters(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Parameter[] parameters = methodSignature.getMethod().getParameters();
        String[] argNames = methodSignature.getParameterNames();
        Object[] argsValues = joinPoint.getArgs();

        Map<String, Object> paramValues = new HashMap<>();

        IntStream.range(0, parameters.length)
                .filter(index -> Arrays.stream(parameters[index].getAnnotations()).allMatch(this.isAnnotationLoggable))
                .forEach(index -> paramValues.put(argNames[index], argsValues[index]));

        return paramValues.isEmpty() ? Optional.empty() : Optional.of(paramValues);
    }
}
