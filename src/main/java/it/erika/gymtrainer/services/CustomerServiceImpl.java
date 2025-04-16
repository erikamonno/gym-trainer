package it.erika.gymtrainer.services;

import it.erika.gymtrainer.dto.CustomerDto;
import it.erika.gymtrainer.respositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final GymTrackCustomerService gymTrackCustomerService;

    public CustomerServiceImpl(CustomerRepository repository, GymTrackCustomerService gymTrackCustomerService) {
        this.repository = repository;
        this.gymTrackCustomerService = gymTrackCustomerService;
    }

    @Override
    public void syncCustomers() {
        List<CustomerDto> customersList = gymTrackCustomerService.getCustomers();

    }
}
