package com.kk.mongodbsetup.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public void doSomething() {
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));


        // fetch all customers
        LOGGER.info("Customers found with findAll():");
        LOGGER.info("-------------------------------");

        int customerNumber = 1;
        for (Customer customer : repository.findAll()) {
            LOGGER.info("user{} = {}", customerNumber, customer);
            customerNumber++;
        }
        LOGGER.info("");

        // fetch an individual customer
        LOGGER.info("Customer found with findByFirstName('Alice'):");
        LOGGER.info("-------------------------------");
        LOGGER.info("customer alice = {}", repository.findByFirstName("Alice"));

        LOGGER.info("Customer found with findByLastName('Smith'):");
        LOGGER.info("-------------------------------");
        customerNumber = 1;
        for (Customer customer : repository.findByLastName("Smith")) {
            LOGGER.info("user{} = {}", customerNumber, customer);
            customerNumber++;
        }
    }
}
