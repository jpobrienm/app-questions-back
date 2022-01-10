package com.example.BackPetProject.Repositories;

import com.example.BackPetProject.Collections.Answer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AnswerRepository extends ReactiveMongoRepository<Answer, String> {
    Flux<Answer> findAllByParentId(String id);
    Mono<Void> deleteAllByParentId(String id);
}
