package it.erika.gymtrainer.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ExerciseDto {

    private String id;

    private String name;

    private String description;

    private String muscleDistrict;

    private String type;
}
