package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringDemoApplication.class, args);

        Coach theCoach = new TrackCoach();

        System.out.println(theCoach.getDailyWorkout());
    }

}
