package com.example.BackPetProject.UseCases.AnswerUseCases;

import com.example.BackPetProject.DTO.AnswerDto;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateAnswer {
    public Mono<String> createAnswer(AnswerDto answerDto);
}
