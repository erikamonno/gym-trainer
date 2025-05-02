package it.erika.gymtrainer.dto;

import java.util.List;
import lombok.Data;

@Data
public class ExercisesSheet {

    private List<TrainingSession> trainingSessions;
}
