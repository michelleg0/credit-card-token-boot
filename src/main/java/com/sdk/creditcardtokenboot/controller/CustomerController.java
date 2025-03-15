package com.sdk.creditcardtokenboot.controller;

import com.sdk.creditcardtokenboot.entity.Customer;
import com.sdk.creditcardtokenboot.service.CustomerService;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customer.setId(id);
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }


    @GetMapping("/export")
    public List<Map<String, Object>> exportCustomers() {
        return customerService.getCustomersForExport();
    }
}
