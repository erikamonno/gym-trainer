package it.erika.gymtrainer.dto;

import java.util.List;
import lombok.Data;

@Data
public class TrainingSession {

    private String title;

    private List<AssignedExercise> assignedExercises;
}
