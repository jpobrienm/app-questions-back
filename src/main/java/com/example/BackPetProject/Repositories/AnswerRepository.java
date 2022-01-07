package com.example.BackPetProject.Repositories;

import com.example.BackPetProject.Collections.Answer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AnswerRepository extends ReactiveMongoRepository<Answer, String> {
}
