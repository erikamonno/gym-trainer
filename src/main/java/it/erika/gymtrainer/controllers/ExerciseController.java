package it.erika.gymtrainer.controllers;

import it.erika.gymtrainer.dto.ExerciseDto;
import it.erika.gymtrainer.services.ExerciseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("exercises")
public class ExerciseController {

    private final ExerciseService service;

    public ExerciseController(ExerciseService service) {
        this.service = service;
    }

    @PostMapping
    public ExerciseDto insertExercise(@Valid @RequestBody ExerciseDto exerciseDto) {
        return service.insertExercise(exerciseDto);
    }

    @GetMapping("{id}")
    public ExerciseDto readExercise(@PathVariable String id) {
        return service.getExercise(id);
    }

    @GetMapping
    public Page<ExerciseDto> findAllExercises(@PageableDefault Pageable pageable) {
        return service.findAllExercises(pageable);
    }

    @PutMapping("{id}")
    public void updateExercise(@Valid @RequestBody ExerciseDto exerciseDto, @PathVariable String id) {
        service.updateExercise(id, exerciseDto);
    }

    @DeleteMapping("{id}")
    public void deleteExercise(@PathVariable String id) {
        service.deleteExercise(id);
    }
}
