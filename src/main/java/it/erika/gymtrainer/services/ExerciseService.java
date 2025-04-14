package it.erika.gymtrainer.services;

import it.erika.gymtrainer.dto.ExerciseDto;
import it.erika.gymtrainer.entities.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ExerciseService {

    ExerciseDto insertExercise(ExerciseDto dto);
    ExerciseDto getExercise(String id);
    Page<ExerciseDto> findAllExercises(Pageable pageable);
    void updateExercise(String id, ExerciseDto dto);
    void deleteExercise(String id);
}
