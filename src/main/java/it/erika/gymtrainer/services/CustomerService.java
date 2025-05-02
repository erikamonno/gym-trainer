package it.erika.gymtrainer.services;

import it.erika.gymtrainer.dto.CustomerDto;
import it.erika.gymtrainer.dto.ExercisesSheet;

public interface CustomerService {

    void syncCustomers();

    CustomerDto getCustomer(String id);

    void setExercisesSheet(String id, ExercisesSheet exercisesSheet);
}
