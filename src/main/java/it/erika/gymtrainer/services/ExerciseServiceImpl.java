package it.erika.gymtrainer.services;

import it.erika.gymtrainer.dto.ExerciseDto;
import it.erika.gymtrainer.entities.Exercise;
import it.erika.gymtrainer.exceptions.EntityNotFoundException;
import it.erika.gymtrainer.mappers.ExerciseMapper;
import it.erika.gymtrainer.respositories.ExerciseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;
@Service
public class ExerciseServiceImpl implements ExerciseService{

    private final ExerciseRepository repository;
    private final ExerciseMapper mapper;

    public ExerciseServiceImpl(ExerciseRepository repository, ExerciseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ExerciseDto insertExercise(ExerciseDto dto) {
        Exercise entity = new Exercise();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setMuscleDistrict(dto.getMuscleDistrict());
        entity.setType(dto.getType());
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public ExerciseDto getExercise(String id) {
        Optional<Exercise> oEntity = repository.findById(id);
        if(oEntity.isEmpty()) {
            throw new EntityNotFoundException("Exercise not found");
        }
        var entity = oEntity.get();
        return mapper.toDto(entity);
    }

    @Override
    public Page<ExerciseDto> findAllExercises(Pageable pageable) {
        return repository.findAll(pageable).map(exercise -> mapper.toDto(exercise));
    }

    @Override
    @Transactional
    public void updateExercise(String id, ExerciseDto dto) {
        Optional<Exercise> oEntity = repository.findById(id);
        if(oEntity.isEmpty()) {
            throw new EntityNotFoundException("Exercise not found");
        }
        var entity = oEntity.get();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setMuscleDistrict(dto.getMuscleDistrict());
        entity.setType(dto.getType());
    }

    @Override
    public void deleteExercise(String id) {
        repository.deleteById(id);
    }
}
