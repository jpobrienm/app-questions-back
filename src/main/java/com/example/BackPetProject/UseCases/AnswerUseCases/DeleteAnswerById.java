package com.example.BackPetProject.UseCases.AnswerUseCases;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteAnswerById {
    Mono<Void> deleteAnswerById(String id);
}
