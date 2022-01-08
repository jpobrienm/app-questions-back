package com.example.BackPetProject.UseCases.AnswerUseCases;

import com.example.BackPetProject.DTO.AnswerDto;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindAllByParentId {
    Flux<AnswerDto> findAllByParentId(String id);
}
