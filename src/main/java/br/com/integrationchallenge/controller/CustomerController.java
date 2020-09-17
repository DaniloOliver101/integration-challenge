package br.com.integrationchallenge.controller;

import br.com.integrationchallenge.controller.dto.CustomerDto;
import br.com.integrationchallenge.controller.form.CustomerForm;
import br.com.integrationchallenge.model.Customer;
import br.com.integrationchallenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<CustomerDto> customerService(Long customerId) {
        if (customerId == null) {
            List<Customer> customers = customerRepository.findAll();

            return CustomerDto.convert(customers);
        } else {
            List<Customer> customers = customerRepository.getAllByCustomerId(customerId);
            return CustomerDto.convert(customers);
        }
    }

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerForm form, UriComponentsBuilder uriBuilder) {
        Customer customer = form.convert();
        customerRepository.save(customer);
        URI uri = uriBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomerDto(customer));
    }
}