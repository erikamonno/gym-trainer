package it.erika.gymtrainer.respositories;

import it.erika.gymtrainer.entities.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends MongoRepository<Exercise, String> {}
