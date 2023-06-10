package com.ticket.bookingsystem.controlers;

import com.ticket.bookingsystem.models.dtos.CustomerDTO;
import com.ticket.bookingsystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")

public class CustomerController {
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

    @GetMapping("/api/customers")
    public List<CustomerDTO> getCustomers() {
        return customerService.getCustomers();
    }

    @PutMapping("/api/customers/{customerid}")
    public ResponseEntity<CustomerDTO> updateCustomerById(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.updateCustomerById(customerId, customerDTO));
    }

    @DeleteMapping("/api/customers/{id}")
    public void deleteUserById(@PathVariable long id) {
        customerService.deleteCustomerById(id);
    }


}
