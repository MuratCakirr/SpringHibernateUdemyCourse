package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String method = proceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {

            myLogger.warning(e.getMessage());

            throw e;
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;
        myLogger.info("\n====> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @After (finally) on method: " + method);

    }

    @AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
                   throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc){

        String method = joinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @AfterThrowing on method: " + method);

        myLogger.info("\n=====>>> The exception is: " + theExc);

    }

    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
                    returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        String method = joinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @AfterReturning on method: " + method);

        myLogger.info("\n=====>>> result is: " + result);

        convertAccountNamesToUpperCase(result);

        myLogger.info("\n=====>>> result is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for (Account tempAccount:result) {
            String theUpperName = tempAccount.getName().toUpperCase();

            tempAccount.setName(theUpperName);
        }

    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        myLogger.info("\n======>>> Executing @Before advice on method");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        myLogger.info("Method: " + methodSignature);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg:args) {
            myLogger.info(tempArg.toString());

            if(tempArg instanceof Account){
                Account account = (Account) tempArg;

                myLogger.info("account name: " + account.getName());
                myLogger.info("account level: " + account.getLevel());
            }
        }
    }
}
