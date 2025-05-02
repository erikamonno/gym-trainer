package it.erika.gymtrainer.services;

import it.erika.gymtrainer.configuration.MicroservicesProperties;
import it.erika.gymtrainer.dto.CustomerDto;
import it.erika.gymtrainer.dto.Page;
import java.util.ArrayList;
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
        Page<CustomerDto> page;
        var pageNumber = 0;
        List<CustomerDto> allCustomers = new ArrayList<>();
        do {
            var url = UriComponentsBuilder.fromUri(
                            microservicesProperties.gymTrack().url())
                    .pathSegment("customer")
                    .queryParam("size", 2)
                    .queryParam("page", pageNumber)
                    .build()
                    .toUri();
            page = restClient // il restClient ci serve per fare chiamate rest, quindi per riprodurre in codice le
                    // chiamate che faccio su postman
                    .get()
                    .uri(url)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {});

            allCustomers.addAll(page.getContent());
            log.info("Invoked GET {} with pagination {}", url, page.getPage());
        } while (++pageNumber < page.getPage().getTotalPages());

        return allCustomers;
    }
}
