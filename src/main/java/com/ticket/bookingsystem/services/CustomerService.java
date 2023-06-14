package com.ticket.bookingsystem.services;

import com.ticket.bookingsystem.models.dtos.CustomerDTO;
import java.util.List;
public interface CustomerService {

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomerById(long id, CustomerDTO userDTO);

    void deleteCustomerById(long id);

    List<CustomerDTO> getCustomers();
}
