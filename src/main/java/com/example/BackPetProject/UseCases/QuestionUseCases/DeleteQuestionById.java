package com.example.BackPetProject.UseCases.QuestionUseCases;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteQuestionById {
    Mono<Void> deleteQuestionById(String id);
}
