package it.erika.gymtrainer.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "customer")
public class Customer {

    @Id
    private String id;

    private String name;

    private String surname;

    private String email;

    private String phone;

    private LocalDate birthDate;
}
