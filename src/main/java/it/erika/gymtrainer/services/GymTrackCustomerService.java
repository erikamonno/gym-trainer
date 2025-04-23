package it.erika.gymtrainer.services;

import it.erika.gymtrainer.dto.CustomerDto;
import java.util.List;

public interface GymTrackCustomerService {

    List<CustomerDto> getCustomers();
}
