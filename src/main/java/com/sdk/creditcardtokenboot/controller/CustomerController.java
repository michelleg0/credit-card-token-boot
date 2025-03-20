package com.sdk.creditcardtokenboot.controller;

import com.sdk.creditcardtokenboot.entity.Customer;
import com.sdk.creditcardtokenboot.service.CustomerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Get a customer by ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    // Add a new customer
    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    // Update customer details
    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customer.setId(id);
        customerService.updateCustomer(customer);
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/export")
    public void exportCustomers(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=customers.csv");

        // Fetch customer data
        List<Map<String, Object>> customers = customerService.getCustomersForExport();

        PrintWriter writer = response.getWriter();
        writer.println("First Name,Last Name,Email,Token"); // CSV headers

        for (Map<String, Object> customer : customers) {
            writer.println(
                    customer.get("first_name") + "," +  //
                            customer.get("last_name") + "," +
                            customer.get("email") + "," +
                            (customer.get("credit_card_tokens") != null ? customer.get("credit_card_tokens") : "NULL") //
            );
        }

        writer.flush();
        writer.close();
    }


}
