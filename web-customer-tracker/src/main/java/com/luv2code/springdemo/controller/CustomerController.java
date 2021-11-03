package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.util.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel, @RequestParam(required = false) String sort){

        List<Customer> customerList = null;

        if(sort != null){
            int theSortField = Integer.parseInt(sort);
            customerList = customerService.getCustomers(theSortField);
        }
        else {
            customerList = customerService.getCustomers(SortUtils.LAST_NAME);
        }

        theModel.addAttribute("customers", customerList);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){

        Customer customer = customerService.getCustomer(theId);

        theModel.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId){

        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

    @GetMapping("search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel){

        List<Customer> customers = customerService.searchCustomers(theSearchName);

        theModel.addAttribute("customers",customers);

        return "list-customers";
    }
}
