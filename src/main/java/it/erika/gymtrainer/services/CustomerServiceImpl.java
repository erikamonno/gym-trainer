package it.erika.gymtrainer.services;

import it.erika.gymtrainer.dto.CustomerDto;
import it.erika.gymtrainer.mappers.CustomerMapper;
import it.erika.gymtrainer.respositories.CustomerRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
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
        customersList.stream().map(mapper::toEntity).forEach(repository::save);
    }
}
