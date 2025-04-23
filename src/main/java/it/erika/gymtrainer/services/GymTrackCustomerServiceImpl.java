package it.erika.gymtrainer.services;

import it.erika.gymtrainer.configuration.MicroservicesProperties;
import it.erika.gymtrainer.dto.CustomerDto;
import it.erika.gymtrainer.dto.Page;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class GymTrackCustomerServiceImpl implements GymTrackCustomerService {

    private final RestClient restClient;
    private final MicroservicesProperties microservicesProperties;

    public GymTrackCustomerServiceImpl(RestClient restClient, MicroservicesProperties microservicesProperties) {
        this.restClient = restClient;
        this.microservicesProperties = microservicesProperties;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        Page<CustomerDto> page = restClient
                .get()
                .uri(microservicesProperties.gymTrack().url() + "/customer")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        return page.getContent();
    }
}
