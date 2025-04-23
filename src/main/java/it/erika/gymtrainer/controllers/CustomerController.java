package it.erika.gymtrainer.controllers;

import it.erika.gymtrainer.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping(path = "sync")
    public void syncCustomers() {
        service.syncCustomers();
    }
}
