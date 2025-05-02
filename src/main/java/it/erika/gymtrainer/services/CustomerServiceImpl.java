package it.erika.gymtrainer.services;

import it.erika.gymtrainer.dto.CustomerDto;
import it.erika.gymtrainer.dto.ExercisesSheet;
import it.erika.gymtrainer.entities.Customer;
import it.erika.gymtrainer.exceptions.EntityNotFoundException;
import it.erika.gymtrainer.mappers.CustomerMapper;
import it.erika.gymtrainer.respositories.CustomerRepository;
import java.util.List;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final GymTrackCustomerService gymTrackCustomerService;
    private final CustomerMapper mapper;

    public CustomerServiceImpl(
            CustomerRepository repository, GymTrackCustomerService gymTrackCustomerService, CustomerMapper mapper) {
        this.repository = repository;
        this.gymTrackCustomerService = gymTrackCustomerService;
        this.mapper = mapper;
    }

    @Override
    public void syncCustomers() {
        List<CustomerDto> customersList = gymTrackCustomerService.getCustomers();
        for(var customerDto : customersList) {
            log.info("Synchronizing customer with id {} and name {}", customerDto.getId(), customerDto.getName());
            if(!repository.existsById(customerDto.getId())) {
                log.info("New customer from GymTrack");
                var customer = mapper.toEntity(customerDto);
                repository.save(customer);
            } else {
                log.info("This customer already exists in GymTrainer, synchronization skipped");
            }
        }
    }

    @Override
    public CustomerDto getCustomer(String id) {
        return repository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    @Override
    public void setExercisesSheet(String id, ExercisesSheet exercisesSheet) {
        var customer = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        customer.setExercisesSheet(exercisesSheet);
        repository.save(customer);
    }
}
