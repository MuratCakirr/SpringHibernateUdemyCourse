package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees;

    @PostConstruct
    private void loadData(){

        Employee emp1 = new Employee(1,"Leslie","Andrews","leslie@luv2code.com");
        Employee emp2 = new Employee(1,"Emma","Baumgarten","emma@luv2code.com");
        Employee emp3 = new Employee(1,"Avani","Gupta","avani@luv2code.com");

        employees = new ArrayList<>();

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
    }

    @GetMapping("/list")
    public String listEmployee(Model theModel){

        theModel.addAttribute("employees", employees);

        return "list-employees";
    }
}
