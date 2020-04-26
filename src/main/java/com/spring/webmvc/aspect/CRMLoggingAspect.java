package com.spring.webmvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created By: Kusal Kankanamge
 * Created On: 26-Apr-2020
 */
@Aspect
@Component
public class CRMLoggingAspect
{
    private Logger LOGGER = Logger.getLogger( getClass().getName() );

    @Pointcut( "execution(* com.spring.webmvc.controller.*.*(..))" )
    private void forControllerPackage()
    {
    }

    @Pointcut( "execution(* com.spring.webmvc.service.*.*(..))" )
    private void forServicePackage()
    {
    }

    @Pointcut( "execution(* com.spring.webmvc.dao.*.*(..))" )
    private void forDAOPackage()
    {
    }

    @Pointcut( "forControllerPackage()||forDAOPackage()||forDAOPackage()" )
    private void forAppFlow()
    {
    }

    @Before( "forAppFlow()" )
    private void before( JoinPoint joinPoint )
    {
        String method = joinPoint.getSignature().toShortString();
        LOGGER.info( "=========> in the @Before Advice : " + method );
    }

    @AfterReturning( pointcut = "forAppFlow()", returning = "result" )
    private void afterReturning( JoinPoint joinPoint, Object result )
    {
        String method = joinPoint.getSignature().toShortString();
        LOGGER.info( "=========> in the @AfterReturning Advice : " + method );
        LOGGER.info( "=========> in the @AfterReturning Advice | Returning : " + result );
    }

}
