package it.erika.gymtrainer.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "exercises")
@Data
public class Exercise {

    @Id
    private String id; // valore default nel costruttore

    private String name;

    private String description;

    private String muscleDistrict;

    private String type;
}
