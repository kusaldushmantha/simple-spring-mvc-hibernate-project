package com.spring.webmvc.controller;

import com.spring.webmvc.entity.Customer;
import com.spring.webmvc.service.CustomerService;
import com.spring.webmvc.validations.StringLowerCaseEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created By: Kusal Kankanamge
 * Created On: 13-Apr-2020
 */
@Controller
@RequestMapping( "/customer" )
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @GetMapping( "/list" )
    public String listCustomers( Model theModel )
    {
        List<Customer> customers = customerService.getCustomer();
        theModel.addAttribute( "customers", customers );

        return "list-customers";
    }

    @GetMapping( "/showFormForAdd" )
    public String showFormForAdd( Model theModel )
    {
        Customer customer = new Customer();
        theModel.addAttribute( "customer", customer );
        return "customer-form";
    }

    @PostMapping( "/saveCustomer" )
    public String saveCustomer( @ModelAttribute( "customer" ) Customer customer )
    {
        customerService.saveCustomer( customer );
        return "redirect:/customer/list";
    }

    @GetMapping( "/showFormForUpdate" )
    public String showFormForUpdate(
            @RequestParam( "customerId" ) int customerId,
            @RequestParam( "customerName" ) String customerName,
            Model model )
    {

        System.out.println("\n\nCustomer name : " + customerName + "\n\n");

        Customer customer = customerService.getCustomer( customerId );
        model.addAttribute( "customer", customer );

        return "customer-form";
    }

    @GetMapping( "/deleteCustomer" )
    public String deleteCustomer( @RequestParam( "customerId" ) int customerId )
    {
        customerService.deleteCustomer( customerId );
        return "redirect:/customer/list";
    }
}
