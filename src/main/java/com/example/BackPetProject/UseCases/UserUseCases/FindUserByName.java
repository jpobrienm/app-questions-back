package com.example.BackPetProject.UseCases.UserUseCases;

import com.example.BackPetProject.DTO.UserDto;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindUserByName {
    public Mono<UserDto> findByName(String name);
}
