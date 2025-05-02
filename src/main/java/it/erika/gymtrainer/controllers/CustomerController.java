package it.erika.gymtrainer.controllers;

import it.erika.gymtrainer.dto.CustomerDto;
import it.erika.gymtrainer.dto.ExercisesSheet;
import it.erika.gymtrainer.services.CustomerService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public CustomerDto getCustomer(@PathVariable(name = "id") String id) {
        return service.getCustomer(id);
    }

    @PutMapping("{id}/exercisesSheet")
    public void setExercisesSheet(@PathVariable(name = "id") String id, @RequestBody ExercisesSheet exercisesSheet) {
        service.setExercisesSheet(id, exercisesSheet);
    }
}
