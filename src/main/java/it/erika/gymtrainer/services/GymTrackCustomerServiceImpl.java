package it.erika.gymtrainer.services;

import it.erika.gymtrainer.configuration.MicroservicesProperties;
import it.erika.gymtrainer.dto.CustomerDto;
import it.erika.gymtrainer.dto.Page;
import java.util.List;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Log4j2
public class GymTrackCustomerServiceImpl implements GymTrackCustomerService {

    private final RestClient restClient;
    private final MicroservicesProperties microservicesProperties;

    public GymTrackCustomerServiceImpl(RestClient restClient, MicroservicesProperties microservicesProperties) {
        this.restClient = restClient;
        this.microservicesProperties = microservicesProperties;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        // var url = microservicesProperties.gymTrack().url() + "/customer";
        var url = UriComponentsBuilder.fromUri(microservicesProperties.gymTrack().url())
                .pathSegment("customer")
                .queryParam("size", 50)
                .queryParam("number", 0)
                .build()
                .toUri();
        Page<CustomerDto> page = restClient
                .get()
                .uri(url)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        log.info("Invoked GET {} with pagination {}", url, page.getPage());
        return page.getContent();
    }
}

