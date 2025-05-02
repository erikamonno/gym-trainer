package it.erika.gymtrainer.dto;

import lombok.Data;

@Data
public class AssignedExercise {

    private Integer repetitions;

    private Integer sets;

    private String name;

    private String notes;
}
