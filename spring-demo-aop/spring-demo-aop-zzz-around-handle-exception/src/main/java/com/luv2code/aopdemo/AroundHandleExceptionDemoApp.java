package com.luv2code.aopdemo;

import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {
    public static void main(String[] args) {

        Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = applicationContext.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain Program: AroundDemoApp");

        myLogger.info("Calling getFortune");

        boolean tripWire = true;

        String data = trafficFortuneService.getFortune(tripWire);

        myLogger.info("\nMy fortune is: " + data);

        myLogger.info("Finished");

        applicationContext.close();
    }
}
