package com.example.BackPetProject.UseCases.QuestionUseCases;

import com.example.BackPetProject.DTO.QuestionDto;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindAllQuestionsByUserId {
    Flux<QuestionDto> findAllByUserId(String id);
}
