package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = applicationContext.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;

        try{
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        }
        catch (Exception exc){
            System.out.println("\n\nMain Program ... caught exception: " + exc);
        }

        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("----");

        System.out.println(accounts);

        System.out.println("\n");

        applicationContext.close();
    }
}
