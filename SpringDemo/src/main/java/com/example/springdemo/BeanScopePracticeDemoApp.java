package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopePracticeDemoApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopePractice-applicationContext.xml");

        Coach theCoach = context.getBean("myCoach",Coach.class);

        Coach alphaCoach = context.getBean("myCoach",Coach.class);

        boolean result = (theCoach == alphaCoach);

        System.out.println("\nPointing to the same object: " + result);

        System.out.println("Memory location for theCoach: " + theCoach);

        System.out.println("Memory location for alphaCoach: " + alphaCoach);

        context.close();

    }
}
