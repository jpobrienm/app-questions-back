package com.example.BackPetProject.UseCases.QuestionUseCases;

import com.example.BackPetProject.DTO.QuestionDto;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindQuestionById {
    Mono<QuestionDto> findQuestionById(String id);
}
