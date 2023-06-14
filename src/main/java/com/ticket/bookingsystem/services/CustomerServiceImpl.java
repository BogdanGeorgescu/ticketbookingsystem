package com.ticket.bookingsystem.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.bookingsystem.exceptions.CustomerNotFoundException;
import com.ticket.bookingsystem.models.dtos.CustomerDTO;
import com.ticket.bookingsystem.models.entities.Customer;
import com.ticket.bookingsystem.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final ObjectMapper objectMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(ObjectMapper objectMapper, CustomerRepository customerRepository) {
        this.objectMapper = objectMapper;
        this.customerRepository = customerRepository;
    }

    @Transactional
    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = objectMapper.convertValue(customerDTO, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("Customer" + savedCustomer.getEmail() + "was created");
        return objectMapper.convertValue(savedCustomer, CustomerDTO.class);

    }




    @Override
    public CustomerDTO updateCustomerById(long id, CustomerDTO customerDTO) {
        Customer customerFound = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        customerFound.setFirstName(customerDTO.getFirstName());
        customerFound.setSurname(customerDTO.getSurname());
        customerFound.setDateOfBirth(customerDTO.getDateOfBirth());
        customerFound.setEmail(customerDTO.getEmail());
        Customer customerSaved = customerRepository.save(customerFound);
        log.info("Customer " + id + "was updated successfully");
        return objectMapper.convertValue(customerSaved, CustomerDTO.class);
    }

    @Override
    public void deleteCustomerById(long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            log.info("Customer with id " + id + " was deleted successfully.");
        } else {
            throw new CustomerNotFoundException("Customer not found.");
        }
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        List<Customer> customersFound = customerRepository.findAll();
        List<CustomerDTO> customersFoundDTO = new ArrayList<>();
        customersFound.forEach(customer -> customersFoundDTO.add(objectMapper.convertValue(customer, CustomerDTO.class)));
        return customersFoundDTO;
    }
}
