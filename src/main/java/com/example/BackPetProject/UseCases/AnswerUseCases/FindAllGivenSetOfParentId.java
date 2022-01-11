package com.example.BackPetProject.UseCases.AnswerUseCases;

import com.example.BackPetProject.DTO.AnswerDto;
import reactor.core.publisher.Flux;

import java.util.Set;

@FunctionalInterface
public interface FindAllGivenSetOfParentId {
    Flux<AnswerDto> findAllGivenSetOfParentId(Set<String> idSet);
}
