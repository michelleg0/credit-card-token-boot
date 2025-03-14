package com.sdk.creditcardtokenboot.controller;

import com.sdk.creditcardtokenboot.entity.CustomerExport;
import com.sdk.creditcardtokenboot.service.CustomerExportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/export")  //
public class ExportController {

    private final CustomerExportService customerExportService;

    public ExportController(CustomerExportService customerExportService) {
        this.customerExportService = customerExportService;
    }

    @GetMapping("/customers")
    public List<CustomerExport> exportCustomers() {
        return customerExportService.getCustomersForExport();
    }
}
