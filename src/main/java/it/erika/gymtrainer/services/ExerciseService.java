package it.erika.gymtrainer.services;

import it.erika.gymtrainer.dto.ExerciseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExerciseService {

    ExerciseDto insertExercise(ExerciseDto dto);

    ExerciseDto getExercise(String id);

    Page<ExerciseDto> findAllExercises(Pageable pageable);

    void updateExercise(String id, ExerciseDto dto);

    void deleteExercise(String id);
}
