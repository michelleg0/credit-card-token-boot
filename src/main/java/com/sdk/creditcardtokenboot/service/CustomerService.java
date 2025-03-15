package com.sdk.creditcardtokenboot.service;

import com.sdk.creditcardtokenboot.entity.Customer;
import com.sdk.creditcardtokenboot.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.update(customer);
    }

    public void deleteCustomer(int id) {
        customerRepository.delete(id);
    }

    public List<Map<String, Object>> getCustomersForExport() {
        return customerRepository.findCustomersForExport();
    }
}