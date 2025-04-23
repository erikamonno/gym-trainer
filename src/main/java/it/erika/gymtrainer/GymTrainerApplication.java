package it.erika.gymtrainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class GymTrainerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymTrainerApplication.class, args);
    }
}
