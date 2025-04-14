package it.erika.gymtrainer.respositories;

import it.erika.gymtrainer.entities.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;
@Repository
public interface ExerciseRepository extends MongoRepository<Exercise, String> {

}
