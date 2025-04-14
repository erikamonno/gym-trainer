package it.erika.gymtrainer.mappers;

import it.erika.gymtrainer.dto.ExerciseDto;
import it.erika.gymtrainer.entities.Exercise;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    ExerciseDto toDto(Exercise exercise);

    Exercise toEntity(ExerciseDto exerciseDto);
}
