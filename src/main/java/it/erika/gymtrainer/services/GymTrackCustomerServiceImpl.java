package it.erika.gymtrainer.services;

import it.erika.gymtrainer.dto.CustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class GymTrackCustomerServiceImpl implements GymTrackCustomerService{

    private final RestClient restClient;

    public GymTrackCustomerServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        restClient.get().uri("http://localhost:8080");
        return null;
    }
}
