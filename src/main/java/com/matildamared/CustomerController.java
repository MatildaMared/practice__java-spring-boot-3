package com.matildamared;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());

        customerRepository.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable Integer id, @RequestBody NewCustomerRequest request) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());

        customerRepository.save(customer);
    }

    record NewCustomerRequest(String name, String email, Integer age) {
    }
}
