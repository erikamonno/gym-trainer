package it.erika.gymtrainer.mappers;

import it.erika.gymtrainer.dto.CustomerDto;
import it.erika.gymtrainer.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerDto dto);

    CustomerDto toDto(Customer entity);
}
