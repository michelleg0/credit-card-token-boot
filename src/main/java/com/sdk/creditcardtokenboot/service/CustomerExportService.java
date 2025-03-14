package com.sdk.creditcardtokenboot.service;

import com.sdk.creditcardtokenboot.entity.CustomerExport;
import com.sdk.creditcardtokenboot.repository.CustomerExportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerExportService {

    private final CustomerExportRepository customerExportRepository;

    public CustomerExportService(CustomerExportRepository customerExportRepository) {
        this.customerExportRepository = customerExportRepository;
    }

    public List<CustomerExport> getCustomersForExport() {
        return customerExportRepository.exportCustomers();
    }
}
