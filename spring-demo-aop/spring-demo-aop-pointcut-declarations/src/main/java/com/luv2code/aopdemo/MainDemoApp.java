package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = applicationContext.getBean("accountDAO", AccountDAO.class);

        MembershipDAO membershipDAO = applicationContext.getBean("membershipDAO", MembershipDAO.class);

        accountDAO.addAccount(new Account(),true);
        accountDAO.doWork();

        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();

        applicationContext.close();
    }
}
