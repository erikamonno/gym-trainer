package it.erika.gymtrainer.entities;

import it.erika.gymtrainer.dto.ExercisesSheet;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    private ExercisesSheet exercisesSheet;
}
