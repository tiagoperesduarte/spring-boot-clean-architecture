package com.delivery.apmc.core.annotation;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class TrackExecutionTimeAspect {
    @Around("@annotation(TrackExecutionTime)")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        Instant start = Instant.now();

        Object obj = pjp.proceed();

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        log.debug("Method {} successfully executed in {} milliseconds.", pjp.getSignature(), timeElapsed);
        return obj;
    }
}
